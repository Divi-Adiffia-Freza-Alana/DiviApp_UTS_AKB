package com.example.myselfapps;
/*
*Tanggal Pengerjaan : 4 juni 2021
Nim : 10118084
Nama : Divi Adiffia Freza Alana
email : divifrezafreza@gmail.com
Kelas : IF-2 */
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    ImageButton wa_btn,ig_btn,map_btn,info_btn;
    String num = "6287828826848";
    String text = "Hello";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        wa_btn = rootView.findViewById(R.id.wa_btn);
        ig_btn = rootView.findViewById(R.id.ig_btn);
        map_btn = rootView.findViewById(R.id.map_btn);
        info_btn = rootView.findViewById(R.id.about_btn);


        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(getActivity(), "Divi App merupakan aplikasi yang dibuat oleh \n Divi Adiffia Freza A\n 10118084\n Untuk memenuhi salah satu tugas UTS \n Matkul AKB");
            }
        });

        wa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean installed = isAppInstalled("com.whatsapp");

                if (installed){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+num+"&text"+text));
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getActivity(),"whatsapp is not installed", Toast.LENGTH_SHORT);
                }
            }
        });

        ig_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                boolean installed = isAppInstalled("com.instagram.android");
                if (installed){
                    Intent intent2 = new Intent(Intent.ACTION_VIEW);
                    intent2.setData(Uri.parse("http://instagram.com/diviadiffia"));
                    startActivity(intent2);
                }
                else {
                    Toast.makeText(getActivity(),"Instagram is not installed", Toast.LENGTH_SHORT);
                }
            }
        });
        map_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                boolean installed = isAppInstalled("com.google.android.apps.maps");
                if (installed){
                    Intent intent2 = new Intent(Intent.ACTION_VIEW);
                    intent2.setData(Uri.parse("geo:-6,4198181, 108,0801769"));
                    startActivity(intent2);
                }
                else {
                    Toast.makeText(getActivity(),"Instagram is not installed", Toast.LENGTH_SHORT);
                }
            }
        });
     return rootView;
    }
    private boolean isAppInstalled(String s){
        PackageManager packageManager = getActivity().getPackageManager();
        boolean is_installed;
        try {
            packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES);
            is_installed = true;

        } catch (PackageManager.NameNotFoundException e) {
            is_installed = false;
            e.printStackTrace();
        }
        return is_installed;
    }
}
