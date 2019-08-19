package com.pmt.agentreg.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmt.agentreg.dao.PackageRepository;
import com.pmt.agentreg.model.PackageModel;
import com.pmt.agentreg.response.ErrorObject;
import com.pmt.agentreg.response.Response;
import com.pmt.agentreg.service.PackageService;
import com.pmt.agentreg.status.StatusCode;
import com.pmt.agentreg.utils.CommonUtils;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/packages")
public class PackageController {
	
	@Autowired
	PackageService packageService;
	
	@Autowired
	PackageRepository packageRepo;
	
	/*-----------------------------------------------Add--------------------------------*/
	
	/*@PostMapping("/add")*/
	@RequestMapping(value="/add", method=RequestMethod.POST, produces="Application/json")
	public Response addPackage( @RequestBody  @Valid PackageModel packageModel ) throws Exception
	{
		
		return packageService.Addpackage(packageModel);
		
	}
	
	/*--------------------------Update---------------------------------------*/
	@RequestMapping(value="/update/{package_id}", method=RequestMethod.PUT,produces = "Application/json")
	/*@PutMapping("/update/{package_id}")*/
	public @ResponseBody Response updatePackage( @RequestBody PackageModel packageModel, @PathVariable("package_id") int package_id) throws Exception
	{
		return packageService.updatepackage(packageModel, package_id);
	}
	
	/*--------------------------Delete---------------------------------------*/
	
	@RequestMapping(value="/delete/{package_id}",method=RequestMethod.DELETE,produces = "Application/json")
	/*@RequestMapping("/delete/{package_id}")*/
	public  @ResponseBody Response deletePackage(@PathVariable("package_id") int package_id) throws Exception
	{
		
		return packageService.deletepackage(package_id);	
	}
	
	
	/*--------------------------GetById---------------------------------------*/
	
	
	@RequestMapping(value="/get/{package_id}",method=RequestMethod.GET,produces = "Application/json")
	/*@RequestMapping("get/{package_id}")*/
	public @ResponseBody String getPackageById(@PathVariable("package_id") int package_id) throws Exception
	{
		PackageModel packageModel = packageService.getPackageById(package_id);
		Response res = CommonUtils.getResponseObject("package id found");
		
		if(packageModel==null)
		{
		
			ErrorObject err = CommonUtils.getErrorResponse("package not found","package not found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
		}
		
		else
		{
			res.setData(packageModel);
			
		}
		
		return CommonUtils.getJson(res);
		
	}
	
	/*--------------------------GetAll---------------------------------------*/
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "Application/json")
	/*@RequestMapping("/getAll")*/
	public String getAllPackages(PackageModel packageModel,int package_id) throws Exception
	{
		
		
	List<PackageModel> packages =	packageService.getAllPackages(package_id);
	 		Response res = CommonUtils.getResponseObject("packages list");
	 		
	 		if(packages.isEmpty())
	 		{
	 			ErrorObject err = CommonUtils.getErrorResponse("packages no found", "packages not found");
	 			res.setData(err);
	 			res.setStatus(StatusCode.ERROR.name());
	 		}
	
	 		else {
	 			res.setData(packages);
	 			res.setStatus(StatusCode.SUCCESS.name());
	 		}
	 		
	 		return CommonUtils.getJson(res);
		
	}
	
	

}
