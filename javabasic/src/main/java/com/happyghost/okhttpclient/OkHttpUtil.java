package com.happyghost.okhttpclient;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * https://www.jianshu.com/p/f2bc0a1e9d02
 * okhttp请求类
 */
public class OkHttpUtil
{

    /**
     * 同步get请求
     */
    public static void syncGet() throws Exception{
        String urlBaidu = "http://www.baidu.com/";
        OkHttpClient okHttpClient = new OkHttpClient(); // 创建OkHttpClient对象
        Request request = new Request.Builder().url(urlBaidu).build(); // 创建一个请求
        Response response = okHttpClient.newCall(request).execute(); // 返回实体
        if (response.isSuccessful()) { // 判断是否成功
            /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
             * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
             * 因为string() 方法会将整个文档加载到内存中。*/
            System.out.println(response.body().string()); // 打印数据
        }else {
            System.out.println("失败"); // 链接失败
        }
    }

    /**
     * 异步Get请求
     */
    public static void asyncGet() {
        String urlBaidu = "http://www.baidu.com/";
        OkHttpClient okHttpClient = new OkHttpClient(); // 创建OkHttpClient对象
        Request request = new Request.Builder().url(urlBaidu).build(); // 创建一个请求
        okHttpClient.newCall(request).enqueue(new Callback() { // 回调

            public void onResponse(Call call, Response response) throws IOException {
                // 请求成功调用，该回调在子线程
                System.out.println(response.body().string());
            }

            public void onFailure(Call call, IOException e) {
                // 请求失败调用
                System.out.println(e.getMessage());
            }
        });
    }

    /**
     * Post提交表单
     */
    public static void postFromParameters() {
        String url = "http://v.juhe.cn/wepiao/query"; // 请求链接
        String KEY = "9488373060c8483a3ef6333353fdc7fe"; // 请求参数
        OkHttpClient okHttpClient = new OkHttpClient(); // OkHttpClient对象
        RequestBody formBody = new FormBody.Builder().add("key", KEY).build(); // 表单键值对
        Request request = new Request.Builder().url(url).post(formBody).build(); // 请求
        okHttpClient.newCall(request).enqueue(new Callback() {// 回调

            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());//成功后的回调
            }

            public void onFailure(Call call, IOException e) {
                System.out.println(e.getMessage());//失败后的回调
            }
        });
    }

    /**
     * Post提交字符串
     * 使用Post方法发送一串字符串，但不建议发送超过1M的文本信息
     */
    public static void postStringParameters(){
        MediaType MEDIA_TYPE = MediaType.parse("text/text; charset=utf-8");
        String url = "http://v.juhe.cn/wepiao/query"; // 请求链接
        OkHttpClient okHttpClient = new OkHttpClient(); // OkHttpClient对象
        String string = "key=9488373060c8483a3ef6333353fdc7fe"; // 要发送的字符串
        /**
         * RequestBody.create(MEDIA_TYPE, string)
         * 第二个参数可以分别为：byte[]，byteString,File,String。
         */
        Request request = new Request.Builder().url(url)
                .post(RequestBody.create(MEDIA_TYPE,string)).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }

            public void onFailure(Call call, IOException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    /**
     * Gson解析Response的Gson对象
     */
    public static void gsonResponsePost() {
        String url = "http://v.juhe.cn/wepiao/query"; // 请求链接
        String KEY = "9488373060c8483a3ef6333353fdc7fe"; // 请求参数
        OkHttpClient okHttpClient = new OkHttpClient(); // OkHttpClient对象
        RequestBody formBody = new FormBody.Builder().add("key", KEY).build(); // 表单键值对
        Request request = new Request.Builder().url(url).post(formBody).build(); // 请求
        okHttpClient.newCall(request).enqueue(new Callback() {// 回调

            public void onResponse(Call call, Response response) throws IOException {
                //成功后的回调
                Gson gson = new Gson();
                Info info = gson.fromJson(response.body().string(), Info.class);
                System.out.println(info.toString());
            }

            public void onFailure(Call call, IOException e) {
                System.out.println(e.getMessage());//失败后的回调
            }
        });
    }
    /**
     * Java Bean
     */
    public class Info{
        int error_code; //状态码
        String reason; // 返回状态文字
        Result result; // 页面URL
        @Override
        public String toString() {
            return "Info [error_code=" + error_code + ", reason=" + reason + ", result=" + result.toString() + "]";
        }
    }
    /**
     * Java Bean
     */
    public class Result{
        String h5url;
        String h5weixin;
        @Override
        public String toString() {
            return "Result [h5url=" + h5url + ", h5weixin=" + h5weixin + "]";
        }
    }

    /**
     * 设置超时
     * @throws IOException
     */
    public static void timeOutPost() throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)//设置链接超时
                .writeTimeout(10, TimeUnit.SECONDS) // 设置写数据超时
                .readTimeout(30, TimeUnit.SECONDS) // 设置读数据超时
                .build();
        Request request = new Request.Builder().url("http://www.baidu.com/").build();

        Response response = client.newCall(request).execute();
        System.out.println("Response completed: " + response);
    }


    /**
     * 缓存设置
     * @throws Exception
     */
    public static void cachePost() throws Exception {
        File sdcache = new File("D:/file");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB

        OkHttpClient client = new OkHttpClient.Builder()
                .cache(new Cache(sdcache.getAbsoluteFile(), cacheSize))
                .build();
        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();

        Response response1 = client.newCall(request).execute();
        if (!response1.isSuccessful()) throw new IOException("Unexpected code " + response1);

        String response1Body = response1.body().string();
        System.out.println("Response 1 response:          " + response1);
        System.out.println("Response 1 cache response:    " + response1.cacheResponse());
        System.out.println("Response 1 network response:  " + response1.networkResponse());

        request = request.newBuilder().cacheControl(CacheControl.FORCE_NETWORK).build();
        Response response2 = client.newCall(request).execute();
        if (!response2.isSuccessful()) throw new IOException("Unexpected code " + response2);

        String response2Body = response2.body().string();
        System.out.println("Response 2 response:          " + response2);
        System.out.println("Response 2 cache response:    " + response2.cacheResponse());
        System.out.println("Response 2 network response:  " + response2.networkResponse());

        System.out.println("Response 2 equals Response 1? " + response1Body.equals(response2Body));
    }


    /**
     * 所有HTTP请求的代理设置，超时，缓存设置等都需要在OkHttpClient中设置。 如果需要更改一个请求的配置，可以使用
     * OkHttpClient.newBuilder()获取一个builder对象，
     * 该builder对象与原来OkHttpClient共享相同的连接池，配置等。
     */
    public static void shareClient() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.baidu.com/").build();

        try {
            // Copy to customize OkHttp for this request.
            OkHttpClient copy = client.newBuilder().readTimeout(500, TimeUnit.MILLISECONDS).build();
            Response response = copy.newCall(request).execute();
            System.out.println("Response 1 succeeded: " + response);
        } catch (IOException e) {
            System.out.println("Response 1 failed: " + e);
        }

        try {
            // Copy to customize OkHttp for this request.
            OkHttpClient copy = client.newBuilder().readTimeout(3000, TimeUnit.MILLISECONDS).build();
            Response response = copy.newCall(request).execute();
            System.out.println("Response 2 succeeded: " + response);
        } catch (IOException e) {
            System.out.println("Response 2 failed: " + e);
        }
    }


    /**
     * 登录验证
     * @throws IOException
     */
    public static void authenticatorPost() throws IOException {
        OkHttpClient okHttpClient =
                new OkHttpClient
                        .Builder()
                        .authenticator(new Authenticator() {

                            public Request authenticate(Route route, Response response) throws IOException {
                                System.out.println(response.challenges().toString());
                                String credential = Credentials.basic("jesse", "password1");
                                return response
                                        .request()
                                        .newBuilder()
                                        .addHeader("Authorization", credential)
                                        .build();
                            }
                        })
                        .build();
        Request request = new Request.Builder().url("http://publicobject.com/secrets/hellosecret.txt").build();
        Response response = okHttpClient.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        System.out.println(response.body().string());
    }

    
    //测试一波
    public static void main(String[] args)
    {

        try {
            //asyncGet();
            //postFromParameters();

            authenticatorPost();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


 

 
}
