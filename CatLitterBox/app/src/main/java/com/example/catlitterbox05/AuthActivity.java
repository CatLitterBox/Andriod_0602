package com.example.catlitterbox05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AuthActivity extends AppCompatActivity {

    private TextView serialNum;
    private Button okBtn;

    private NetworkService networkService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        serialNum = (TextView)findViewById(R.id.serialNum);
        okBtn = (Button)findViewById(R.id.okBtn);

        ApplicationController application = ApplicationController.getInstance();
        application.buildNetworkService("http://52.78.207.144/application/matchSerialNum.php");
        networkService = ApplicationController.getInstance().getNetworkService();

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String serial_Num = serialNum.getText().toString();

                Call<user_info>  thumbnailCall =  networkService.getSerialNum(serial_Num);
                thumbnailCall.enqueue(new Callback<user_info>() {
                    @Override
                    public void onResponse(Call<user_info> call, Response<user_info> response) {
                        if(response.isSuccessful()) {
                            startActivity(new Intent(AuthActivity.this, MainActivity.class));
                        }
                        else {
                            Toast.makeText(getBaseContext(), "등록되지 않은 시리얼 번호입니다.",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<user_info> call, Throwable t) {

                    }

                });
            }
        });

    }
/*
    public void authOK(View view) {
        startActivity(new Intent(this, MainActivity.class));
    } */

}
