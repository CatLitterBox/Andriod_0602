package com.example.catlitterbox05;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;

import java.util.Set;

import retrofit2.http.Url;

public class SettingActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 100;
    Url imageURL;
    ImageView catImage;
    Button catBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Button calendarBtn = (Button) findViewById(R.id.calendarBtn);
        calendarBtn.setOnClickListener(new View.OnClickListener () {
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        Button mainBtn = (Button) findViewById(R.id.mainBtn);
        mainBtn.setOnClickListener(new View.OnClickListener () {
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        catImage = (ImageView) findViewById(R.id.catImage);
        catBtn = (Button) findViewById(R.id.catBtn);

        catBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openGallery();
            }
        });
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==PICK_IMAGE){
            imageURL = (Url) data.getData();
            catImage.setImageURI((Uri) imageURL);
        }
    }
}