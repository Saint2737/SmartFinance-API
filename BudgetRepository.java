package com.example.demo3A.repository;

import com.example.demo3A.Budget;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer> {

 Budget findById( int id);
}
