
package com.example.demo3A.service;
import com.example.demo3A.entity.Expenses;
import com.example.demo3A.repository.BudgetRepository;
import com.example.demo3A.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

        @Service
        public class ExpenseTrackingService {

            @Autowired
            private BudgetRepository budgetRepository;

            @Autowired
            private ExpenseRepository expenseRepository;

            public List<Expenses> getAllExpenses() {
                return expenseRepository.findAll();
            }

            public List<ExpensesTracking> compareExpenses() {
                List<ExpensesTracking> results = new ArrayList<>();
                Map<String, Double> budgetMap = new HashMap<>();


                budgetRepository.findAll().forEach(b -> budgetMap.put(b.getCategory(), b.getEstimatedAmount()));



                List<ExpenseRepository.ExpenseSummary> summaries = expenseRepository.findCategorySpending();

                Set<String> seenCategories = new HashSet<>();
                for (ExpenseRepository.ExpenseSummary summary : summaries) {
                    String category = summary.getCategory();
                    double spent = summary.getTotalSpent();
                    double budgeted = budgetMap.getOrDefault(category, 0.0);

                    String status;


                    if (spent > budgeted) {
                        status = "Over budget";
                    } else if (spent == budgeted) {
                        status = "On Budget";
                    } else if (spent >= (0.5 * budgeted)) {
                        status = "Half-way Done";
                    } else {
                        status = "Under budget";
                    }


                    results.add(new ExpensesTracking(category, budgeted, spent, status));


                    seenCategories.add(category);
                }

                // Include any categories that were budgeted but had no expenses
                for (Map.Entry<String, Double> entry : budgetMap.entrySet()) {
                    if (!seenCategories.contains(entry.getKey())) {
                        results.add(new ExpensesTracking(
                                entry.getKey(),         // Category name
                                entry.getValue(),       // Budgeted amount
                                0.0,
                                "No spending yet"
                        ));
                    }
                }

                return results; // Return the final list of budget vs. expense comparisons
            }
        }
