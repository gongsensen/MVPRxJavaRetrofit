package com.powersen.app;

import android.app.Application;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lenovo on 2017/11/22.
 *
 * 在Androidmainfeast文件里 android:name=".app.AppOk"
 */

public class AppOk extends Application {
    /**
     * 创建APP继承application，在程序入口处初始化OKHTTP
     */
    private static OkHttpClient okHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();

        //建议一个app只有一个OkHttpClient实例
        okHttpClient = new OkHttpClient();
        okHttpClient = okHttpClient.newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
//              .addInterceptor(new MyLogInterceptor())//拦截器这块注释了，想添加时调用方法就可以
                .build();
    }

    public static OkHttpClient okHttpClient() {
        return okHttpClient;
    }

    //这是自己写的拦截器，不用管，也不要用
    //拦截器,可以修改header,可以通过拦截器打印日志
    public class MyLogInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request().newBuilder()
                    .header("shenfenyanzheng", "zhangsan")
                    .build();
            HttpUrl url = request.url();
            String httpUrl = url.url().toString();
            Response response = chain.proceed(request);
            int code = response.code();
            return response;
        }
    }
}
