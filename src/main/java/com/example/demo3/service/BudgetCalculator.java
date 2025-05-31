
package com.example.demo3.service;

public class BudgetCalculator {
    private double operatingExpenses;
    private double savings;
    private double growth;

    public BudgetCalculator(double operatingExpenses, double savings, double growth) {
        this.operatingExpenses = operatingExpenses;
        this.savings = savings;
        this.growth = growth;
    }

    public double getOperatingExpenses() {
        return operatingExpenses;
    }

    public double getSavings() {
        return savings;
    }

    public double getGrowth() {
        return growth;
    }
}
