package com.equifax.agiledashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.equifax.agiledashboard.domain.SprintItem;

	@Repository
	public interface SprintItemRepository extends CrudRepository<SprintItem, Long> {

	
}
