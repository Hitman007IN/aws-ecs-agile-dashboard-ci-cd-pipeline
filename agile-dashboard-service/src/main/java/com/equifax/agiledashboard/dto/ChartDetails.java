package com.equifax.agiledashboard.dto;

import java.util.ArrayList;
import java.util.List;

public class ChartDetails {

	public ChartDetails(String chartName) {
		super();
		this.chartName = chartName;
	}

	public ChartDetails() {
		
	}
	
	private String chartName;

	private List<ChartData> chartData;

	public String getChartName() {
		return chartName;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public List<ChartData> getChartData() {
		if(chartData == null) {
			chartData = new ArrayList<>();
		}
		return chartData;
	}

	public void setChartData(List<ChartData> chartData) {
		this.chartData = chartData;
	}
}
