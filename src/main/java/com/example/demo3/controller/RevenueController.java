package com.example.demo3.controller;

import com.example.demo3.entity.KBL_Income;
import com.example.demo3.service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Revenue")
public class RevenueController {

    @Autowired
    private RevenueService revenueService;

    @GetMapping("/")
    public List<KBL_Income> getRevenue() {
        return revenueService.getRevenueList();
    }

    @PostMapping("/Update")
    public void addRevenue(@RequestBody KBL_Income revenue) {
         revenueService.UpdateRevenue(revenue);
    }
}
