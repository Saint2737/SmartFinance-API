package com.example.demo3A.controller;

import com.example.demo3A.service.DebtManagement;
import com.example.demo3A.service.DebtManagementService;
import com.example.demo3A.service.DebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Debts")
public class DebtManagementController {

        @Autowired
        private DebtManagementService debtManagementService;

        @GetMapping("/avalanche")
        public ResponseEntity<List<DebtManagement>> getDebtsByAvalanche() {
            List<DebtManagement> debts = debtManagementService.getDebtsByAvalanche();
            return ResponseEntity.ok(debts);
        }

        @GetMapping("/snowball")
        public ResponseEntity<List<DebtManagement>> getDebtsBySnowball() {
            List<DebtManagement> debts = debtManagementService.getDebtsBySnowball();
            return ResponseEntity.ok(debts);
        }

        @GetMapping("/expiry")
        public ResponseEntity<List<DebtManagement>> getDebtsByExpiry() {
            List<DebtManagement> debts = debtManagementService.getDebtsByExpiry();
            return ResponseEntity.ok(debts);
        }
    }



