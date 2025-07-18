package com.example.demo3A.service;

public class InvestmentCalculator {

    public double ReturnOnInvestment(double currentValue, double initialValue) {
        return (currentValue - initialValue) / initialValue * 100;
    }

    public double PaybackPeriod(double initialInvestment, double annualIncome) {
        return initialInvestment / annualIncome;
    }

    public double AccountingRateReturn(double annualProfit, double averageInvestmentValue) {
        return (annualProfit / averageInvestmentValue) * 100;
    }
}

