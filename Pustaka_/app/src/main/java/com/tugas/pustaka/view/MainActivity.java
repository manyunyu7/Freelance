package com.tugas.pustaka.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tugas.pustaka.R;
import com.tugas.pustaka.databinding.ActivityMainBinding;
import com.tugas.pustaka.model.Book;
import com.tugas.pustaka.util.BookServiceInterface;
import com.tugas.pustaka.util.RestClient;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding activityMainBinding;
    BookServiceInterface mApiInterface;
    int state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());


        int[] cursorImage = {
                R.drawable.ic_cursor1,
                R.drawable.ic_cursor2,
                R.drawable.ic_cursor3,
        };

        int[] onBoardImage = {
                R.drawable.ic_onboarding1,
                R.drawable.ic_onboarding2,
                R.drawable.ic_onboarding3,
        };

        String[] textList = {
                getString(R.string.start_reading_for_your_future_investment),
                getString(R.string.keep_upgraded),
                getString(R.string.only_best_book)
        };

        activityMainBinding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state++;
                if (state < textList.length) {
                    activityMainBinding.title.setText(textList[state]);
                    activityMainBinding.imageCursor.setBackgroundResource(cursorImage[state]);
                    activityMainBinding.imageOnboarding.setBackgroundResource(onBoardImage[state]);
                } else {
                    Intent intent = new Intent(activityMainBinding.getRoot().getContext(), RecyclerActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}