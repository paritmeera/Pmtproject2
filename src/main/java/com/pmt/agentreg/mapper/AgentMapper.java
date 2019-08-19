package com.pmt.agentreg.mapper;

import org.springframework.stereotype.Component;

import com.pmt.agentreg.abstractmapper.AbstractModelMapper;
import com.pmt.agentreg.domain.AgentDomain;
import com.pmt.agentreg.model.AgentModel;

@Component
public class AgentMapper extends AbstractModelMapper <AgentModel,  AgentDomain> {
	

	@Override
	public Class<AgentModel> entityType()
	{
		return AgentModel.class;
	}	
	
	@Override
	public Class<AgentDomain> modelType() {
		// TODO Auto-generated method stub
		return null;
	}

}
