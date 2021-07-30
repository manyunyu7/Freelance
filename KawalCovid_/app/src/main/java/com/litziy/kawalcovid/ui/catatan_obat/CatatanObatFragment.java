package com.litziy.kawalcovid.ui.catatan_obat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.litziy.kawalcovid.R;
import com.litziy.kawalcovid.databinding.FragmentCatatanObatBinding;
import com.litziy.kawalcovid.db.Medicine;
import com.litziy.kawalcovid.db.MedicineDatabaseManager;

public class CatatanObatFragment extends Fragment {

    private CatatanObatViewModel dashboardViewModel;

    private MedicineDatabaseManager medicineDatabaseManager;
    private CatatanObatAdapter medAdapter;

    private FragmentCatatanObatBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(CatatanObatViewModel.class);
        View root = inflater.inflate(R.layout.fragment_catatan_obat, container, false);
        binding = FragmentCatatanObatBinding.bind(root);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        medicineDatabaseManager = new MedicineDatabaseManager(requireContext());

        medAdapter = new CatatanObatAdapter();

        binding.rvMed.setAdapter(medAdapter);
        binding.rvMed.setHasFixedSize(true);
        binding.rvMed.setLayoutManager(new LinearLayoutManager(requireContext()));

        medAdapter.setData(medicineDatabaseManager.getData());
        medAdapter.notifyDataSetChanged();

        medAdapter.setMedicineInterface(model -> {
            medicineDatabaseManager.deleteByID(model.get_id());
            medAdapter.setData(medicineDatabaseManager.getData());
            medAdapter.notifyDataSetChanged();
        });

        binding.btnAddMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isError = false;
                if (binding.etMedDesc.getText().toString().equals("")) {
                    isError = true;
                }
                if (binding.etMedName.getText().toString().equals("")) {
                    isError = true;
                }

                if (isError) {
                    Toast.makeText(requireContext(), "Lengkapi Input Terlebih Dahulu", Toast.LENGTH_LONG).show();
                } else {
                    medicineDatabaseManager.saveData(binding.etMedName.getText().toString(), binding.etMedDesc.getText().toString());
                }

                String count = String.valueOf(medicineDatabaseManager.getData().size());
                medAdapter.setData(medicineDatabaseManager.getData());
                medAdapter.notifyDataSetChanged();

            }
        });
    }
}