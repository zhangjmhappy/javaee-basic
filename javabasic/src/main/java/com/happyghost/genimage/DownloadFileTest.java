package com.happyghost.genimage;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author HappyGhost
 * @create 2019-08-22 23:46
 **/
public class DownloadFileTest {

    public static void main(String[] args) {

        try {
            getDownloadResource("https://www.btbttpic.com/upload/attach/000/128/3b3004937f605a7399a55d120df72bec.rar", "E:\\cc.rar");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void getDownloadResource(String url, String filePath) throws IOException {

        File file = new File(filePath);

        if (!file.exists()) {
            file.createNewFile();
        }

        try {
            OutputStream out = new FileOutputStream(file);

            // Method1
//            downLoadByJdk(url, out);

            downLoadByHttpClient(url, out);
            // method2
            // downLoadByHttpCommons(url, out);
            // method3
//            downloadByCommonsHttpclient(url, out);

        } catch (Exception e) {

        }
    }

    public static void downLoadByJdk(String url, OutputStream out) {
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            IOUtils.copy(conn.getInputStream(), out);
            out.close();
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
    }

    public static void downLoadByHttpClient(String url, OutputStream out) throws IOException {

        //创建httpclient实例，采用默认的参数配置
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet get = new HttpGet(url);   //使用Get方法提交

        //请求的参数配置，分别设置连接池获取连接的超时时间，连接上服务器的时间，服务器返回数据的时间
        RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(3000000)
                .setConnectTimeout(3000000)
                .setSocketTimeout(3000000)
                .build();
        //配置信息添加到Get请求中
        get.setConfig(config);
        //通过httpclient的execute提交 请求 ，并用CloseableHttpResponse接受返回信息
        CloseableHttpResponse response = httpClient.execute(get);
        //服务器返回的状态
        int statusCode = response.getStatusLine().getStatusCode();
        //判断返回的状态码是否是200 ，200 代表服务器响应成功，并成功返回信息
        if (statusCode == HttpStatus.SC_OK) {
            //EntityUtils 获取返回的信息。官方不建议使用使用此类来处理信息
//            System.out.println("Demo.example -------->" + EntityUtils.toString(response.getEntity() , Consts.UTF_8));
            IOUtils.copy(response.getEntity().getContent(), out);
            out.flush();
            out.close();
        } else {
            System.out.println("Demo.example -------->" + "获取信息失败");
        }
    }

}
