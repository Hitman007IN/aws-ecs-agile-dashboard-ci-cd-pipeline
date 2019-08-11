package com.equifax.agiledashboard.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SPRINT_ITEM")
public class SprintItem {
	@Id
	@GeneratedValue
	private long id;

	@Column(name = "PROJECT_NAME")
	private String projectName;

	@Column(name = "SPRINT_NAME")
	private String sprintName;

	@Column(name = "ITEM_TYPE")
	private String itemType;

	@Column(name = "PRIORITY")
	private String priority;
	
	@Column(name = "COUNT")
	private Long count;

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

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	

}
