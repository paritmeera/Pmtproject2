package com.pmt.agentreg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmt.agentreg.dao.AgentDaoRepository;
import com.pmt.agentreg.model.AgentModel;
import com.pmt.agentreg.response.ErrorObject;
import com.pmt.agentreg.response.Response;
import com.pmt.agentreg.service.AgentService;
import com.pmt.agentreg.status.StatusCode;
import com.pmt.agentreg.utils.CommonUtils;

@RequestMapping("/register")
@RestController
public class AgentController {
	@Autowired
	 AgentService agentService;
	
	@Autowired
	AgentDaoRepository agentDaoRepository;
	
	/*--------------------------Add---------------------------------------*/
	
	@RequestMapping(value="/add", method=RequestMethod.POST, produces="Application/json")
	public Response addAgent( @Valid @RequestBody  AgentModel  agentmodel) throws Exception 
	{
		System.out.println("cloning........................");
		return agentService.addAgent(agentmodel);
		
		
	}
	
	
	/*--------------------------Update---------------------------------------*/
	

	@RequestMapping(value="/update/{agent_id}", method=RequestMethod.PUT,produces = "Application/json")
	public @ResponseBody Response updateAgent(@PathVariable("agent_id") int agent_id,@RequestBody AgentModel model) throws Exception{
	
		return agentService.updateAgent(agent_id, model);
		
		}
	

	/*--------------------------Delete---------------------------------------*/

		@RequestMapping(value="/delete/{agent_id}",method=RequestMethod.DELETE,produces = "Application/json")
		public @ResponseBody Response deleteAgent(@PathVariable("agent_id") int agent_id) throws Exception
		{
			return agentService.deleteAgent(agent_id);
		}
	
	/*--------------------------GetById---------------------------------------*/
	
		//get driver by id
				@RequestMapping(value="/get/{agent_id}",method=RequestMethod.GET,produces = "Application/json")
				public  @ResponseBody String getAgent(@PathVariable("agent_id") int agent_id) throws Exception {
					AgentModel agentModel=agentService.getAgentById(agent_id);
					Response res = CommonUtils.getResponseObject(" Agent found");
					if (agentModel==null) {
						ErrorObject err = CommonUtils.getErrorResponse("Agent Not Found", "Agent Not Found");
						res.setErrors(err);
						res.setStatus(StatusCode.ERROR.name());
					} else {
						res.setData(agentModel);
					}
					return CommonUtils.getJson(res);
					
					
				}
	
	/*--------------------------GetAll---------------------------------------*/
	
				@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "Application/json")
				public  String getAgents() throws Exception {
					List<AgentModel> agents= agentService.getAgents();
					Response res = CommonUtils.getResponseObject("List of agents");
					if (agents.isEmpty()) {
						ErrorObject err = CommonUtils.getErrorResponse("agents Not Found", "agents Not Found");
						res.setErrors(err);
						res.setStatus(StatusCode.ERROR.name());
					} else {
						res.setData(agents);
					}
					return CommonUtils.getJson(res);
	
	
			}
				
}				
