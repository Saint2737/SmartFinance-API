package com.example.demo3.service;


import com.example.demo3.entity.Debts;
import com.example.demo3.repository.DebtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebtService {

    @Autowired
    private DebtRepository debtRepository;

    public List<Debts> getAllDebts(){
        return debtRepository.findAll();
    }

}
