package com.equifax.agiledashboard.dto;

public class ChartData {

	private String xValue;
	
	private String yValue;

	public String getxValue() {
		return xValue;
	}

	public void setxValue(String xValue) {
		this.xValue = xValue;
	}

	public String getyValue() {
		return yValue;
	}

	public void setyValue(String yValue) {
		this.yValue = yValue;
	}
	
	public ChartData() {
		
		// TODO Auto-generated constructor stub
	}

	public ChartData(String xValue, String yValue) {
		super();
		this.xValue = xValue;
		this.yValue = yValue;
	}
}
