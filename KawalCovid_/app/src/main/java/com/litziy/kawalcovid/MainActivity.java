package com.litziy.kawalcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.litziy.kawalcovid.databinding.ActivityMainBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    Date date;
    String meTime = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setUpClock();

        binding.btnInitLogin.setOnClickListener(v -> {
            startActivity(new Intent(this,HomeActivity.class));
        });
    }

    void setUpClock(){
        SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss");
        date=new Date();
        meTime = sdf.format(date);

        String displayedDate = DateFormat.getDateInstance(DateFormat.ERA_FIELD).format(new Date());

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    Date date = new Date();
                    meTime = sdf.format(date);
                    binding.textB.setText(meTime);
                });
            }
        }, 0, 1000);//1000 is a Refreshing Time (1second)

        binding.textU.setText(displayedDate);

    }

}