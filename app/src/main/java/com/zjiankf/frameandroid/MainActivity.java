package com.zjiankf.frameandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient  = new OkHttpClient.Builder()
                        .connectTimeout(10, TimeUnit.SECONDS)
                        .writeTimeout(10,TimeUnit.SECONDS)
                        .readTimeout(20, TimeUnit.SECONDS)
                        .build();

                //post方式提交的数据
                FormBody formBody = new FormBody.Builder()
                        .add("clientType", "20")
                        .add("userName", "admin")
                        .add("serverId", "0")
                        .add("password", "11111")
                        .build();

                final Request request = new Request.Builder()
                        .url("http://202.102.20.48:3000/webfolder/services/json/login/getAccessToken")//请求的url
                        .post(formBody)
                        .build();


                //创建/Call
                Call call = okHttpClient.newCall(request);
                //加入队列 异步操作
                call.enqueue(new Callback() {
                    //请求错误回调方法
                    @Override
                    public void onFailure(Call call, IOException e) {
                        System.out.println("连接失败");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if(response.code()==200) {
                            System.out.println(response.body().string());
                        }
                    }
                });
            }
        }).start();
    }
}
