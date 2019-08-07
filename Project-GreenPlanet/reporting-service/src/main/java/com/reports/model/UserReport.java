package com.reports.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserReport {
	@Id
	@GeneratedValue 
	int reportId;
	
	double totalAmount;
	String reportDate;
	double balance;
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@OneToMany
	List<Trade> trade;

	public UserReport() {
		super();
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public List<Trade> getTrade() {
		return trade;
	}

	public void setTrade(List<Trade> trade) {
		this.trade = trade;
	}
	
	
}
