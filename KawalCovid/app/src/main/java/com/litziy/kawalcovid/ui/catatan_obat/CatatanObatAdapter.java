package com.litziy.kawalcovid.ui.catatan_obat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.litziy.kawalcovid.R;
import com.litziy.kawalcovid.databinding.ItemMedicineBinding;
import com.litziy.kawalcovid.db.Medicine;

import java.util.ArrayList;

public class CatatanObatAdapter extends RecyclerView.Adapter<CatatanObatAdapter.CatatanObatViewHolder> {

    ArrayList<Medicine> listMed = new ArrayList<>();
    private MedicineInterface medicineInterface;


    void setData(ArrayList<Medicine> data) {
        this.listMed.clear();
        this.listMed.addAll(data);
    }

    void setMedicineInterface(MedicineInterface medicineInterface){
        this.medicineInterface=medicineInterface;
    }


    @NonNull
    @Override
    public CatatanObatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_medicine, parent, false);
        return new CatatanObatViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CatatanObatViewHolder holder, int position) {
        holder.bind(listMed.get(position));
    }

    @Override
    public int getItemCount() {
        return listMed.size();
    }

    public class CatatanObatViewHolder extends RecyclerView.ViewHolder {

        public CatatanObatViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        ItemMedicineBinding binding = ItemMedicineBinding.bind(itemView);

        void bind(Medicine model) {
            binding.btnDelete.setOnClickListener(v -> {
                medicineInterface.onclick(model);
            });

            binding.tvName.setText(model.getName());
            binding.tvDesc.setText(model.getDesc());
        }

    }

    interface MedicineInterface{
        void onclick(Medicine model);
    }



}

