package com.example.demo3A.controller;


import com.example.demo3A.Budget;
import com.example.demo3A.repository.BudgetRepository;
import com.example.demo3A.service.BudgetService;
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


    @PutMapping("/Update/{id}")
    public ResponseEntity<?> updateBudget(@PathVariable int id, @RequestBody Budget budget) {
        Budget existing  = budgetRepository.findById(id);
        if (existing!=null) {
             
        	existing.setCategory(budget.getCategory());
        	existing.setEstimatedAmount(budget.getEstimatedAmount());
        	existing.setDescription(budget.getDescription());
        	
        	budgetService.save(existing);
            return ResponseEntity.ok(existing);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Budget with ID " + id + " not found.");
        }
       
    }
    

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteBudget(@PathVariable int id) {
        try {
            Budget deletedBudget = budgetService.deleteById(id);
            return ResponseEntity.ok(deletedBudget);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Budget with ID " + id + " not found.");
        }
    }

}
