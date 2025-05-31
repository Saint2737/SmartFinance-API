package com.example.demo3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestmentService {

    private final InvestmentCalculator investmentCalculator;

    public InvestmentService(){
        this.investmentCalculator = new InvestmentCalculator();
    }


       public double calculateROI(double currentValue, double initialValue) {
            return investmentCalculator.ReturnOnInvestment(currentValue, initialValue);
        }

        public double calculatePBP(double initialInvestment, double annualIncome) {
            return investmentCalculator.PaybackPeriod(initialInvestment, annualIncome);
        }

    public double calculateARR(double annualProfit, double averageInvestmentValue) {
        return investmentCalculator.AccountingRateReturn(annualProfit, averageInvestmentValue);
    }

    public String assessInvestmentViability(double ARRresult, double PBPresult, double ROIresult, double expectedPayback, double minRequiredRate) {
        StringBuilder message = new StringBuilder();
        // ARR Evaluation
        if (ARRresult < minRequiredRate) {
            message.append("The rate of return of this investment is lower than the expected rate of return.\n");
            message.append("This investment is not viable to you.\n");
        } else if (ARRresult == minRequiredRate) {
            message.append("The rate of return of this investment matches your expected rate of return.\n");
            message.append("This investment is viable to you.\n");
        } else {
            message.append("The rate of return of this investment exceeds your expected rate of return.\n");
            message.append("This investment is highly recommended.\n");
        }
        // PBP Evaluation
        if (PBPresult < expectedPayback) {
            message.append("The payback period of this investment is lower than the expected payback period.\n");
            message.append("This investment is viable to you.\n");
        } else if (PBPresult == expectedPayback) {
            message.append("The payback period of this investment matches your expected payback period.\n");
            message.append("This investment is viable to you.\n");
        } else {
            message.append("The payback period of this investment exceeds your expected payback period.\n");
            message.append("This investment is not viable to you.\n");
        }

        if (ROIresult > 0.05 && ROIresult >=0.10) {
            message.append("The return on investment on this investment is good if the investment is new and is an average return.\n");
            message.append("Consider pursuing this investment, but in the future see if you can optimise operations and costs to get a higher return .\n");
        }
        else if ( ROIresult > 0.10){
            message.append("The return on investment on this investment is favourable\n");
            message.append("This investment is highly viable.Consider pursuing this investment\n");

        }
        else {
            message.append("The return on investment on this investment is not favourable\n");
            message.append("This investment is not viable.Consider not pursuing this investment, or review your investment operations to find ways to optimise and maximize your return.\n");
        }
        return message.toString();
    }
}


