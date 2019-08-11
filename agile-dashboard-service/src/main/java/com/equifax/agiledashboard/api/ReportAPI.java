package com.equifax.agiledashboard.api;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.equifax.agiledashboard.dto.ReportDetails;
import com.equifax.agiledashboard.dto.ReportRequest;
import com.equifax.agiledashboard.service.ReportService;

@RestController
@RequestMapping("/api")
public class ReportAPI {

	@Autowired
	ReportService reportService;
	
	public static final Logger logger = LoggerFactory.getLogger(ReportAPI.class);
	@CrossOrigin
	 @RequestMapping(value = "/reports", method = RequestMethod.POST)
	    public ReportDetails getReport(@RequestBody ReportRequest request) {		 
		return reportService.getReport(request);
	 }
}
