package com.example.demo3.repository;


import com.example.demo3.entity.Debts;
import com.example.demo3.service.DebtManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebtRepository extends JpaRepository<Debts, Integer> {

    List<Debts> findAllByOrderByDebtInterestRateDesc();
    List<Debts> findAllByOrderByDebtAmountAsc();
    List<Debts> findAllByOrderByDebtExpiryDateAsc();

}
