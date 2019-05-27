package com.trekkersgateway.Model;

public class User {
    private String name,email,phone,dob,address,username,password;

    public User(String name, String email, String phone, String dob,String address, String username, String password) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.address = address;
        this.username = username;
        this.password = password;
    }
//    public int getid() {
//        return id;
//    }
//
//    public void setid(int id) {
//        this.id = id;
//    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
