package com.equifax.agiledashboard.service;

import java.util.List;

import com.equifax.agiledashboard.dto.ReportDetails;
import com.equifax.agiledashboard.dto.ReportRequest;

public interface ReportService {

	public ReportDetails getReport(ReportRequest request) ;
	
}
