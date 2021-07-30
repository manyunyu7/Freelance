package com.litziy.kawalcovid.ui.hospital;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.litziy.kawalcovid.R;
import com.litziy.kawalcovid.databinding.FragmentHospitalListBinding;
import com.litziy.kawalcovid.databinding.MapInfoHospitalBinding;
import com.litziy.kawalcovid.util.Resource;

import java.util.ArrayList;
import java.util.List;

public class HospitalListFragment extends Fragment {

    private FragmentHospitalListBinding binding;
    private HospitalViewModel hospitalViewModel;

    private HospitalData modelForMarker;

    private GoogleMap myMap;

    String rawObject = "";


    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            myMap = googleMap;
            LatLng sydney = new LatLng(-4.247999905323661, 111.54194278168488);
            myMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

            myMap.setOnInfoWindowClickListener(marker -> {
                HospitalData data = (HospitalData) marker.getTag();
                Log.d("image-url", data.getRealPhotoPath());
                startActivity(new Intent(requireActivity(), DetailHospitalActivity.class)
                        .putExtra("data", data));
            });

            myMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Nullable
                @Override
                public View getInfoWindow(@NonNull Marker marker) {
                    return null;
                }

                @Nullable
                @Override
                public View getInfoContents(@NonNull Marker marker) {
                    MapInfoHospitalBinding viewMap = MapInfoHospitalBinding.bind(getLayoutInflater().inflate(R.layout.map_info_hospital, null));

                    HospitalData data = (HospitalData) marker.getTag();
                    Glide.with(viewMap.getRoot())
                            .load(data.getRealPhotoPath())
                            .into(viewMap.imgHospital);


                    viewMap.imgHospital.setVisibility(View.GONE);
                    viewMap.title.setText(data.getName());
                    viewMap.address.setText(data.getAlamat());
                    viewMap.fasilitas.setText(data.getFasilitas());
                    viewMap.operasional.setText(data.getOperasional());
                    return viewMap.getRoot();
                }
            });
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hospital_list, container, false);
        binding = FragmentHospitalListBinding.bind(root);

        hospitalViewModel = new ViewModelProvider(this).get(HospitalViewModel.class);
        hospitalViewModel.fetchHospital();

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }

        hospitalViewModel.getHospital().observe(getViewLifecycleOwner(), new Observer<Resource<HospitalResponseModel>>() {
            @Override
            public void onChanged(Resource<HospitalResponseModel> hospitalResponseModelResource) {
                if (hospitalResponseModelResource instanceof Resource.Success) {
                    Toast.makeText(requireContext(), "Success ", Toast.LENGTH_LONG).show();

                    List<HospitalData> arrayHospital;
                    arrayHospital = hospitalResponseModelResource.getData().getData();

                    for (int i = 0; i < arrayHospital.size(); i++) {
                        HospitalData model = arrayHospital.get(i);
                        Log.d("list_hospital", arrayHospital.get(i).getName());
                        LatLng cordinate = new LatLng(Double.parseDouble(model.getLat()), Double.parseDouble(model.getLong()));
                        myMap.addMarker(new MarkerOptions().position(cordinate)).setTag(model);
                        myMap.animateCamera(CameraUpdateFactory.zoomTo(3.0f));

                    }

                }
                if (hospitalResponseModelResource instanceof Resource.Error) {
                    Toast.makeText(requireContext(), "Error " + hospitalResponseModelResource.getData(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}