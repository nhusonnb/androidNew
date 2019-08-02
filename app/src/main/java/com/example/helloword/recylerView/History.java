package com.example.helloword.recylerView;

import android.location.Address;

public class History {
    int point;
    String maGiaoDich;
    String thoiGian;
    String title;
    int soDu;
    String thamChieuAnh;

    public History(int point, String maGiaoDich, String thoiGian, String title, int soDu) {
        this.point = point;
        this.maGiaoDich = maGiaoDich;
        this.thoiGian = thoiGian;
        this.title = title;
        this.soDu = soDu;
    }

    public History(int point, String maGiaoDich, String thoiGian, String title, int soDu, String thamChieuAnh) {
        this.point = point;
        this.maGiaoDich = maGiaoDich;
        this.thoiGian = thoiGian;
        this.title = title;
        this.soDu = soDu;
        this.thamChieuAnh = thamChieuAnh;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSoDu() {
        return soDu;
    }

    public void setSoDu(int soDu) {
        this.soDu = soDu;
    }

    public String getThamChieuAnh() {
        return thamChieuAnh;
    }

    public void setThamChieuAnh(String thamChieuAnh) {
        this.thamChieuAnh = thamChieuAnh;
    }
}
