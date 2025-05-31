package com.example.demo3;

import jakarta.persistence.*;

@Entity
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "Estimated_amount")
    private double estimatedAmount;

    private String description;
    private String category;

    public Budget(){

    }
    public Budget(double estimatedAmount, String description) {
        this.estimatedAmount = estimatedAmount;
        this.description = description;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public double getEstimatedAmount() {
        return estimatedAmount;
    }
    public void setEstimatedAmount(double estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }
}
