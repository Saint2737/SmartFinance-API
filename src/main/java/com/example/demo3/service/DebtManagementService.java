package com.example.demo3.service;

import com.example.demo3.entity.Debts;
import com.example.demo3.repository.DebtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DebtManagementService {

    @Autowired
    private DebtRepository debtRepository;

    public List<DebtManagement> getDebtsByAvalanche() {
        List<Debts> debtEntities = debtRepository.findAllByOrderByDebtInterestRateDesc();
        List<DebtManagement> result = new ArrayList<>();
        for (Debts d : debtEntities) {
            result.add(new DebtManagement(d.getDebtAmount(), d.getDebtInterestRate(), d.getDebtType(), null));
        }
        return result;
    }

    public List<DebtManagement> getDebtsBySnowball() {
        List<Debts> debtEntities = debtRepository.findAllByOrderByDebtAmountAsc();
        List<DebtManagement> result = new ArrayList<>();
        for (Debts d : debtEntities) {
            result.add(new DebtManagement(d.getDebtAmount(), d.getDebtInterestRate(), d.getDebtType(), null));
        }
        return result;
    }

    public List<DebtManagement> getDebtsByExpiry() {
        List<Debts> debtEntities = debtRepository.findAllByOrderByDebtExpiryDateAsc();
        List<DebtManagement> result = new ArrayList<>();
        for (Debts d : debtEntities) {
            result.add(new DebtManagement(d.getDebtAmount(), d.getDebtInterestRate(),d.getDebtExpiryDate().toString(), d.getDebtType()
                    ));
        }
        return result;
    }

}

