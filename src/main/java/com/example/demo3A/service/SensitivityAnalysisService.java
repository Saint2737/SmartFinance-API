package com.example.demo3A.service;

import com.example.demo3A.SensitivityAnalysisRequest;
import org.springframework.stereotype.Service;

@Service
public class SensitivityAnalysisService {

        public double calculateProfit(double revenue, double cogs, double fixedCosts, double variableCosts, double taxRate) {
            double profitBeforeTax = revenue - cogs - fixedCosts - variableCosts;
            double tax = profitBeforeTax > 0 ? profitBeforeTax * (taxRate / 100) : 0;

            return profitBeforeTax - tax;
        }

        public double calculateNewProfit(SensitivityAnalysisRequest request, double revenueChange) {
            double newRevenue = request.getRevenue() * (1 + revenueChange / 100);
            return calculateProfit(newRevenue, request.getCogs(), request.getFixedCosts(), request.getVariableCosts(), request.getTaxRate());
        }

        public double calculateNewProfitWithCogsChange(SensitivityAnalysisRequest request, double cogsChange) {
            double newCogs = request.getCogs() * (1 + cogsChange / 100);
            return calculateProfit(request.getRevenue(), newCogs, request.getFixedCosts(), request.getVariableCosts(), request.getTaxRate());
        }

        public double calculateNewProfitWithFixedCostsChange(SensitivityAnalysisRequest request, double fixedCostsChange) {
            double newFixedCosts = request.getFixedCosts() * (1 + fixedCostsChange / 100);
            return calculateProfit(request.getRevenue(), request.getCogs(), newFixedCosts, request.getVariableCosts(), request.getTaxRate());
        }

        public double calculateNewProfitWithVariableCostsChange(SensitivityAnalysisRequest request, double variableCostsChange) {
            double newVariableCosts = request.getVariableCosts() * (1 + variableCostsChange / 100);
            return calculateProfit(request.getRevenue(), request.getCogs(), request.getFixedCosts(), newVariableCosts, request.getTaxRate());
        }

        public double calculateNewProfitWithTaxRateChange(SensitivityAnalysisRequest request, double taxRateChange) {
            double newTaxRate = request.getTaxRate() * (1 + taxRateChange / 100);
            return calculateProfit(request.getRevenue(), request.getCogs(), request.getFixedCosts(), request.getVariableCosts(), newTaxRate);
        }
    }

