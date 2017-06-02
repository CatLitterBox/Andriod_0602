package com.example.catlitterbox05;

/**
 * Created by 박지현 on 2017-06-01.
 */

public class user_info {
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setSerial_num(int serial_num) {
        this.serial_num = serial_num;
    }

    public void setToken(String token) {
        this.token = token;
    }

    int user_id;
    int serial_num;
    String token;

    public int getUser_id() {
        return user_id;
    }

    public int getSerial_num() {
        return serial_num;
    }

    public String getToken() {
        return token;
    }
}

