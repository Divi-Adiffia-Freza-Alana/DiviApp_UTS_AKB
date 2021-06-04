package com.example.myselfapps;
/*
*Tanggal Pengerjaan : 4 juni 2021
Nim : 10118084
Nama : Divi Adiffia Freza Alana
email : divifrezafreza@gmail.com
Kelas : IF-2 */
public class MainModel {
    Integer img_friend;
    String keterangan;

    public MainModel(Integer img_friend,String keterangan){
        this.img_friend = img_friend;
        this.keterangan = keterangan;


    }
    public Integer getImg_friend(){
        return img_friend;
    }

    public String getKeterangan() {
        return keterangan;
    }
}
