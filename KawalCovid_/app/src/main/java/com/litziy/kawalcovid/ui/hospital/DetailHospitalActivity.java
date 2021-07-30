package com.litziy.kawalcovid.ui.hospital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.litziy.kawalcovid.R;
import com.litziy.kawalcovid.databinding.ActivityDetailHospitalBinding;

public class DetailHospitalActivity extends AppCompatActivity implements OnMapReadyCallback {

    ActivityDetailHospitalBinding binding;

    SupportMapFragment mapFragment;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailHospitalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        HospitalData data = getIntent().getExtras().getParcelable("data");

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                mMap = googleMap;

                // Add a marker in Sydney and move the camera
                LatLng loc = new LatLng(-34.0, 151.0);
                mMap.addMarker(new MarkerOptions().position(loc).title(data.getName()+"/n"+data.getAlamat()));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
            }
        });

        binding.labelRsName.setText(data.getName());
        binding.labelAddress.setText(data.getAlamat());
        binding.labelContAmbulance.setText(data.getKontakAmbulance());
        binding.labelContRs.setText(data.getKontakRs());
        binding.labelDeskripsi.setText(data.getDeskripsi());
        binding.labelFacility.setText(data.getFasilitas());

        binding.btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + data.getKontakRs()));
            startActivity(intent);
        });

        binding.btnCallAmbulance.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + data.getKontakAmbulance()));
            startActivity(intent);
        });

        binding.btnDirection.setOnClickListener(v -> {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=" + data.getLat() + "," + data.getLong() + "(" + data.getName() + ")"));
            startActivity(intent);
        });


        Glide.with(binding.getRoot()).load(data.getRealPhotoPath()).into(binding.ivImage);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}