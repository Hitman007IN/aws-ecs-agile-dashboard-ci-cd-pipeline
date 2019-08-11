package com.equifax.agiledashboard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT_MASTER")
public class ProjectMaster {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "PROJECT_NAME")
	private String projectName;
	
}
