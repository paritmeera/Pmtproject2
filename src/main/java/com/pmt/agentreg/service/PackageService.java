package com.pmt.agentreg.service;

import java.util.List;


import com.pmt.agentreg.model.PackageModel;
import com.pmt.agentreg.response.Response;

public interface PackageService {

	public Response Addpackage(PackageModel packagemodel) throws Exception;
	
	public Response updatepackage(PackageModel packagemodel,int package_id) throws Exception;
	
	public Response deletepackage(int package_id) throws Exception;
	
	public PackageModel getPackageById(int package_id) throws Exception;
	
	public List<PackageModel> getAllPackages(int package_id) throws Exception;
	
	
	
}
