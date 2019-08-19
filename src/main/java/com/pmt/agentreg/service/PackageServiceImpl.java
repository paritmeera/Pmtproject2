package com.pmt.agentreg.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.agentreg.dao.PackageDao;
import com.pmt.agentreg.domain.PackageDomain;
import com.pmt.agentreg.mapper.PackageMapper;
import com.pmt.agentreg.model.PackageModel;
import com.pmt.agentreg.response.Response;
import com.pmt.agentreg.status.StatusCode;
import com.pmt.agentreg.utils.CommonUtils;



@Service
public class PackageServiceImpl implements PackageService {
	
	private static final Logger logger =LoggerFactory.getLogger(PackageServiceImpl.class);
	
	Response response = new Response();
	
	@Autowired
	PackageDao packageDao;
	
	@Autowired
	PackageMapper packageMapper;

	@Override
	public Response Addpackage(PackageModel packagemodel) throws Exception {
		Response res = CommonUtils.getResponseObject("successfully added pakage..");
		
		try {
			
			PackageDomain packageDomain = new PackageDomain();
			BeanUtils.copyProperties(packagemodel, packageDomain);
			System.out.println("Packages added .......................");
			res=packageDao.addPackages(packageDomain);
			res.setStatus(StatusCode.SUCCESS.name());
			return res;
		}
		catch(Exception e)
		{
			System.out.println(".............Exception while Packageadding");
			res.setStatus(StatusCode.ERROR.name());
			
		}
		
		return res;
	}

	@Override
	public Response updatepackage(PackageModel packagemodel, int package_id) throws Exception {
		PackageDomain packageDomain=packageDao.getPackageById(package_id);
		BeanUtils.copyProperties(packagemodel,packageDomain);		
		Response response=packageDao.updatePackages(packageDomain);
		return response;
	}

	@Override
	public Response deletepackage(int package_id) throws Exception {
		try {
			return packageDao.deletePackages(package_id);
			}catch(Exception d)
			{
			System.out.println(d);
			}
	
		return null;
	}

	@Override
	public PackageModel getPackageById(int package_id) throws Exception {
		try {
			PackageDomain packageDomain=packageDao.getPackageById(package_id);
			PackageModel packageModel = new PackageModel();
			
			BeanUtils.copyProperties(packageDomain, packageModel);
			return packageModel;
			}catch(Exception e) {
				
			System.out.println(e);
			
			}
			return null;
	}

	@Override
	public List<PackageModel> getAllPackages(int package_id) throws Exception {
		
		try {
			List<PackageDomain> packages = packageDao.getAllPackages();
			List<PackageModel> model=packageMapper.entityList(packages);
			return model;
			}
			catch(Exception d) {
				System.out.println(d);
			}
		return null;
	}
	

}
