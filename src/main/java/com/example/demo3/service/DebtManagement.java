package com.example.demo3.service;

public class DebtManagement {

        private String debtType;
        private double debtAmount;
        private double debtInterestRate;
        private String debtExpiryDate;

        public DebtManagement(double amount, double interestRate, String expiryDate, String debtType) {
            this.debtAmount = amount;
            this.debtInterestRate = interestRate;
            this.debtExpiryDate = expiryDate;
            this.debtType = debtType;
        }


        public double getAmount() {
            return debtAmount;
        }

        public double getInterestRate() {
            return debtInterestRate;
        }
        public String getExpiryDate() {
            return debtExpiryDate;
        }
        public String getDebtType() {
            return debtType;
        }


    }


