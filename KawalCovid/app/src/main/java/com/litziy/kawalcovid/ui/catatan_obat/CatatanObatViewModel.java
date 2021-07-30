package com.litziy.kawalcovid.ui.catatan_obat;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CatatanObatViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CatatanObatViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}