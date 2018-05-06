package com.example.tuanh.tuanhapp.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tuanh.tuanhapp.Model.User;

/**
 * Created by TuAnh on 3/25/2018.
 */

public  class UserAction {
    private MySqlHelper mysql;
    UserTable userTable;

    public UserAction(MySqlHelper mysql, UserTable userTable) {
        this.mysql = mysql;
        this.userTable = userTable;
    }

    public MySqlHelper getMysql() {
        return mysql;
    }

    public void setMysql(MySqlHelper mysql) {
        this.mysql = mysql;
    }

    public UserTable getUserTable() {
        return userTable;
    }

    public void setUserTable(UserTable userTable) {
        this.userTable = userTable;
    }

    // add new user
    public void AddUser(User u){
        SQLiteDatabase db = mysql.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(userTable.getColTen(),u.getTen());
        values.put(userTable.getColAddr(),u.getAddress());
        values.put(userTable.getColEmail(),u.getEmail());
        values.put(userTable.getColPass(),u.getPassword());
        values.put(userTable.getColPermisson(),u.getPermission());
        values.put(userTable.getColPhone(),u.getPhone());
        values.put(userTable.getColPoint(),u.getPoint());
        db.insert(userTable.getTableName(),null,values);
        db.close();
    }

    // select user by ID
    public User GetUserById(int id){
        SQLiteDatabase db = mysql.getReadableDatabase();
        // cursor = db.query(table_name, String{danh sách tên cột, điều kiện truy vấn, String{dnah sách các tham số phụ}, GroupBy, having, orderBy, limit})
        Cursor cursor = db.query(userTable.getTableName(),
                new String[]{userTable.getColId(),userTable.getColTen(),userTable.getColEmail(),userTable.getColAddr(),userTable.getColPass(),userTable.getColPhone(),userTable.getColPoint(),userTable.getColPermisson()},
                userTable.getColId() + "=?", // id=?
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if(cursor != null)
            cursor.moveToFirst();
        User u = new User(cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getLong(6),
                cursor.getInt(7),cursor.getString(8));
        cursor.close();
        db.close();
        return  u;
    }
}
