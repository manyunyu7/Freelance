package com.tugas.pustaka.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tugas.pustaka.model.Book;
import com.tugas.pustaka.model.BookResponse;
import com.tugas.pustaka.util.BookServiceInterface;
import com.tugas.pustaka.util.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookViewModel extends ViewModel {

    public MutableLiveData<BookResponse> bookLiveData = new MutableLiveData<>();
    public MutableLiveData<String> statusLiveData = new MutableLiveData<>();

    public void retrieveModel() {
        Log.d("retrieve model", "is retrieving");
        statusLiveData.postValue("3");
        BookServiceInterface bookServiceInterface = RestClient.getClient().create(BookServiceInterface.class);
        bookServiceInterface.getBook().enqueue(new Callback<BookResponse>() {
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {
                statusLiveData.postValue("1");
                Log.d("success api", response.body().toString());
                bookLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<BookResponse> call, Throwable t) {
                statusLiveData.postValue("0");
                Log.d("failure api", t.toString());
                Log.d("failure api", t.getLocalizedMessage());
            }
        });

    }
}
