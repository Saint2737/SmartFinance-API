package com.example.demo3A.service;

import org.springframework.stereotype.Service;

@Service
public class BudgetCalculatorService {

    private static final double OEX_PERCENT = 50.0;
    private static final double SAVINGS_PERCENT = 20.0;
    private static final double GROWTH_PERCENT = 30.0;

    public BudgetCalculator BudgetCalculator(double totalAmount) {
        double operatingExpenses = (OEX_PERCENT / 100) * totalAmount;
        double savings = (SAVINGS_PERCENT / 100) * totalAmount;
        double growth = (GROWTH_PERCENT / 100) * totalAmount;

        return new BudgetCalculator(operatingExpenses, savings, growth);
    }
}
