package com.tugas.pustaka.util;


import com.tugas.pustaka.model.Book;
import com.tugas.pustaka.model.BookResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BookServiceInterface {

    @GET("buku")
    Call<BookResponse> getBook();

}
