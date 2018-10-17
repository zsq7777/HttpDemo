package com.able.httpdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    //聚合数据
    String appkey = "e201160722b2f9f7e11d45a2e9958037";
    String url="http://v.juhe.cn/todayOnhistory/queryEvent.php?date=1/1&key=e201160722b2f9f7e11d45a2e9958037";

    private static final String TAG = "MainActivity";
    private Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mBtnRetrofit = findViewById(R.id.btn_retrofit_request);
        Button mBtnHttpConnection = findViewById(R.id.btn_httpConnection_request);
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
