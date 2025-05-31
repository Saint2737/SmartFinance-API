package com.example.demo3.controller;


import com.example.demo3.service.BudgetCalculator;
import com.example.demo3.service.BudgetCalculatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/budget")
public class BudgetCalculatorController {

    @Autowired
    private BudgetCalculatorService budgetCalculatorService;

    @PostMapping("/calculate")
    public ResponseEntity<BudgetCalculator> calculateBudget(@RequestParam double totalAmount) {
        BudgetCalculator breakdown = budgetCalculatorService.BudgetCalculator(totalAmount);
        return ResponseEntity.ok(breakdown);
    }
}

