package com.arkarzaw.asartaline;

import com.arkarzaw.asartaline.datas.WarDeeResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ASarTaLineAPI {

    @FormUrlEncoded
    @POST("GetWarDee.php")
    Observable<WarDeeResponse> getWarDeeItems(@Field("access_token") String access_token);
}
