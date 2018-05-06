package com.example.tuanh.tuanhapp.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tuanh.tuanhapp.Database.FlowerAction;
import com.example.tuanh.tuanhapp.Database.MySqlHelper;
import com.example.tuanh.tuanhapp.Model.Flower;
import com.example.tuanh.tuanhapp.R;

public class DetailFlowerActivity extends AppCompatActivity {
    EditText edtId ;
    EditText edtName;
    EditText edtLoai ;
    EditText edtHinhAnh ;
    EditText edtGia ;
    EditText edtMoTa ;
    EditText edtSoLuong;
    EditText edtTinhTrang;
    Button btnEdit ;
    Button btnSave ;
    Flower fl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_flower);
        Intent detail  = getIntent();
        fl = (Flower)detail.getSerializableExtra("item");
        contructor();
        edtId.setText(String.valueOf(fl.getID()));
        edtName.setText(fl.getTenHoa());
        edtLoai.setText(fl.getLoai());
        edtGia.setText(String.valueOf(fl.getGia()));
        edtHinhAnh.setText(fl.getHinhAnh());
        edtSoLuong.setText(String.valueOf(fl.getSoluong()));
        edtTinhTrang.setText(fl.getStatus());
        edtMoTa.setText(fl.getMoTa());

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
        btnEdit = (Button)findViewById(R.id.btnEdit);
        btnSave = (Button)findViewById(R.id.btnSave);
    }
    public  void EditFlower(View v){
        btnSave.setVisibility(View.VISIBLE);
        edtName.setEnabled(true);
        edtLoai.setEnabled(true);
        edtHinhAnh.setEnabled(true);
        edtGia.setEnabled(true);
        edtMoTa.setEnabled(true);
        edtSoLuong.setEnabled(true);
        edtTinhTrang.setEnabled(true);
    }
    public  void Save (View v){
        Integer index = (Integer) v.getTag();
        MySqlHelper msql = new MySqlHelper(this);
        FlowerAction flAct  = new FlowerAction(msql);
        fl.setTenHoa(edtName.getText().toString());
        fl.setLoai(edtLoai.getText().toString());
        fl.setHinhAnh(edtHinhAnh.getText().toString());
        fl.setGia(edtGia.getText().toString());
        fl.setStatus(edtTinhTrang.getText().toString());
        fl.setMoTa(edtMoTa.getText().toString());
        fl.setSoluong(Integer.parseInt(edtSoLuong.getText().toString()));
        int check = flAct.Update(fl);
        if(check==0)
            Toast.makeText(this,"đã tồn tại" + fl.getTenHoa()+" và "+fl.getHinhAnh(),Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"cập nhật thành công" ,Toast.LENGTH_SHORT).show();
        Intent call = new Intent(getBaseContext(),AdminFlowerActivity.class);
        startActivity(call);
    }
}
