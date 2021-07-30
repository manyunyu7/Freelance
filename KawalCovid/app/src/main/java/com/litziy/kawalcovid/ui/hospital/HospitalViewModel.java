package com.litziy.kawalcovid.ui.hospital;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;
import com.litziy.kawalcovid.util.Resource;
import com.litziy.kawalcovid.util.URL;

public class HospitalViewModel extends ViewModel {

    private MutableLiveData<Resource<HospitalResponseModel>> hospitalRes = new MutableLiveData<>();

    LiveData<Resource<HospitalResponseModel>> getHospital(){
        return hospitalRes;
    }

    void fetchHospital(){
        Gson gson = new Gson();
        AndroidNetworking.get(URL.HOSPITAL_FETCH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        HospitalResponseModel res = gson.fromJson(response,HospitalResponseModel.class);
                        if (res.getStatus()==0){
                            hospitalRes.setValue(new Resource.Error("error","error a"));
                        }else{
                            hospitalRes.setValue(new Resource.Success(res));
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        hospitalRes.setValue(new Resource.Error("error","error b"));
                    }
                });
    }
}
