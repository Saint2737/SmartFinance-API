package com.example.demo3A.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Debts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Debt_Amount")
    private double debtAmount;

    @Column(name="Debt_Type")
    private String debtType;

    @Column(name = "Debt_Expiry_Date")
    private Date debtExpiryDate;

    @Column(name = "Debt_Interest_Rate")
    private int debtInterestRate;

    public Debts(){

    }
    public Debts(int id, double debtAmount, String debtType, int debtInterestRate, Date debtExpiryDate) {
        this.id = id;
        this.debtAmount = debtAmount;
        this.debtType = debtType;
        this.debtInterestRate = debtInterestRate;
        this.debtExpiryDate = debtExpiryDate;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getDebtAmount() {
        return debtAmount;
    }
    public void setDebtAmount(double debtAmount) {
        this.debtAmount = debtAmount;
    }
    public String getDebtType() {
        return debtType;
    }
    public void setDebtType(String debtType) {
        this.debtType = debtType;
    }
    public Date getDebtExpiryDate() {
        return debtExpiryDate;
    }
    public void setDebtExpiryDate(Date debtExpiryDate) {
        this.debtExpiryDate = debtExpiryDate;
    }
    public int getDebtInterestRate() {
        return debtInterestRate;
    }
    public void setDebtInterestRate(int debtInterestRate) {
        this.debtInterestRate = debtInterestRate;
    }




}
