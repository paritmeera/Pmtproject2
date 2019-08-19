package com.pmt.agentreg.mapper;

import org.springframework.stereotype.Component;

import com.pmt.agentreg.abstractmapper.AbstractModelMapper;
import com.pmt.agentreg.domain.PackageDomain;
import com.pmt.agentreg.model.PackageModel;

@Component
public class PackageMapper extends AbstractModelMapper<PackageModel, PackageDomain> {
	
	
	@Override
	public Class<PackageModel> entityType()
	{
		return PackageModel.class;
	}
	
	@Override
	public Class<PackageDomain> modelType()
	{
		return PackageDomain.class;
	}

}
