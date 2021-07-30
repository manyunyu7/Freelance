package com.litziy.kawalcovid.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.common.ResponseType;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;
import com.litziy.kawalcovid.util.Resource;
import com.litziy.kawalcovid.util.URL;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    MutableLiveData<Summary> mSummary = new MutableLiveData<>();
    MutableLiveData<Resource<News>> mNews = new MutableLiveData<>();

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<Summary> getSummary(){
        return mSummary;
    }

    public LiveData<Resource<News>> getNews(){
        return mNews;
    }

    void fetchNews(){
        Gson gson = new Gson();
        AndroidNetworking.get(URL.NEWS_FETCH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("news-res",response.toString());
                        News news = gson.fromJson(response, News.class);
                        if (news.getStatus()==1){
                            mNews.setValue(new Resource.Success(news));
                        }else{
                            mNews.setValue(new Resource.Error("Gagal On 1",""));
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        mNews.setValue(new Resource.Error("Gagal On 0",""));
                    }
                });
    }

    void fetchSummary(){
        Log.d("fetch_summary","loading");
        AndroidNetworking.get(URL.INDONESIA_SUMMARY)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject raz = response.getJSONObject("data");
                            JSONObject total = response.getJSONObject("update").getJSONObject("total");
                            JSONObject penambahan = response.getJSONObject("update").getJSONObject("penambahan");

                            String newDeath = penambahan.getString("jumlah_meninggal");
                            String newHealed= penambahan.getString("jumlah_sembuh");
                            String newPositive = penambahan.getString("jumlah_positif");

                            String totalOdp = raz.getString("jumlah_odp");
                            String totalNegative = raz.getString("total_spesimen_negatif");
                            String totalOnHospital = total.getString("jumlah_dirawat");
                            String totalDeath = total.getString("jumlah_meninggal");
                            String totalHealed = total.getString("jumlah_sembuh");
                            String totalPositive = total.getString("jumlah_positif");

                            Summary summary = new Summary(
                                    newDeath,newHealed,newPositive,
                                    totalDeath,totalHealed,totalPositive,totalOnHospital,
                                    totalOdp,totalNegative);

                            mSummary.setValue(summary);

                        } catch (JSONException e) {
                            Log.d("error pak",e.getLocalizedMessage());
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("fetch_summary","onError");
                        Log.d("fetch_summary",anError.toString());
                        Log.d("fetch_summary",anError.getErrorBody());
                    }
                });
    }
}