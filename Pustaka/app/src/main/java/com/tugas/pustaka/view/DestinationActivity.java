package com.tugas.pustaka.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.tugas.pustaka.databinding.ActivityDestinationBinding;
import com.tugas.pustaka.util.RestClient;

public class DestinationActivity extends AppCompatActivity {

    ActivityDestinationBinding vbind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vbind = ActivityDestinationBinding.inflate(getLayoutInflater());
        setContentView(vbind.getRoot());

        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        String poster = getIntent().getStringExtra("poster");
        String author = getIntent().getStringExtra("author");
        String book = getIntent().getStringExtra("book");

        vbind.btnReadBook.setOnClickListener(v -> {
            Intent intent = new Intent(this, ReadBookActivity.class);
            intent.putExtra("book", book);
            startActivity(intent);
        });

        vbind.labelBookAuthor.setText(author);
        vbind.labelBookDesc.setText(description);
        vbind.labelBookTitle.setText(title);
        Glide
                .with(vbind.getRoot())
                .load(RestClient.REAL_URL + poster)
                .centerCrop()
                .into(vbind.imageDest);
    }
}