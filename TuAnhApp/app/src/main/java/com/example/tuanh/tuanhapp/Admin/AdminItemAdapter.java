package com.example.tuanh.tuanhapp.Admin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tuanh.tuanhapp.Model.Flower;
import com.example.tuanh.tuanhapp.Model.Funtion;
import com.example.tuanh.tuanhapp.R;

import java.util.List;

/**
 * Created by TuAnh on 4/19/2018.
 */

public class AdminItemAdapter extends ArrayAdapter<Flower> {
    private List<Flower> listData;
    private int resource;
    private Context context;

    public int getResource() {
        return resource;
    }

    public List<Flower> getListData() {
        return listData;
    }

    public AdminItemAdapter(@NonNull Context context, int resource, @NonNull List<Flower> objects) {
        super(context, resource, objects);
        this.listData = objects;
        this.resource = resource;
        this.context = context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layinf = LayoutInflater.from(context);
        convertView = layinf.inflate(R.layout.admin_flower_item, parent, false);
        // khai báo View rtong admin_flower_item
        ImageView img = (ImageView) convertView.findViewById(R.id.img);
        TextView txtName = (TextView)convertView.findViewById(R.id.txtName);
        TextView txtGia = (TextView)convertView.findViewById(R.id.txtGia);
        TextView txtSoLuong = (TextView)convertView.findViewById(R.id.txtSoLuong);
        Button btnDetail = (Button)convertView.findViewById(R.id.btnDetail);
        Button btnEdit = (Button)convertView.findViewById(R.id.btnEdit);
        Button btnDelete = (Button)convertView.findViewById(R.id.btnDelete);
        // set tag cho các btn để có thể ra trong view
        btnDelete.setTag((Integer) position);
        btnDetail.setTag((Integer) position);
        btnEdit.setTag((Integer) position);
        // lấy object trong listdata
        Flower fl = listData.get(position);
        Funtion f = new Funtion();
        img.setImageResource(f.getMipmapResIdByName(fl.getHinhAnh(),context));
        txtName.setText(fl.getTenHoa());
        txtGia.setText(String.valueOf(fl.getGia())+" vnd");
        txtSoLuong.setText(String.valueOf(fl.getSoluong()));
        return  convertView;
    }
    @Override
    public int getPosition(@Nullable Flower item) {
        return super.getPosition(item);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }
    }
