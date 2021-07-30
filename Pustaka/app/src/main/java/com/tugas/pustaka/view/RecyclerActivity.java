package com.tugas.pustaka.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.tugas.pustaka.R;
import com.tugas.pustaka.databinding.ActivityRecyclerBinding;
import com.tugas.pustaka.model.Book;
import com.tugas.pustaka.model.BookResponse;
import com.tugas.pustaka.util.BookServiceInterface;
import com.tugas.pustaka.util.RestClient;
import com.tugas.pustaka.viewmodel.BookViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerActivity extends AppCompatActivity {


    ActivityRecyclerBinding viewbinding;

    RecyclerViewAdapter adapter;

    BookViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewbinding = ActivityRecyclerBinding.inflate(getLayoutInflater());
        setContentView(viewbinding.getRoot());

        adapter = new RecyclerViewAdapter();

        adapter.setBookInterface(new RecyclerViewAdapter.BookInterface() {
            @Override
            public void onClick(Book model) {
                Intent intent = new Intent(viewbinding.getRoot().getContext(),DestinationActivity.class);
                intent.putExtra("book",model.getPathBuku());
                intent.putExtra("poster",model.getPathSampul());
                intent.putExtra("author",model.getPenulis());
                intent.putExtra("title",model.getJudul());
                intent.putExtra("description",model.getDeskripsi());
                startActivity(intent);
            }
        });
        viewbinding.swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                viewModel.retrieveModel();
            }
        });


        viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(BookViewModel.class);
        Log.d("activity Recycler", "erer");
        viewModel.retrieveModel();
        viewModel.bookLiveData.observe(this, new Observer<BookResponse>() {
            @Override
            public void onChanged(BookResponse bookResponse) {
                adapter.setData(bookResponse.getData());
                adapter.notifyDataSetChanged();
            }
        });

        viewModel.statusLiveData.observe(this, obs -> {
            switch (obs) {
                case "3":
                    viewbinding.swiperefresh.setRefreshing(true);
                    break;
                case "1":
                case "0":
                    viewbinding.swiperefresh.setRefreshing(false);
                    break;
            }
        });

        viewbinding.recyclerView.setHasFixedSize(true);
        viewbinding.recyclerView.setAdapter(adapter);
        viewbinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}