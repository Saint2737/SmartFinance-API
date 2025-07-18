package com.example.demo3A.repository;

import com.example.demo3A.entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses, Integer> {

    @Query(
            value = "SELECT category AS category, SUM(amount_spent) AS totalSpent FROM expenses GROUP BY category",
            nativeQuery = true
    )
    List<ExpenseSummary> findCategorySpending();


    public interface ExpenseSummary {

        String getCategory();

        double getTotalSpent();
    }
}
