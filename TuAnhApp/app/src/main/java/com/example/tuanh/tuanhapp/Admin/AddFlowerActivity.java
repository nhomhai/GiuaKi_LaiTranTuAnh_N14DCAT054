package com.example.tuanh.tuanhapp.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tuanh.tuanhapp.Database.FlowerAction;
import com.example.tuanh.tuanhapp.Database.MySqlHelper;
import com.example.tuanh.tuanhapp.Model.Flower;
import com.example.tuanh.tuanhapp.R;

public class AddFlowerActivity extends AppCompatActivity {
    EditText edtId ;
    EditText edtName;
    EditText edtLoai ;
    EditText edtHinhAnh ;
    EditText edtGia ;
    EditText edtMoTa ;
    EditText edtSoLuong;
    EditText edtTinhTrang;
    Button btnAdd ;
    Flower fl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flower);
        contructor();
    }
    public  void contructor(){
        edtId = (EditText) findViewById(R.id.editText_ID_add_flower);
        edtName = (EditText) findViewById(R.id.editText_name_add_flower);
        edtLoai = (EditText) findViewById(R.id.editText_loai_add_flower);
        edtHinhAnh = (EditText) findViewById(R.id.editText_hinhAnh_add_flower);
        edtGia = (EditText) findViewById(R.id.editText_gia_add_flower);
        edtMoTa = (EditText) findViewById(R.id.editText_mota_add_flower);
        edtSoLuong = (EditText) findViewById(R.id.editText_soluong_add_flower);
        edtTinhTrang = (EditText) findViewById(R.id.editText_tinhtrang_add_flower);
        btnAdd = (Button)findViewById(R.id.btnAdd);
    }
    public void AddFlower(View v){
        String ten = edtName.getText().toString();
        String loai = edtLoai.getText().toString();
        String gia  = edtGia.getText().toString();
        String hinhanh = edtHinhAnh.getText().toString();
        int soluong = Integer.parseInt(edtSoLuong.getText().toString());
        String tinhtrang = edtTinhTrang.getText().toString();
        String mota = edtMoTa.getText().toString();
        Flower fl = new Flower(loai,ten,hinhanh,gia,tinhtrang,soluong,mota);
        MySqlHelper sql = new MySqlHelper(this);
        FlowerAction flAct = new FlowerAction(sql);
        flAct.AddFlower(fl);
        Intent goToFlower = new Intent(getBaseContext(),AdminFlowerActivity.class);
        startActivity(goToFlower);
    }
}
