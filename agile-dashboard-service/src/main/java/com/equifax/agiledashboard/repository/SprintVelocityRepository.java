package com.equifax.agiledashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.equifax.agiledashboard.domain.SprintVelocity;

@Repository
public interface SprintVelocityRepository extends CrudRepository<SprintVelocity, Long> {

}
