package com.equifax.agiledashboard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SPRINT_VELOCITY")
public class SprintVelocity {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "PROJECT_NAME")
	private String projectName;

	@Column(name = "SPRINT_NAME")
	private String sprintName;

	@Column(name = "ACCEPTED")
	private Long accepted;
	
	@Column(name = "COMMITED")
	private Long commited;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Long getAccepted() {
		return accepted;
	}

	public void setAccepted(Long accepted) {
		this.accepted = accepted;
	}

	public Long getCommited() {
		return commited;
	}

	public void setCommited(Long commited) {
		this.commited = commited;
	}
}
