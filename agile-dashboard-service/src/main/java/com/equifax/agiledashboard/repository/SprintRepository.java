package com.equifax.agiledashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.equifax.agiledashboard.domain.Sprint;

@Repository
public interface SprintRepository extends CrudRepository<Sprint, Long> {

}


