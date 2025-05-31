package com.example.demo3.controller;

import com.example.demo3.entity.Expenses;
import com.example.demo3.service.ExpenseTrackingService;
import com.example.demo3.service.ExpensesTracking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Expenses")
public class ExpenseTrackingController {

    @Autowired
    private ExpenseTrackingService expensesTrackingService;

    @GetMapping("/AllExpenses")
    public List<Expenses> getAllExpensesTracking(){
        return expensesTrackingService.getAllExpenses();
    }

    // GET /api/expenses/compare
    @GetMapping("/compare")
    public List<ExpensesTracking> compareExpenses() {
        return expensesTrackingService.compareExpenses();
    }
}



