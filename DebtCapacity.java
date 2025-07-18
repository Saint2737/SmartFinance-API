package com.example.demo3A.controller;

public class DebtCapacity {
	
	
	private double totalDebt;
	private double totalRevenue;
	
	public DebtCapacity() {
		
	}
	
	public DebtCapacity(double totalDebt, double totalRevenue) {
		
		this.totalDebt = totalDebt;
		this.totalRevenue = totalRevenue;
	}
	
	public double getTotalDebt() {
		return totalDebt;
	}
	public void setTotalDebt(double totalDebt) {
		this.totalDebt = totalDebt;
	}
	
	public double getTotalRevenue() {
		return totalRevenue;
	}
	public void setTotalRevenue(double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

}
