package com.pmt.agentreg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmt.agentreg.domain.AgentDomain;

@Repository
public interface AgentDaoRepository extends JpaRepository<AgentDomain, Integer> {

	
}
