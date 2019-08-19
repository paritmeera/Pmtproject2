package com.pmt.agentreg.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.pmt.agentreg.domain.AgentDomain;

import com.pmt.agentreg.response.Response;

@Repository
public interface AgentDao {
	
	public Response addAgent(AgentDomain agentDomain) throws Exception;

	public Response updateAgent(AgentDomain agentDomain) throws Exception;

	public Response deleteAgent(int id) throws Exception;
	
	public AgentDomain getAgentById(int id) throws Exception;

	public List<AgentDomain> getAgents() throws Exception;
	
//	public AgentDomain authenticate(AgentDomain domain);
	
//	public BusinessCreditDomain saveBusinessDetails(BusinessCreditDomain businessdomain) throws Exception;
	
//	public Response addBuDetails(BusinessCreditDomain businessCreditDomain) throws Exception;
	
//	public Response updateBuDetails(BusinessCreditDomain businessCreditDomain) throws Exception;
	
	
	
}
