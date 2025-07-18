package com.example.demo3A.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class KBL_Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double Revenue;
    private String month;

    public KBL_Income(){

    }
    public KBL_Income(double Revenue, String month) {
        this.Revenue = Revenue;
        this.month = month;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getRevenue() {
        return Revenue;
    }
    public void setRevenue(double Revenue) {
        this.Revenue = Revenue;
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }

}
