package com.example.demo3A.service;


import com.example.demo3A.Budget;
import com.example.demo3A.repository.BudgetRepository;
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
        Budget budget = budgetRepository.findById(id);
        if (budget!=null) {
            budgetRepository.deleteById(id);
            return budget;
        } else {
            throw new EntityNotFoundException("Budget with ID " + id + " not found.");
        }
    }

}
