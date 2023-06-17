package com.example.express_application;

public class Bookinginfo {

    String name, email, phone, date,service;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Bookinginfo(String name, String email, String phone, String date, String service) {
        this.name = name;
        this.email = email;
        this.phone= phone;
        this.date= date;
        this.service=service;
    }

    public Bookinginfo() {
    }
}
