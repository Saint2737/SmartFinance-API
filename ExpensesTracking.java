
package com.example.demo3A.service;

public class ExpensesTracking {
    private String category;
    private double budgeted;
    private double spent;
    private String status;

    public ExpensesTracking(String category, double budgeted, double spent, String status) {
        this.category = category;
        this.budgeted = budgeted;
        this.spent = spent;
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public double getBudgeted() {
        return budgeted;
    }

    public double getSpent() {
        return spent;
    }

    public String getStatus() {
        return status;
    }
}
