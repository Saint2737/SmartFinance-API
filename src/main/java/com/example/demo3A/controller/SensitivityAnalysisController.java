package com.example.demo3A.controller;

import com.example.demo3A.SensitivityAnalysisRequest;
import com.example.demo3A.service.SensitivityAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analysis")
public class SensitivityAnalysisController {

    @Autowired
    private SensitivityAnalysisService sensitivityAnalysisService;

    @PostMapping("/calculate")
    public ResponseEntity<Double> calculateProfit(
            @RequestParam double revenue,
            @RequestParam double cogs,
            @RequestParam double fixedCosts,
            @RequestParam double variableCosts,
            @RequestParam double taxRate) {

        try {
            double profit = sensitivityAnalysisService.calculateProfit(revenue, cogs, fixedCosts, variableCosts, taxRate);
            return new ResponseEntity<>(profit, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }



    @PostMapping("/sensitivity")
    public ResponseEntity<String> analyzeSpecificFactor(
            @RequestParam String factor,
            @RequestParam double change,
            @RequestBody SensitivityAnalysisRequest request) {

        double newProfit;

        switch (factor.toLowerCase()) {
            case "revenue":
                newProfit = sensitivityAnalysisService.calculateNewProfit(request, change);
                break;
            case "cogs":
                newProfit = sensitivityAnalysisService.calculateNewProfitWithCogsChange(request, change);
                break;
            case "fixedcosts":
                newProfit = sensitivityAnalysisService.calculateNewProfitWithFixedCostsChange(request, change);
                break;
            case "variablecosts":
                newProfit = sensitivityAnalysisService.calculateNewProfitWithVariableCostsChange(request, change);
                break;
            case "taxrate":
                newProfit = sensitivityAnalysisService.calculateNewProfitWithTaxRateChange(request, change);
                break;
            default:
                return ResponseEntity.badRequest().body("Invalid factor provided");
        }


        return ResponseEntity.ok("New Profit with " + change + "% change in " + factor + ": " + newProfit);
    }

    }


