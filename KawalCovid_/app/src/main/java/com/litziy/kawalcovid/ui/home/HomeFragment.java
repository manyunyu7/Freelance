package com.litziy.kawalcovid.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.litziy.kawalcovid.R;
import com.litziy.kawalcovid.databinding.FragmentHomeBinding;
import com.litziy.kawalcovid.util.Resource;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private FragmentHomeBinding binding;
    NewsAdapter adapterNews;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        binding = FragmentHomeBinding.bind(root);
        return binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapterNews = new NewsAdapter();

        adapterNews.setNewsInterface(new NewsAdapter.NewsInterface() {
            @Override
            public void onclick(News.New data) {
                startActivity(new Intent(requireContext(),ReadNewsActivity.class).putExtra("data",data));
            }
        });

        binding.rvCardNews.setHasFixedSize(true);
        binding.rvCardNews.setLayoutManager(new LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.rvCardNews.setAdapter(adapterNews);


        homeViewModel.fetchSummary();

        homeViewModel.fetchNews();

        homeViewModel.getNews().observe(getViewLifecycleOwner(), n -> {

            if (n instanceof Resource.Success) {
                Toast.makeText(requireContext(),"Success Berita",Toast.LENGTH_LONG).show();
                adapterNews.setData(n.getData().getNews());
                adapterNews.notifyDataSetChanged();
            }

            if (n instanceof Resource.Error) {
                Toast.makeText(requireContext(),"Error Berita",Toast.LENGTH_LONG).show();
            }

            if (n instanceof Resource.Loading) {

            }

        });

        homeViewModel.mSummary.observe(getViewLifecycleOwner(), summary -> {
            binding.death.setText(summary.totalDeath);
            binding.recovered.setText(summary.totalHealed);
            binding.infected.setText(summary.totalPositive);

            binding.inHospital.setText("Dirawat : " + summary.totalOnHospital);
            binding.negative.setText("Spesimen Negatif : " + summary.negative);
            binding.odp.setText("Total ODP : " + summary.odp);

            binding.deathNew.setText("+" + summary.newDeath);
            binding.infectedNew.setText("+" + summary.newPositive);
            binding.recoveredNew.setText("+" + summary.newHealed);
        });
    }
}