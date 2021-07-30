package com.litziy.kawalcovid.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.litziy.kawalcovid.R;
import com.litziy.kawalcovid.databinding.ItemNewsBinding;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    ArrayList<News.New> listNews = new ArrayList<>();

    NewsInterface newsInterface;

    void setData(ArrayList<News.New> data) {
        this.listNews.clear();
        this.listNews.addAll(data);
    }

    void setNewsInterface(NewsInterface interfaceNews){
        this.newsInterface=interfaceNews;
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.bind(listNews.get(position));
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        ItemNewsBinding binding = ItemNewsBinding.bind(itemView);

        void bind(News.New model) {
            binding.labelNewsTitle.setText(model.getTitle());
            Glide.with(binding.root)
                    .load(model.getCoverLink())
                    .into(binding.imagePlaceholder);

            binding.root.setOnClickListener(v -> newsInterface.onclick(model));
        }


    }

    interface NewsInterface{
        void onclick(News.New data);
    }

}

