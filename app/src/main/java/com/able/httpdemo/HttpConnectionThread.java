package com.able.httpdemo;

import android.os.Handler;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConnectionThread extends Thread{

    private Handler handler;
    private TextView textView;
    private String url;

    public HttpConnectionThread(Handler handler,TextView textView,String url){
        this.handler=handler;
        this.textView=textView;
        this.url=url;
    }


    @Override
    public void run() {
        try {
            URL url = new URL(this.url);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            //设置连接超时
            urlConnection.setConnectTimeout(15000);
            //设置读取超时
            urlConnection.setReadTimeout(15000);
            //设置网络请求方法
            urlConnection.setRequestMethod("GET");
//            final String responseMessage = urlConnection.getResponseMessage();
            //连接
            urlConnection.connect();
            int responseCode = urlConnection.getResponseCode();
            String str;
            if(responseCode==HttpURLConnection.HTTP_OK)
            {
                InputStream inputStream = urlConnection.getInputStream();
                final StringBuffer stringBuffer=new StringBuffer();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                while ((str=bufferedReader.readLine())!=null){
                    stringBuffer.append(str);
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(stringBuffer.toString());
                    }
                });
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
