package com.example.demo3A.entity;


import com.example.demo3A.Budget;
import jakarta.persistence.*;

@Entity
public class Expenses {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column( name ="Amount_spent")
    private double amountSpent;
    private String category;



    public  Expenses(){

    }
    public Expenses(int id, double amountSpent, String category){
         this.id=id;
         this.amountSpent=amountSpent;
         this.category=category;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getAmountSpent() {
        return amountSpent;
    }
    public void setAmountSpent(double amountSpent) {
        this.amountSpent = amountSpent;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }




}
