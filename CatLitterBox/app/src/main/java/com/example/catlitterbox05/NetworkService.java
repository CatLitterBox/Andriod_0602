package com.example.catlitterbox05;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by 박지현 on 2017-05-31.
 */

public interface NetworkService {
    @GET("/user_info/{serial_num}")
    Call<user_info> getSerialNum(@Path("serial_num") String serial_num);
}
