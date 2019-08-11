package com.equifax.agiledashboard.dto;

import java.util.ArrayList;
import java.util.List;

public class ReportDetails {

	private String projectName;
	
	private String reportName;
	
	private List<ChartDetails> chartDetails;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public List<ChartDetails> getChartDetails() {
		if(chartDetails == null) {
			chartDetails = new ArrayList<>();
		}
		return chartDetails;
	}

	public void setChartDetails(List<ChartDetails> chartDetails) {
		this.chartDetails = chartDetails;
	}
}
