package com.example.demo3A.controller;


import com.example.demo3A.entity.Debts;
import com.example.demo3A.service.DebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://127.0.0.1:5500/Debt.html#")
@RestController
@RequestMapping("/api/debts")
public class DebtController {

    @Autowired
    private DebtService debtService;

    @GetMapping("/")
    public List<Debts> getDebts(){
        return debtService.getAllDebts();
    }
}
