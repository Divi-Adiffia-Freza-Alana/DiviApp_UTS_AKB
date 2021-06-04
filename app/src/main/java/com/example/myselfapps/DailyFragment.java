package com.example.myselfapps;
/*
*Tanggal Pengerjaan : 4 juni 2021
Nim : 10118084
Nama : Divi Adiffia Freza Alana
email : divifrezafreza@gmail.com
Kelas : IF-2 */
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DailyFragment extends Fragment {
    ListView listView;
    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    Adapter_horizontal adapter_horizontal;

    String mTitle[] = {"Bangun Pagi", "Belajar", "Makan teratur", "Olahraga", "Istirahat"};
    String mDescription[] = {"Membuat Badan Bugar","Belajar Hal Baru", "Menjaga pola makan", "Membuat tubuh sehat", "Istirahat minimal 7 jam"};
    int mimages[] = {R.drawable.bangun, R.drawable.belajar, R.drawable.makan, R.drawable.olahraga, R.drawable.istirahat};
    int[] img_friend = {R.drawable.fikri, R.drawable.dandri, R.drawable.david, R.drawable.steven, R.drawable.reza};
    String[] keterangan = {"David", "Satya", "Bagus", "Steven", "Mirraz"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    mainModels = new ArrayList<>();
    for (int i=0;i<img_friend.length;i++){
        MainModel model = new MainModel(img_friend[i],keterangan[i]);
        mainModels.add(model);
    }


        View rootView = inflater.inflate(R.layout.fragment_daily, container, false);
        listView = rootView.findViewById(R.id.list_view);
        recyclerView = rootView.findViewById(R.id.recyclerView_friend);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        Adapter_horizontal adapter_horizontal = new Adapter_horizontal(getContext(),mainModels);
        Adapter_listview adapter_listview = new Adapter_listview(getActivity(),mTitle, mDescription, mimages);

        listView.setAdapter(adapter_listview);
        recyclerView.setAdapter(adapter_horizontal);
        return rootView;
    }
}
