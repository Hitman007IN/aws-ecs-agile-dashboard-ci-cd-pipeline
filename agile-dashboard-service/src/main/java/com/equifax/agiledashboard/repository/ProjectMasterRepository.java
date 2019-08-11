package com.equifax.agiledashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.equifax.agiledashboard.domain.ProjectMaster;

@Repository
public interface ProjectMasterRepository extends CrudRepository<ProjectMaster, Long> {

}
