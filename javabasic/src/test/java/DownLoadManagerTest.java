import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DownLoadManagerTest {

    /**
     * 线程池的基本大小
     */
    static int corePoolSize = 10;
    /**
     * 线程池最大数量
     */
    static int maximumPoolSizeSize = 100;
    /**
     * 线程活动保持时间
     */
    static long keepAliveTime = 1;

    static String realUrl;
    /**
     * 任务队列
     */
    static ArrayBlockingQueue workQueue = new ArrayBlockingQueue(10);

    ThreadPoolExecutor executor = new ThreadPoolExecutor(
            corePoolSize,
            maximumPoolSizeSize,
            keepAliveTime,
            TimeUnit.SECONDS,
            workQueue,
            new ThreadFactoryBuilder().setNameFormat("XX-task-%d").build());

    //private static final Logger LOGGER = LoggerFactory.getLogger(DownLoadManagerTest.class);

    /**
     * 每个线程下载的字节数
     */

    private long unitSize = 1000 * 1024;

//	private TaskExecutor taskExecutor;

    private CloseableHttpClient httpClient;

    private Long starttimes;

    private Long endtimes;

    @Before
    public void setUp() throws Exception {
        starttimes = System.currentTimeMillis();
        System.out.println("测试开始....");
    }

    @After
    public void tearDown() throws Exception {
        endtimes = System.currentTimeMillis();
        System.out.println("测试结束!!");
        System.out.println("********************");
        System.out.println("下载总耗时:" + (endtimes - starttimes) / 1000 + "s");
        System.out.println("********************");
    }

    public DownLoadManagerTest() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

        System.out.println("初始化测试类....");
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(100);

//        // use the TrustSelfSignedStrategy to allow Self Signed Certificates
//        SSLContext sslContext = SSLContextBuilder
//                .create()
//                .loadTrustMaterial(new TrustSelfSignedStrategy())
//                .build();
//
//        // we can optionally disable hostname verification.
//        // if you don't want to further weaken the security, you don't have to include this.
//        HostnameVerifier allowAllHosts = new NoopHostnameVerifier();
//
//        // create an SSL Socket Factory to use the SSLContext with the trust self signed certificate strategy
//        // and allow all hosts verifier.
//        SSLConnectionSocketFactory connectionFactory = new SSLConnectionSocketFactory(sslContext, allowAllHosts);

        SSLContext sslContext = SSLContexts.custom()
                .loadTrustMaterial((chain, authType) -> true).build();

        SSLConnectionSocketFactory sslConnectionSocketFactory =
                new SSLConnectionSocketFactory(sslContext, new String[]
                        {"SSLv2Hello", "SSLv3", "TLSv1","TLSv1.1", "TLSv1.2" }, null,
                        NoopHostnameVerifier.INSTANCE);


        PoolingHttpClientConnectionManager connectionManager = new
                PoolingHttpClientConnectionManager(RegistryBuilder.
                <ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", sslConnectionSocketFactory).build());

        httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();

    }

    /**
     * 启动多个线程下载文件
     */
    @Test
    public void doDownload() throws IOException {


        String remoteFileUrl = "http://www.3btbtt.com/attach-download-fid-8-aid-128011.htm";
        String localPath = "E://test//";

        String fileName = new URL(remoteFileUrl).getFile();

        System.out.println("远程文件名称：" + fileName);
        fileName = fileName.substring(fileName.lastIndexOf("/") + 1,
                fileName.length()).replace("%20", " ");
        System.out.println("本地文件名称：" + fileName);
        long fileSize = this.getRemoteFileSize(remoteFileUrl);

        this.createFile(localPath + System.currentTimeMillis() + fileName, fileSize);

        Long threadCount = (fileSize / unitSize) + (fileSize % unitSize != 0 ? 1 : 0);
        long offset = 0;

        CountDownLatch end = new CountDownLatch(threadCount.intValue());

        if (fileSize <= unitSize) {// 如果远程文件尺寸小于等于unitSize

            DownloadThreadTest downloadThread = new DownloadThreadTest(remoteFileUrl,

                    localPath + fileName, offset, fileSize, end, httpClient);

//			taskExecutor.execute(downloadThread);
            executor.execute(downloadThread);

        } else {// 如果远程文件尺寸大于unitSize

            for (int i = 1; i < threadCount; i++) {

                DownloadThreadTest downloadThread = new DownloadThreadTest(

                        realUrl, localPath + fileName, offset, unitSize, end, httpClient);

//				taskExecutor.execute(downloadThread);
                executor.execute(downloadThread);
                offset = offset + unitSize;

            }

            if (fileSize % unitSize != 0) {// 如果不能整除，则需要再创建一个线程下载剩余字节

                DownloadThreadTest downloadThread = new DownloadThreadTest(remoteFileUrl, localPath + fileName, offset, fileSize - unitSize * (threadCount - 1), end, httpClient);
//				taskExecutor.execute(downloadThread);
                executor.execute(downloadThread);
            }

        }
        try {
            end.await();
        } catch (InterruptedException e) {
//			LOGGER.error("DownLoadManager exception msg:{}",ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
		System.out.println("111111");
//		LOGGER.debug("下载完成！{} ",localPath+fileName);
        //return localPath+fileName;
    }

    /**
     * 获取远程文件尺寸
     */

    private long getRemoteFileSize(String remoteFileUrl) throws IOException {

        long fileSize = 0;

        URL serverUrl ;
        HttpURLConnection conn = (HttpURLConnection) new URL(remoteFileUrl).openConnection();
        conn.setRequestMethod("GET");
        //必须设置false，否则会自动redirect到重定向后的地址
        conn.setInstanceFollowRedirects(false);
        conn.addRequestProperty("Accept-Charset", "UTF-8;");
        conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");
//		conn.addRequestProperty("Referer", "http://matols.com/");
        conn.connect();

        //判定是否会进行302重定向
        if (conn.getResponseCode() == 302) {
            //如果会重定向，保存302重定向地址，以及Cookies,然后重新发送请求(模拟请求)
            String location = conn.getHeaderField("Location");
            String cookies = conn.getHeaderField("Set-Cookie");
//            downLoadFile(location);

            serverUrl = new URL(location);
            realUrl =location;
            conn = (HttpURLConnection) serverUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Cookie", cookies);
            conn.addRequestProperty("Accept-Charset", "UTF-8;");
            conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");
//			conn.addRequestProperty("Referer", "http://matols.com/");
            conn.connect();
            System.out.println("跳转地址:" + location);


            int responseCode = conn.getResponseCode();

            if (responseCode >= 400) {
//			LOGGER.debug("Web服务器响应错误!");
                return 0;

            }
            String sHeader;

            for (int i = 1; ; i++) {

                sHeader = conn.getHeaderFieldKey(i);

                if (sHeader != null && sHeader.equals("Content-Length")) {

                    System.out.println("文件大小ContentLength:"
                            + conn.getContentLength());

                    fileSize = Long.parseLong(conn
                            .getHeaderField(sHeader));

                    break;
                }
            }

        }
        return fileSize;
    }

    /**
     * 创建指定大小的文件
     */

    private void createFile(String fileName, long fileSize) throws IOException {

        File newFile = new File(fileName);

        RandomAccessFile raf = new RandomAccessFile(newFile, "rw");

        raf.setLength(fileSize);

        raf.close();

    }

    public void downLoadFile(String url) throws IOException {

        // 生成一个httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        InputStream in = entity.getContent();

        File file = new File("E://test/1231323123.rar");//这里为存储路径/xx/xx..

        FileOutputStream fout = new FileOutputStream(file);
        int a = -1;
        byte[] tmp = new byte[1024];
        while ((a = in.read(tmp)) != -1) {
            fout.write(tmp, 0, a);
            //注意这里如果用OutputStream.write(buff)的话，图片会失真，大家可以试试
        }
        fout.flush();
        fout.close();
        in.close();
        httpclient.close();

    }

//	public TaskExecutor getTaskExecutor() {
//		return taskExecutor;
//	}
//
//	public void setTaskExecutor(TaskExecutor taskExecutor) {
//		this.taskExecutor = taskExecutor;
//	}


}