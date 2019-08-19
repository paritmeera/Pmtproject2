package com.pmt.agentreg.service;

import java.util.List;

import com.pmt.agentreg.model.AgentModel;

import com.pmt.agentreg.response.Response;

public interface AgentService {
	
	public Response addAgent(AgentModel agentModel) throws Exception;

	public Response updateAgent(int agent_id, AgentModel model) throws Exception;

	public Response deleteAgent(int id)throws Exception;

	public AgentModel getAgentById(int id) throws Exception;
	
	public List<AgentModel> getAgents() throws Exception;
	

}
