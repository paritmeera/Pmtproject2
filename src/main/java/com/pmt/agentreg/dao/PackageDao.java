package com.pmt.agentreg.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.pmt.agentreg.domain.PackageDomain;
import com.pmt.agentreg.response.Response;

@Repository
public interface PackageDao {
	
	public Response addPackages(PackageDomain packageDomain) throws Exception;

	public Response updatePackages(PackageDomain packageDomain) throws Exception;

	public Response deletePackages(int id) throws Exception;
	
	public PackageDomain getPackageById(int id) throws Exception;

	public List<PackageDomain> getAllPackages() throws Exception;

}
