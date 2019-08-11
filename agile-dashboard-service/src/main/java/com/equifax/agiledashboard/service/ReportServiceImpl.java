package com.equifax.agiledashboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equifax.agiledashboard.domain.SprintItem;
import com.equifax.agiledashboard.domain.SprintVelocity;
import com.equifax.agiledashboard.dto.ChartData;
import com.equifax.agiledashboard.dto.ChartDetails;
import com.equifax.agiledashboard.dto.ReportDetails;
import com.equifax.agiledashboard.dto.ReportRequest;
import com.equifax.agiledashboard.repository.SprintItemRepository;
import com.equifax.agiledashboard.repository.SprintVelocityRepository;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	SprintVelocityRepository sprintVelocityRepository;
	
	@Autowired
	SprintItemRepository sprintItemRepository;
	
	@Override
	public ReportDetails getReport(ReportRequest request) {
		ReportDetails report = new ReportDetails();
		if("VELOCITY_PREDICTABILITY".equalsIgnoreCase(request.getReportName())) {
			report.setProjectName(request.getProjectName());
			report.setReportName(request.getReportName());
			report.setChartDetails(getVelocityPredictabliltyReport(request.getProjectName()));
		}
		else if("ACCEPT_COMMITTED".equalsIgnoreCase(request.getReportName())) {
			report.setProjectName(request.getProjectName());
			report.setReportName(request.getReportName());
			report.setChartDetails(getAcceptedCommitedReport(request.getProjectName()));
		}
		else if("SCOPE_CHANGE".equalsIgnoreCase(request.getReportName())) {
			report.setProjectName(request.getProjectName());
			report.setReportName(request.getReportName());
			report.setChartDetails(getScopeChangeReport(request.getProjectName()));
		}
		else if("PRIORITY".equalsIgnoreCase(request.getReportName())) {
			report.setProjectName(request.getProjectName());
			report.setReportName(request.getReportName());
			report.setChartDetails(getPriorityReport(request.getProjectName()));
		}
		return report;
	}
	
	private List<ChartDetails> getVelocityPredictabliltyReport(String projectName){
		List<ChartDetails> chartDetails = new ArrayList<ChartDetails>();
		ChartDetails predictabilityChart = new ChartDetails("Velocity Predictability");
		ChartDetails velocityChart = new ChartDetails("Velocity");
		List<SprintVelocity> velocityDetails = (List<SprintVelocity>) sprintVelocityRepository.findAll();
		
		Long predictablity = 0l;
		
		for (SprintVelocity sprintVelocity : velocityDetails) {
			predictablity = 0l;
			Double intermediate = 0d;
			intermediate = (double)(((double)sprintVelocity.getAccepted() - (double)sprintVelocity.getCommited())/(double)sprintVelocity.getCommited());
			predictablity = (long) (intermediate*100);
			predictabilityChart.getChartData().add(new ChartData(sprintVelocity.getSprintName(),predictablity.toString()));
			
			velocityChart.getChartData().add(new ChartData(sprintVelocity.getSprintName(),sprintVelocity.getAccepted().toString()));			
		}
		
		chartDetails.add(predictabilityChart);
		chartDetails.add(velocityChart);
		
		return chartDetails;
	}
	
	private List<ChartDetails> getAcceptedCommitedReport(String projectName){
		List<ChartDetails> chartDetails = new ArrayList<ChartDetails>();
		ChartDetails acceptedCommitedChart = new ChartDetails("Accepted/Committed");		
		List<SprintVelocity> velocityDetails = (List<SprintVelocity>) sprintVelocityRepository.findAll();
		
		Long doneSucessRate = 0l;
		
		for (SprintVelocity sprintVelocity : velocityDetails) {
			doneSucessRate = 0l;
			Double intermediate = 0d;
			intermediate = (double)((double)sprintVelocity.getAccepted()/(double)sprintVelocity.getCommited());
			doneSucessRate = (long) (intermediate*100);			
			acceptedCommitedChart.getChartData().add(new ChartData(sprintVelocity.getSprintName(),doneSucessRate.toString()));
								
		}
		
		chartDetails.add(acceptedCommitedChart);
		
		return chartDetails;
	}
	
	private List<ChartDetails> getScopeChangeReport(String projectName){
		List<ChartDetails> chartDetails = new ArrayList<ChartDetails>();
		ChartDetails scopeChangeChart = new ChartDetails("Scope Change");
		ChartDetails commitedChart = new ChartDetails("Commited Work");
		List<SprintVelocity> velocityDetails = (List<SprintVelocity>) sprintVelocityRepository.findAll();
		
		Long addedWork = 0l;
		
		for (SprintVelocity sprintVelocity : velocityDetails) {
			addedWork = 0l;
			addedWork = sprintVelocity.getAccepted() - sprintVelocity.getCommited();			
			scopeChangeChart.getChartData().add(new ChartData(sprintVelocity.getSprintName(),addedWork.toString()));
			commitedChart.getChartData().add(new ChartData(sprintVelocity.getSprintName(),sprintVelocity.getCommited().toString()));
						
		}
		
		chartDetails.add(scopeChangeChart);
		chartDetails.add(commitedChart);
		
		return chartDetails;
	}
	
	private List<ChartDetails> getPriorityReport(String projectName){
		List<ChartDetails> chartDetails = new ArrayList<ChartDetails>();
		ChartDetails lowest = new ChartDetails("Lowest");
		ChartDetails highest = new ChartDetails("Highest");
		ChartDetails low = new ChartDetails("Low");
		ChartDetails high = new ChartDetails("High");
		ChartDetails medium = new ChartDetails("Medium");
		List<SprintItem> sprintItems = (List<SprintItem>) sprintItemRepository.findAll();		
	
		
		for (SprintItem sprintItem : sprintItems) {
			if("Lowest".equalsIgnoreCase(sprintItem.getPriority())) {
				lowest.getChartData().add(new ChartData(sprintItem.getSprintName(),sprintItem.getCount().toString()));
			}
			else if("Low".equalsIgnoreCase(sprintItem.getPriority())) {
				low.getChartData().add(new ChartData(sprintItem.getSprintName(),sprintItem.getCount().toString()));
			}
			else if("Medium".equalsIgnoreCase(sprintItem.getPriority())) {
				medium.getChartData().add(new ChartData(sprintItem.getSprintName(),sprintItem.getCount().toString()));
			}
			else if("High".equalsIgnoreCase(sprintItem.getPriority())) {
				high.getChartData().add(new ChartData(sprintItem.getSprintName(),sprintItem.getCount().toString()));
			}
			else if("Highest".equalsIgnoreCase(sprintItem.getPriority())) {
				highest.getChartData().add(new ChartData(sprintItem.getSprintName(),sprintItem.getCount().toString()));
			}
						
		}
		
		chartDetails.add(lowest);
		chartDetails.add(low);
		chartDetails.add(medium);
		chartDetails.add(high);
		chartDetails.add(highest);
		
		return chartDetails;
	}
}
