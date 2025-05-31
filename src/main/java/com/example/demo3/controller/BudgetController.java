package com.example.demo3.controller;


import com.example.demo3.Budget;
import com.example.demo3.repository.BudgetRepository;
import com.example.demo3.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @Autowired
    private BudgetRepository budgetRepository;

    @GetMapping("/")
    public List<Budget> getBudgets() {
        return budgetService.getAllBudget();
    }


    @PostMapping("/add")
    public ResponseEntity<?> addBudget(@RequestBody Budget budget) {
        Budget savedBudget = budgetService.save(budget);
        URI location = URI.create("/budgets/" + savedBudget.getId());
        return ResponseEntity.created(location).body(savedBudget);
    }


    @PostMapping("/Update")
    public ResponseEntity<?> updateBudget(@RequestBody Budget budget) {
        Optional<Budget> existing = budgetRepository.findById(budget.getId());
        if (existing.isPresent()) {
            budgetService.save(budget);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Budget with ID " + budget.getId() + " not found.");
        }
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteBudget(@PathVariable int id) {
        try {
            Budget deletedBudget = budgetService.deleteById(id);
            return ResponseEntity.ok(deletedBudget);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Budget with ID " + id + " not found.");
        }
    }

}
