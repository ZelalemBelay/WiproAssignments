package com.reports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reports.model.UserReport;

@Repository
public interface ReportsRepository extends JpaRepository<UserReport, Integer>{

}
