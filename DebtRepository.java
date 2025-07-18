package com.example.demo3A.repository;


import com.example.demo3A.entity.Debts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebtRepository extends JpaRepository<Debts, Integer> {

    List<Debts> findAllByOrderByDebtInterestRateDesc();
    List<Debts> findAllByOrderByDebtAmountAsc();
    List<Debts> findAllByOrderByDebtExpiryDateAsc();
    
    @Query(
            value = "SELECT SUM(Debt_Amount) AS totalDebt FROM Debts",
            nativeQuery = true
    )
    double getTotalDebts();
    
}
