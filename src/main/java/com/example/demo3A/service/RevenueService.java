package com.example.demo3A.service;

import com.example.demo3A.entity.Debts;
import com.example.demo3A.entity.KBL_Income;
import com.example.demo3A.repository.DebtRepository;
import com.example.demo3A.repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueService {

    @Autowired
    private RevenueRepository revenueRepository;
    
    @Autowired
    private DebtRepository debtRepository;

    
    
    public List<KBL_Income> getRevenueList(){
        return revenueRepository.findAll();
    }
    
    
    public double getDebtTotal(){
    	
    	double totalDebt = debtRepository.getTotalDebts();
    	return totalDebt;
    }
    
    
    public double getRevenueTotal(){
    	
    	double totalRevenue = revenueRepository.getTotalRevenue();
    
        return totalRevenue;
    }
    
    public String getDebtCapacity( double totalRevenue, double totalDebt){
    	
    	String capacity;
    	if(totalDebt < (0.5* totalRevenue)) {
    		 capacity ="Debt-worthy..you have a large capacity to take on more debt, you current debt capacity level is manageable. Your debt to income ratio is 1: 2";
    	}else if(totalDebt >= (0.5* totalRevenue) && totalDebt < totalRevenue) {
    	     capacity = "Debt-worthy..you have limited capacity to take on debt,if you have to take on credit financing, be careful to avoid over-borrowing. Your debt to income ratio is 1: 1.5";
    	}else {
    		capacity =" Debt-Unworthy..you have no capacity to take on more debts, your current debt capacity level is unmanageable. Your debt to income ratio is 2:1";
    	}
    	
    	return capacity;
    }
    
    
    
    
    public void UpdateRevenue(KBL_Income revenue){
        revenueRepository.save(revenue);
    }
}
