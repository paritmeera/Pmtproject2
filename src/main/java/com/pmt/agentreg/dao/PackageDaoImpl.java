package com.pmt.agentreg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pmt.agentreg.domain.PackageDomain;
import com.pmt.agentreg.response.Response;
import com.pmt.agentreg.status.StatusCode;
import com.pmt.agentreg.utils.CommonUtils;

@Transactional
@Repository
public class PackageDaoImpl implements PackageDao {
	
	@Autowired
	EntityManager entitymangager;
	
	@Autowired
	PackageRepository packageRepository;

	@Override
	public Response addPackages(PackageDomain packageDomain) throws Exception {
		
			Response response =CommonUtils.getResponseObject("package added");
			try {
				entitymangager.persist(packageDomain);
				response.setStatus(StatusCode.SUCCESS.name());
			}
			catch(Exception e) {
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			}
	
		return response;
	}

	@Override
	public Response updatePackages(PackageDomain packageDomain) throws Exception {
		Response response = CommonUtils.getResponseObject("Update package");
		try {
			
			PackageDomain pkg = getPackageById(packageDomain.getPackageId());
			pkg.setHotels(packageDomain.getHotels());
			pkg.setMuseums(packageDomain.getMuseums());
			pkg.setNumberOfDays(packageDomain.getNumberOfDays());
			pkg.setNumberOfPlaces(packageDomain.getNumberOfPlaces());
			pkg.setPackagecost(packageDomain.getPackagecost());
			pkg.setPackageName(packageDomain.getPackageName());
			pkg.setSightseeings(packageDomain.getSightseeings());
			pkg.setTransfers(packageDomain.getTransfers());
			
			packageRepository.saveAndFlush(pkg);
			response.setStatus(StatusCode.SUCCESS.name());
			 return response;
		}
		catch(Exception e)
		{
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		
			
			
		return response;
	}

	@Override
	public Response deletePackages(int id) throws Exception {
		Response response = CommonUtils.getResponseObject("Delete package");
		
		try {
			PackageDomain pkg = getPackageById(id);
			entitymangager.remove(pkg);
			response.setStatus(StatusCode.SUCCESS.name());
			return response;
			
		}
		catch(Exception e)
		{
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			
		}
		return response;
	}

	@Override
	public PackageDomain getPackageById(int id) throws Exception {
		
		String hql="From PackageDomain where id=:ab";
		return (PackageDomain) entitymangager.createQuery(hql).setParameter("ab", id).getSingleResult();
		
	}

	@Override
	public List<PackageDomain> getAllPackages() throws Exception {
		try {
			List<PackageDomain> listPackageDomain=packageRepository.findAll();
			return listPackageDomain;
		
		}catch(Exception e1) {
			System.out.println(e1);
		}
		return null;

	}

	
}
