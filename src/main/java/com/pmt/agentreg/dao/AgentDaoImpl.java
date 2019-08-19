package com.pmt.agentreg.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pmt.agentreg.domain.AgentDomain;

import com.pmt.agentreg.response.Response;
import com.pmt.agentreg.status.StatusCode;
import com.pmt.agentreg.utils.CommonUtils;

@Transactional
@Repository
public class AgentDaoImpl implements AgentDao {
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	AgentDaoRepository agentDaoRepositoy;

	@Override
	public Response addAgent(AgentDomain agentDomain) throws Exception {
		Response response = CommonUtils.getResponseObject("add agents data");
		try {
			entityManager.persist(agentDomain);
		response.setStatus(StatusCode.SUCCESS.name());
		}
		catch(Exception e)
		{
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		
		return response;
	}


	@Override
		public Response updateAgent(AgentDomain agentDomain) throws Exception
		{
			Response response = CommonUtils.getResponseObject("Update agent data");
			
			
			try {
				
				AgentDomain agent = getAgentById(agentDomain.getAgent_id());
				agent.setFirstName(agentDomain.getFirstName());
				agent.setLastName(agentDomain.getLastName());
				agent.setAgent_id(agentDomain.getAgent_id());
				agent.setAddressLine1(agentDomain.getAddressLine1());
				agent.setAddressLine2(agentDomain.getAddressLine2());
				agent.setEmail(agentDomain.getEmail());
				agent.setCity(agentDomain.getCity());
				agent.setPincode(agentDomain.getPincode());
				agent.setState(agentDomain.getState());
				agent.setGender(agentDomain.getGender());
				agent.setCountry(agentDomain.getCountry());
				agent.setPannumber(agentDomain.getPannumber());
			//	agent.setNameonpan(agentDomain.getNameonpan());
				agent.setPassword(agentDomain.getPassword());
				agent.setConfirmpassword(agentDomain.getConfirmpassword());
				agent.setMobileNo(agentDomain.getMobileNo());
				agent.setDateOfBirth(agentDomain.getDateOfBirth());
				agent.setGst_no(agentDomain.getGst_no());
				agent.setAdhar_no(agentDomain.getAdhar_no());
				
				agent.setAccountHolderName(agentDomain.getAccountHolderName());
				agent.setAccountType(agentDomain.getAccountType());
				agent.setPhoneNo(agentDomain.getPhoneNo());
				agent.setBankAccountNo(agentDomain.getBankAccountNo());
				agent.setIfscCode(agentDomain.getIfscCode());
				agent.setBranch(agentDomain.getBranch());
				
				
				
				agentDaoRepositoy.saveAndFlush(agent);
				response.setStatus(StatusCode.SUCCESS.name());
				

				return response;
			} catch (Exception e) {
				response.setStatus(StatusCode.ERROR.name());
				response.setErrors(e.getMessage());
			}
			return null;
		}
	

	@Override
	public Response deleteAgent(int id) {
	
				Response response = CommonUtils.getResponseObject("Delete agent data");

				try {
					AgentDomain agentDomain=getAgentById(id);
				entityManager.remove(agentDomain);
				response.setStatus(StatusCode.SUCCESS.name());
				return response;
				}
				catch(Exception s) {
					System.out.println(s);
				}
				return null;
	}

	
	@Override
	public AgentDomain getAgentById(int id) {
		String hql="From AgentDomain where id=:ab";
		return (AgentDomain) entityManager.createQuery(hql).setParameter("ab", id).getSingleResult();
	}

	@Override
	public List<AgentDomain> getAgents() {
		
				try {
					List<AgentDomain> listAgentDomain=agentDaoRepositoy.findAll();
					return listAgentDomain;
				
				}catch(Exception e1) {
					System.out.println(e1);
				}
				return null;
	}	
	
}
