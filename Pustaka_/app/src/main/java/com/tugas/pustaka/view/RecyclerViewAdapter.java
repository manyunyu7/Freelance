package com.tugas.pustaka.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tugas.pustaka.R;
import com.tugas.pustaka.databinding.ListRecycler1Binding;
import com.tugas.pustaka.model.Book;
import com.tugas.pustaka.util.RestClient;

import java.lang.reflect.Array;
import java.util.ArrayList;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.BookViewHolder> {

    ArrayList<Book> listBook = new ArrayList<>();
    BookInterface bookInterface;

    void setData(ArrayList<Book> newBooks) {
        listBook.clear();
        listBook.addAll(newBooks);
    }

    void setBookInterface(BookInterface newinter){
        this.bookInterface=newinter;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recycler1, parent, false);
        return new BookViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bind(listBook.get(position));
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        ListRecycler1Binding vbind = ListRecycler1Binding.bind(itemView);

        void bind(Book model) {
            vbind.labelBookAuthor.setText(model.getPenulis());
            vbind.labelBookDesc.setText(model.getDeskripsi());
            vbind.labelBookTitle.setText(model.getJudul());
            Glide
                    .with(vbind.getRoot())
                    .load(RestClient.REAL_URL+model.getPathSampul())
                    .centerCrop()
                    .into(vbind.imageRv);

            vbind.btnSeeDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bookInterface.onClick(model);
                }
            });

        }


    }

    interface BookInterface {
        void onClick(Book model);
    }


}


