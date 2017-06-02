package com.example.catlitterbox05;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 박지현 on 2017-05-31.
 * 서버와 통신하기 위한 코드
 * 시리얼 넘버 검색
 */

public class ApplicationController extends Application {

    private static ApplicationController instance;
    public static ApplicationController getInstance(){return instance;}

    @Override
    public void onCreate(){
        super.onCreate();
        ApplicationController.instance = this;
    }

    private NetworkService networkService;
    public NetworkService getNetworkService(){return networkService;}

    private String baseUrl;

    public void buildNetworkService(String ip) {
        synchronized (ApplicationController.class) {
            if(networkService == null) {
                baseUrl = "http://52.78.207.144/application/matchSerialNum.php";
                Gson gson = new GsonBuilder().create();

                GsonConverterFactory factory = GsonConverterFactory.create(gson);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(factory)
                        .build();
                networkService = retrofit.create(NetworkService.class);
            }
        }
    }
}
