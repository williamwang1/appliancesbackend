package com.capgemini.test.controller;


import javax.persistence.Column;
import java.util.Date;
import java.util.List;

public class Form {

    private String serial_number;

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getDate_bought() {
        return date_bought;
    }

    public void setDate_bought(Date date_bought) {
        this.date_bought = date_bought;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String brand;
    private String model;
    private Date date_bought;
    private String status;
}
