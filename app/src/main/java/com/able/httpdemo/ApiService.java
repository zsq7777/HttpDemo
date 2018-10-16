package com.able.httpdemo;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    /**
     * 历史上的今天
     *
     * @param date
     * @param key
     * @return
     */
    @POST("queryEvent.php")
    @FormUrlEncoded
    Observable<HistoryModel> getHistoryDay(@Field("date") String date, @Field("key") String key);

}
