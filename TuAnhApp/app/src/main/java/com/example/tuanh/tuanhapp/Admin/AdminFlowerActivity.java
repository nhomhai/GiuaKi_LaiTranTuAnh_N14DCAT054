package com.example.tuanh.tuanhapp.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;

import com.example.tuanh.tuanhapp.Database.FlowerAction;
import com.example.tuanh.tuanhapp.Database.MySqlHelper;
import com.example.tuanh.tuanhapp.Model.Flower;
import com.example.tuanh.tuanhapp.R;

import java.util.List;

public class AdminFlowerActivity extends AppCompatActivity {
    List<Flower> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_flower);
        //Dialog add = new Dialog();
        MySqlHelper msql = new MySqlHelper(this);
        FlowerAction flAct  = new FlowerAction(msql);
        data = flAct.getAllFlower();
        GridView lstFlower  = (GridView) findViewById(R.id.lstFlower);
        AdminItemAdapter listFL = new AdminItemAdapter(this,R.layout.admin_flower_item,data);
        lstFlower.setAdapter(listFL);
    }
    public void Delete(View v){
        Integer index = (Integer) v.getTag();
        Flower fl = data.get(index);
        MySqlHelper msql = new MySqlHelper(this);
        FlowerAction flAct  = new FlowerAction(msql);
        flAct.DeleteFlower(fl);
        Intent call = new Intent(AdminFlowerActivity.this,AdminFlowerActivity.class);
        startActivity(call);
    }
    public  void Detail (View v){
        Integer index = (Integer) v.getTag();
        Flower fl = data.get(index);
        Intent detail = new Intent(getBaseContext(),DetailFlowerActivity.class);
        detail.putExtra("item",fl);
        startActivity(detail);
    }
    public void Edit(View v){
        Integer index = (Integer) v.getTag();
        Flower fl = data.get(index);
        Intent detail = new Intent(getBaseContext(),DetailFlowerActivity.class);
        detail.putExtra("item",fl);
        startActivity(detail);
    }
    public void AddHoa(View v){
        Intent add = new Intent(getBaseContext(),AddFlowerActivity.class);
        startActivity(add);
    }
}
