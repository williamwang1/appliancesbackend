package com.capgemini.test.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@NamedQuery(name = "Appliances.findAll",
//        query = "select u from Appliances")
public class Appliances {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "serial_number", unique = true)
    private String serialNumber;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "date_bought")
    private Date dateBought;
    @Column(name = "status")
    private String status;

    public Appliances () {

    }
    public Appliances(Long id, String serialNumber, String brand, Date dateBought, String status) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.dateBought = dateBought;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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

    public Date getDateBought() {
        return dateBought;
    }

    public void setDateBought(Date dateBought) {
        this.dateBought = dateBought;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


