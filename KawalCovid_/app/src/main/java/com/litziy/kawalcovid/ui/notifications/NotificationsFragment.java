package com.litziy.kawalcovid.ui.notifications;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.litziy.kawalcovid.R;
import com.litziy.kawalcovid.databinding.FragmentNotificationsBinding;
import com.litziy.kawalcovid.notification_manager.ReminderReceiver;

import java.util.Random;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;

    private static final String MY_PREF_NAME = "shared_preferences";
    SharedPreferences mySharedPref;
    SharedPreferences.Editor prefEditor;

    ReminderReceiver reminderReceiver;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
//        final TextView textView = root.findViewById(R.id.text_notifications);
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        binding= FragmentNotificationsBinding.bind(view);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mySharedPref = requireContext().getSharedPreferences(MY_PREF_NAME, Context.MODE_PRIVATE);
        prefEditor = mySharedPref.edit();

        reminderReceiver  = new ReminderReceiver();

        binding.cardLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
            }
        });

        //Check current alarm status,then change the switch
        boolean alarmStatus = mySharedPref.getBoolean("ALARM_SET", false);


        String[] array={
          "Tidur dan beristirahatlah yang cukup",
          "Meditasi menenangkan pikiran dan menenangkan jiwa.",
          "Lakukan olahraga sebagai bagian dari kesenangan",
          "Makanlah lebih banyak buah dan kurangi vitamin sintetis",
          " Pilih makanan berwarna cerah sebagai antioksidan",
          " Kurangi makanan olahan dan makanan dalam kaleng",
          " Mulailah mencintai diri sendiri",
          " Kurangi konsumsi soda dan kafein",
          " Hidup Sehat itu Mudah, Kuncinya Disiplin",
          " Belajarlah untuk mengatakan tidak",
          " Kendalikan Gula, Sekali Lagi!",
          " Telah banyak terbukti bahwa merokok merugikan kesehatan, mulai dari resiko kanker paru paru hingga kanker mulut.",
          " Jauhi orang-orang dengan pola pikir negatif",
          " Bersihkan diri Anda sendiri juga dari hal yang negatif",
          " Katakan tidak untuk makanan berminyak",
          " Tulislah banyak hal mengenai mimpi dan kebahagian",
          " Makanlah sedikit tapi sering, ini akan membuat Anda merasa lebih baik.",
          " Mengkonsumsi gula dan garam berlebihan dapat menggangu kesehatan, meski demikian tetap diperlukan konsumsi gula dan garam dalam kadar yang tepat.",

        };


        binding.showNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rnd = new Random().nextInt(array.length);
                reminderReceiver.setRepeatingAlarm(
                        requireContext(), array[rnd]
                );
            }
        });



    }

}