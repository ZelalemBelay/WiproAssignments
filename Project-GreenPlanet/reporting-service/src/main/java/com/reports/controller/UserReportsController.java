package com.reports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.reports.model.UserReport;
import com.reports.service.ReportsService;

public class UserReportsController {

	@Autowired
	ReportsService reportsService;
	
	@GetMapping("/userReport")
	public UserReport getUserReport(@RequestHeader String sessionToken) {

			return this.reportsService.getReport(sessionToken);
	}
	
}
