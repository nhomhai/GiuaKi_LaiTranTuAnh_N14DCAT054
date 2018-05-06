package com.example.tuanh.tuanhapp.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tuanh.tuanhapp.R;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // load file menu vô "menu"
        getMenuInflater().inflate(R.menu.menu_admin,menu);
        return  true;
    }
    public void GotoUser(View v){
        Intent intUser = new Intent(AdminActivity.this, AdminUserActivity.class);
        startActivity(intUser);
    }
    public void GotoFlower(View v){
        Intent intDelete = new Intent(AdminActivity.this, AdminFlowerActivity.class);
        startActivity(intDelete);
    }
    public void GotoOrder(View v){
        Intent intEdit = new Intent(AdminActivity.this, AdminOrderActivity.class);
        startActivity(intEdit);
    }
    public void GotoDetailOrder(View v){
        Intent intHome = new Intent(AdminActivity.this,AdminHomeActivity.class);
        startActivity(intHome);
    }

// xử lý sự kiện cho menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId(); // lấy id của item vừa đc click
        switch (id){
            case R.id.item_admin_home:
                Intent intHome = new Intent(AdminActivity.this,AdminHomeActivity.class);
                startActivity(intHome);
                break;
            case R.id.item_admin_user:
                Intent intUser = new Intent(AdminActivity.this, AdminUserActivity.class);
                startActivity(intUser);
                break;
            case R.id.item_admin_order:
                Intent intEdit = new Intent(AdminActivity.this, AdminOrderActivity.class);
                startActivity(intEdit);
                break;
            case R.id.item_admin_flower:
                Intent intDelete = new Intent(AdminActivity.this, AdminFlowerActivity.class);
                startActivity(intDelete);
                break;
            case R.id.item_admin_logout:
                Intent logout = new Intent(AdminActivity.this, AdminLogoutActivity.class);
                startActivity(logout);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
