package com.equifax.agiledashboard.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SPRINT_DETAIL")
public class Sprint {

	@Id
	@GeneratedValue
	private long id;

	@Column(name="PROJECT_NAME")
	private String projectName;

	@Column(name="SPRINT_NAME")
	private String sprintName;

	@Column(name="START_DATE")
	private Date startDate;

	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="SPRINT_STATUS")
	private boolean sprintStatus;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isSprintStatus() {
		return sprintStatus;
	}

	public void setSprintStatus(boolean sprintStatus) {
		this.sprintStatus = sprintStatus;
	}


}
