package com.example.demo3A;

import jakarta.persistence.*;

@Table( name="budget")
public class Budget {

    @Id
    private int Id;

    @Column(name = "Estimated_amount")
    private double estimatedAmount;

    private String description;
    private String category;

    public Budget(){

    }
    public Budget(String category, double estimatedAmount, String description) {
        this.estimatedAmount = estimatedAmount;
        this.description = description;
        this.category = category;
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
    public void setCategory(String category) {
    	this.category = category;
    }
	public Budget orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
