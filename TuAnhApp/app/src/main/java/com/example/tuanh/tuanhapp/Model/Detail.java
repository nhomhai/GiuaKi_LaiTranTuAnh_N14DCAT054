package com.example.tuanh.tuanhapp.Model;

/**
 * Created by TuAnh on 3/19/2018.
 */

public class Detail {
    private String id;
    private String Ten;
    private String Loai;
    private String Gia;
    private String HinhAnh;

    public Detail(String idOrder, String ten, String loai, String gia, String hinhAnh) {
        this.id = idOrder;
        Ten = ten;
        Loai = loai;
        Gia = gia;
        HinhAnh = hinhAnh;
    }

    public String getIdOrder() {
        return id;
    }

    public void setIdOrder(String idOrder) {
        this.id = idOrder;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String loai) {
        Loai = loai;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }
}
