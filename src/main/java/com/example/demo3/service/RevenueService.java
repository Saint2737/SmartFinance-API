package com.example.demo3.service;

import com.example.demo3.entity.KBL_Income;
import com.example.demo3.repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueService {

    @Autowired
    private RevenueRepository revenueRepository;

    public List<KBL_Income> getRevenueList(){
        return revenueRepository.findAll();
    }

    public void UpdateRevenue(KBL_Income revenue){
        revenueRepository.save(revenue);
    }
}
