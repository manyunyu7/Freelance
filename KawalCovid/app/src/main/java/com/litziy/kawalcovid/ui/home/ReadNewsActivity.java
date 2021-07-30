package com.litziy.kawalcovid.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;

import com.bumptech.glide.Glide;
import com.litziy.kawalcovid.R;
import com.litziy.kawalcovid.databinding.ActivityReadNewsBinding;

public class ReadNewsActivity extends AppCompatActivity {

    ActivityReadNewsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityReadNewsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        News.New model = getIntent().getParcelableExtra("data");

        Glide.with(binding.getRoot())
                .load(model.getCoverLink())
                .into(binding.ivDetNewsImg);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.tvDetailNewsContent.setText(Html.fromHtml(model.getContent(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            binding.tvDetailNewsContent.setText(Html.fromHtml(model.getContent()));
        }

        binding.tvDetailNewsAuthor.setText(model.getAuthor());
        binding.tvDetNewsTitle.setText(model.getTitle());

        binding.btnCloseDetailNews.setOnClickListener(v -> {
            finish();
            super.onBackPressed();
        });

    }
}