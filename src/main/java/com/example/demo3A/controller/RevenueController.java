package com.example.demo3A.controller;

import com.example.demo3A.entity.Debts;
import com.example.demo3A.entity.KBL_Income;
import com.example.demo3A.repository.DebtRepository;
import com.example.demo3A.service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Revenue")
public class RevenueController {

    @Autowired
    private RevenueService revenueService;
    
    @Autowired
    private DebtRepository debtRepository;
    

    @GetMapping("/")
    public List<KBL_Income> getRevenue() {
        return revenueService.getRevenueList();
    }

    @PostMapping("/Update")
    public void addRevenue(@RequestBody KBL_Income revenue) {
         revenueService.UpdateRevenue(revenue);
    }
    
    
//    @GetMapping("/analysis")
//    public String getCapacity() {
//    	return revenueService.getDebtCapacity(0, 0);
//    }
//    
    
    @GetMapping("/analysis")
    public ResponseEntity<String> getCapacity(){
    	
    	double totalDebt = revenueService.getDebtTotal();
    	double totalRevenue = revenueService.getRevenueTotal();
    	
    	String debtCapacity = revenueService.getDebtCapacity(totalRevenue, totalDebt);
    	return ResponseEntity.ok(debtCapacity);
    }
    
    @GetMapping("/totalDebt")
    public double getTotalDebt() {
    	return revenueService.getDebtTotal();
    }
    
    @GetMapping("/totalRevenue")
    public double getTotalRevenue() {
    	return revenueService.getRevenueTotal();
    }
    
}
