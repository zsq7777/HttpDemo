package com.able.httpdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FormUrlEncoded;

public class MainActivity extends AppCompatActivity {


    //聚合数据
    String appkey = "e201160722b2f9f7e11d45a2e9958037";
    String url="http://v.juhe.cn/todayOnhistory/queryEvent.php?date=1/1&key=e201160722b2f9f7e11d45a2e9958037";
    String url1="http://v.juhe.cn/todayOnhistory/queryEvent.php";

    private static final String TAG = "MainActivity";
    private Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mBtnRetrofit = findViewById(R.id.btn_retrofit_request);
        Button mBtnHttpConnection = findViewById(R.id.btn_httpConnection_request);
        Button mBtnOkhttp = findViewById(R.id.btn_okhttp);
        Button mBtnOkhttpPost = findViewById(R.id.btn_okhttp_post);
        final TextView mTvContent = findViewById(R.id.tv_content);

        mBtnRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrofitRequest();
            }
        });
        mBtnHttpConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               new HttpConnectionThread(handler,mTvContent,url).start();
            }
        });
        mBtnOkhttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                okhttpRequest();
            }
        });
        mBtnOkhttpPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                okhttpRequestPost();
            }
        });


    }

    private void okhttpRequestPost() {
        //1.创建OkHttpClient对象
        OkHttpClient okHttpClient=new OkHttpClient();

        //通过new FormBody()调用builder（）创建一个RequestBody,可以用add添加键值对 然后 builder
        Request.Builder builder = new Request.Builder();

        // 表单提交
        RequestBody requestBody = new FormBody.Builder().add("key", appkey).add("date", "1/1").build();
        // 字符串提交
//        MediaType mediaType=MediaType.parse("application/json; charset=utf-8");
//        String value="{username:admin;password:admin}";
//        RequestBody requestBody = RequestBody.create(mediaType, value);


        //获取一个request对象
        final Request request = builder.url(url1).post(requestBody).build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Log.i(TAG, "onResponse:POST请求 "+s);
            }
        });

    }

    private void okhttpRequest() {
        OkHttpClient okHttpClient=new OkHttpClient();

        //这是request
        Request.Builder builder = new Request.Builder();
        Request request = builder.get().url(url).build();

        //call
        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure: "+e.getMessage() );
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.i(TAG, "onResponse: "+string);
            }
        });


    }

    private void retrofitRequest() {
        //步骤4：创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://v.juhe.cn/todayOnhistory/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava
                .build();

        // 步骤5：创建 网络请求接口 的实例
        ApiService apiService = retrofit.create(ApiService.class);

        // 步骤6：采用Observable<...>形式 对 网络请求 进行封装
        Observable<HistoryModel> historyDay = apiService.getHistoryDay("1/1", appkey);


        // 步骤7：发送网络请求
        historyDay.subscribeOn(Schedulers.io())               // 在IO线程进行网络请求
                .observeOn(AndroidSchedulers.mainThread())  // 回到主线程 处理请求结果
                .subscribe(new Observer<HistoryModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "开始采用subscribe连接");
                    }

                    @Override
                    public void onNext(HistoryModel result) {
                        // 步骤8：对返回的数据进行处理
                        List<HistoryModel.ResultBean> result1 = result.getResult();
                        Log.i(TAG, "onNext: " + result1.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "请求成功");
                    }
                });
    }

}
