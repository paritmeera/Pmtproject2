package com.pmt.agentreg.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pmt.agentreg.dao.PhotoUploadDao;
import com.pmt.agentreg.dao.PhotoUploadRepository;
import com.pmt.agentreg.domain.PhotoUploadDomain;
import com.pmt.agentreg.model.PhotoUpload;
//import com.pmt.agentreg.model.PhotoUpload;
import com.pmt.agentreg.service.PhotoService;

@RestController
@RequestMapping("/photo")
public class PhotoUploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(PhotoUploadController.class);
	
	@Autowired
	PhotoService photoService;
	
	@Autowired
	PhotoUploadDao photoDao;
	
	@Autowired
	PhotoUploadRepository photoRepository;
	
	@PostMapping("/addPhoto")
	public void saveImage(@RequestParam("agntphoto") MultipartFile agentphoto,@RequestParam("PId") String pid) {
		
		 try {
		        // save file to MySQL
		        PhotoUpload phUpload = new PhotoUpload(agentphoto.getBytes());
		        phUpload.setPid(pid);
		        photoService.savePhoto(phUpload);
		      //return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
		    } catch (  Exception e) {
		     // return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
		    }  

	}
	
	
	@GetMapping("/{pid}")
	  public ResponseEntity<byte[]> getFile(@PathVariable String pid) {
		  Optional<PhotoUploadDomain> photoOptional = photoRepository.findById(pid);
		    
		    if(photoOptional.isPresent()) {
		    	PhotoUploadDomain file = photoOptional.get();
		      return ResponseEntity.ok()
		          .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"e:\\image\\" + file.getAgentphoto() +"\"")
		          .contentType(MediaType.IMAGE_JPEG )
		          .body(file.getAgentphoto());  
		    }
		  
		    return ResponseEntity.status(404).body(null);
		  
		  
	 } 
	  
	  
	 /* @RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
		public @ResponseBody
		String uploadMultipleFileHandler(@RequestParam("name") String[] names,
				@RequestParam("file") MultipartFile[] files) {

			if (files.length != names.length)
				return "Mandatory information missing";

			String message = "";
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				String name = names[i];
				try {
					byte[] bytes = file.getBytes();

					// Creating the directory to store file
					String rootPath = System.getProperty("catalina.home");
					File dir = new File(rootPath + File.separator + "tmpFiles");
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

					logger.info("Server File Location="
							+ serverFile.getAbsolutePath());

					message = message + "You successfully uploaded file=" + name
							+ "<br />";
				} catch (Exception e) {
					return "You failed to upload " + name + " => " + e.getMessage();
				}
			}
			return message;
		}*/
	  
	  
	  
	  
}	
	
	
	
	
	
	
/*---------------------	
	@PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        DBFile dbFile = DBFileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId())
                .toUriString();

        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }
	
	   //Do photo Upload
	@PostMapping("/addPhoto")
	public String savePhoto(HttpServletRequest request,Model model,@ModelAttribute("photoUpload") PhotoUpload phUpload)
	{
	
		return this.savePhoto(request, model, phUpload);
		
	}
	
	// GET: Show upload form page.
	   @RequestMapping(value = "/uploadOneFile", method = RequestMethod.GET)
	   public String uploadOneFileHandler(Model model) {

	      MyUploadForm myUploadForm = new MyUploadForm();
	      model.addAttribute("myUploadForm", myUploadForm);

	      return "uploadOneFile";
	   }


	   @GetMapping("/downloadPhoto/{PhotoId}")
	   public String download(Model model)
	   {
		   PhotoUpload phUpload = new PhotoUpload();
		   model.addAttribute("UploadPhoto" , phUpload);
		   
		   return "downloadphoto";
	   }*/
	
	
	

