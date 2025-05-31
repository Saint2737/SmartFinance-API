package com.example.demo3.service;


import com.example.demo3.Budget;
import com.example.demo3.repository.BudgetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public List<Budget> getAllBudget() {

        return budgetRepository.findAll();
    }

    public Budget save(Budget budget) {
        return budgetRepository.save(budget);
    }

    public Budget deleteById(int id) {
        Optional<Budget> budgetOptional = budgetRepository.findById(id);
        if (budgetOptional.isPresent()) {
            Budget budget = budgetOptional.get();
            budgetRepository.deleteById(id);
            return budget;
        } else {
            throw new EntityNotFoundException("Budget with ID " + id + " not found.");
        }
    }

}
