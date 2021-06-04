package com.example.myselfapps;
/*
*Tanggal Pengerjaan : 4 juni 2021
Nim : 10118084
Nama : Divi Adiffia Freza Alana
email : divifrezafreza@gmail.com
Kelas : IF-2 */
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MusicFragment extends Fragment {
    ImageButton play,pause;
    MediaPlayer mMediaPlayer;
    ListView listView;
    String mnama_video[] = {"Avengers EndGame", "Justice League", "Jurassic World", "Avatar", "Mortal Kombat"};
    String mtahun_video[] = {"Tahun 2019","Tahun 2017", "Tahun 2015", "Tahun 2009", "Tahun 2021"};
    int mimg_video[] = {R.drawable.avengers, R.drawable.justice, R.drawable.jurasic, R.drawable.avatar
            , R.drawable.mortalkombat};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_music, container, false);
        listView = rootView.findViewById(R.id.list_view_video);
        play = (ImageButton) rootView.findViewById(R.id.play);
        pause = (ImageButton) rootView.findViewById(R.id.pause);
        Adapter_listview adapter_listview = new Adapter_listview(getActivity(),mnama_video, mtahun_video, mimg_video);

        listView.setAdapter(adapter_listview);
        final MediaPlayer sound = MediaPlayer.create(getActivity(),R.raw.lathi);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.setLooping(true);

                sound.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sound.isPlaying()){
                    sound.pause();
                }
            }
        });
    return rootView;
    }

}
