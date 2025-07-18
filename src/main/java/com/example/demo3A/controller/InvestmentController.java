
package com.example.demo3A.controller;

import com.example.demo3A.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/investment")
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    // DTO class to receive investment input data
    public static class InvestmentRequest {
        public double initialValue;
        public double currentValue;
        public double initialInvestment;
        public double annualIncome;
        public double annualProfit;
        public double averageInvestmentValue;
        public double minRequiredRate;
        public double expectedPayback;


    }

    // DTO class for response data
    public static class InvestmentResponse {
        public double roi;
        public double pbp;
        public double arr;
        public String viabilityMessage;

        public InvestmentResponse(double roi, double pbp, double arr, String viabilityMessage) {
            this.roi = roi;
            this.pbp = pbp;
            this.arr = arr;
            this.viabilityMessage = viabilityMessage;
        }

        
    }

    @PostMapping("/assess-roi")
    public ResponseEntity<String> assessROI(@RequestBody ROIRequest request) {
        double roi = investmentService.calculateROI(request.getCurrentValue(), request.getInitialInvestment());
        return ResponseEntity.ok("ROI: " + String.format("%.2f", roi * 100) + "%");
    }

    @PostMapping("/assess-pbp")
    public ResponseEntity<String> assessPBP(@RequestBody PBPRequest request) {
        double pbp = investmentService.calculatePBP(request.getInitialInvestment(), request.getAnnualRevenue());
        return ResponseEntity.ok("Payback Period: " + String.format("%.2f", pbp) + " years");
    }

    @PostMapping("/assess-arr")
    public ResponseEntity<String> assessARR(@RequestBody ARRRequest request) {
        double arr = investmentService.calculateARR(request.getAnnualProfit(), request.getAverageInvestmentValue());
        return ResponseEntity.ok("ARR: " + String.format("%.2f", arr * 100) + "%");
    }
    public static class ROIRequest {
        private double initialInvestment;
        private double currentValue;

        public double getInitialInvestment() {
            return initialInvestment;
        }

        public void setInitialInvestment(double initialInvestment) {
            this.initialInvestment = initialInvestment;
        }

        public double getCurrentValue() {
            return currentValue;
        }

        public void setCurrentValue(double currentValue) {
            this.currentValue = currentValue;
        }
    }

    public static class PBPRequest {
        private double initialInvestment;
        private double annualRevenue;

        public double getInitialInvestment() {
            return initialInvestment;
        }

        public void setInitialInvestment(double initialInvestment) {
            this.initialInvestment = initialInvestment;
        }

        public double getAnnualRevenue() {
            return annualRevenue;
        }

        public void setAnnualRevenue(double annualRevenue) {
            this.annualRevenue = annualRevenue;
        }
    }

    public static class ARRRequest {
        private double annualProfit;
        private double averageInvestmentValue;

        public double getAnnualProfit() {
            return annualProfit;
        }


        public void setAnnualProfit(double annualProfit) {
            this.annualProfit = annualProfit;
        }

        public double getAverageInvestmentValue() {
            return averageInvestmentValue;
        }

        public void setAverageInvestmentValue(double averageInvestmentValue) {
            this.averageInvestmentValue = averageInvestmentValue;
        }

    }
        @PostMapping("/assess")
        public ResponseEntity<InvestmentResponse> assessFullInvestment(@RequestBody InvestmentRequest request) {
            // Calculate ROI
            double roi = investmentService.calculateROI(request.currentValue, request.initialValue);

            // Calculate PBP
            double pbp = investmentService.calculatePBP(request.initialInvestment, request.annualIncome);

            // Calculate ARR
            double arr = investmentService.calculateARR(request.annualProfit, request.averageInvestmentValue);

            // Get viability message
            String message = investmentService.assessInvestmentViability(
                    arr,
                    pbp,
                    roi,
                    request.expectedPayback,
                    request.minRequiredRate
            );

            // Create and return response
            InvestmentResponse response = new InvestmentResponse(roi, pbp, arr, message);
            return ResponseEntity.ok(response);
        }

    }



