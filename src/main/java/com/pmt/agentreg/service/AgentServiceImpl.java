package com.pmt.agentreg.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.agentreg.dao.AgentDao;
import com.pmt.agentreg.domain.AgentDomain;

import com.pmt.agentreg.mapper.AgentMapper;
import com.pmt.agentreg.model.AgentModel;
import com.pmt.agentreg.response.Response;
import com.pmt.agentreg.status.StatusCode;
import com.pmt.agentreg.utils.CommonUtils;
import com.pmt.agentreg.utils.RegistrationMailService;
import com.pmt.agentreg.utils.SmtpMailSender;

@Service
public class AgentServiceImpl implements AgentService {
	
	private static final Logger logger = LoggerFactory.getLogger(AgentServiceImpl.class);
	
	Response Response = new Response();
	
	@Autowired
	private AgentDao agentDao;
	
	@Autowired
	AgentMapper agentMapper;
	
	@Autowired
	SmtpMailSender smtpmailsender;
	
	@Autowired
    RegistrationMailService sender;
	
	
	@Override
	public Response addAgent(AgentModel agentModel) throws Exception {
		Response res = CommonUtils.getResponseObject("successfully registered");
		
		try {
		
		AgentDomain agentDomain = new AgentDomain();
		
		BeanUtils.copyProperties(agentModel,agentDomain);
		System.out.println("**************added registered Agent*********************");
		res = agentDao.addAgent(agentDomain);
		
	//	agentDomain.setFirstName(agentModel.getFirstName());
	//	agentDomain.setEmail(agentModel.getEmail());
		
			
		if(res!=null)
		{
			String aFirstName = agentDomain.getFirstName();
			String aMail =agentDomain.getMobileNo();
			 
			if(aFirstName!=null && aMail!=null)
			{
				String mail=agentDomain.getEmail();
				sender.sendMail(mail,"Agent Registration Status!!!!!!!!!!!!..","Dear"+" "+agentDomain.getFirstName()+","+"\n"+"Thank you for Registering with Online Ticket Book Reselling  Account"+" "+"We have recieved your registration request."+"\n"+"Below are the login credentials for your Login."+"\n"+"Email:"+agentDomain.getEmail()+"\n"+"Password:"+"*********"+"\n"+"\n"+"\n"+"\n"+"\n"+"With Regards,"+"\n"+"Online Ticket Booking Team");
		
			}
			
		}
		
		res.setStatus(StatusCode.SUCCESS.name());
		return res;
	}
		
		catch(Exception e)
		{
			System.out.println("----------------Exception in Agent Registrion ----------------------------");
			res.setStatus(StatusCode.ERROR.name());
			
		}
		return res;
		
		
		/*BeanUtils.copyProperties(agentModel,agentDomain );
		System.out.println("*****************added register Agent**********");
		return 	agentDao.addAgent(agentDomain);
		

		}
		catch(Exception e) {
			System.out.println("Exception in register Agent");
			logger.error("Exception in register Agent");
		
		}
	return null;*/
		
	}


	@Override
	public Response updateAgent(int agent_id, AgentModel model) throws Exception {
	
			AgentDomain agentDomain=agentDao.getAgentById(agent_id);
			BeanUtils.copyProperties(model,agentDomain);		
			Response response=agentDao.updateAgent(agentDomain);
			return response;
		
		}
	
	

	@Override
	public Response deleteAgent(int id) throws Exception {
		try {
			return agentDao.deleteAgent(id);
			}catch(Exception d)
			{
			System.out.println(d);
			}
	
		return null;
	}


	@Override
	public AgentModel getAgentById(int id) throws Exception {
		try {
			AgentDomain agentDomain=agentDao.getAgentById(id);
			AgentModel agentModel = new AgentModel();
			
			BeanUtils.copyProperties(agentDomain, agentModel);
			return agentModel;
			}catch(Exception e) {
			System.out.println(e);
			//logger.info("Exception getAgents:", e.getMessage());
			
			}
			return null;
	}


	@Override
	public List<AgentModel> getAgents() throws Exception {
		try {
			List<AgentDomain> agents = agentDao.getAgents();
			List<AgentModel> model=agentMapper.entityList(agents);
			return model;
			}
			catch(Exception d) {
				System.out.println(d);
			}
		return null;
	}


}	


