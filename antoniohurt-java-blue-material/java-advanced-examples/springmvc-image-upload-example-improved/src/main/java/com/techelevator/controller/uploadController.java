package com.techelevator.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/*
 * File Upload Requires the following parts.  Each part has comments in the respective files that indicate the
 * required changes
 * 	1. Addition of the FileUpload and IO library in the pom.xml
 *  2. Addition of multipartResolver in springmvc-servlet.xml
 *  
 *  To Upload the Image
 *  3. POST Method to receive the file as a MultipartFile
 *  4. JSP Form that uploads a file as Multipart Data
 *  
 *  To Display the image
 *  5. Addition of resource mapping entry in springmvc-servlet.xml
 */


@Controller
public class uploadController {

	/*
	 * ServletContext is required to get the File Path on the Server
	 */
	@Autowired
	ServletContext servletContext;
	
	/*
	 * Basic GET to show the upload form
	 */
	@RequestMapping(path= {"/", "/upload"}, method=RequestMethod.GET)
	public String showUploadForm() {
		return "uploadForm";
	}
	
	/**
	 * POST Method to upload the file
	 * 
	 * @param file [MultipartFile] - the file being uploaded
	 * @param map [ModelMap] - used for output
	 * @return [String] - logical view name or redirect
	 */
	@RequestMapping(path="/uploadFile", method=RequestMethod.POST)
	public String handleFileUpload(@RequestParam MultipartFile file, ModelMap map) {
		
		/*
		 * Gets the File Path and gives it a name.  In this case all images use their original filename, which
		 * means it may overwrite images previously uploaded with the same name.   
		 * If your project needs more than a single image, then
		 * you will need to replace "testimage" with a unique name for each file being uploaded.   
		 * A Database Sequence or a GUID would both be good choices.
		 */
		String originalFileName = file.getOriginalFilename();
		File imagePath = getImageFilePath();
		String imageName = imagePath + File.separator + originalFileName;
		
		/*
		 * If the MultipartFile object is not empty, then write it to the disk
		 */
		if (file.isEmpty()) {
			map.addAttribute("message", "File Object empty");
		} else {
			createImage(file, imageName);
		}
		
		/*
		 * The message is just used for the demo to display the full file path and name on the server on the web page.
		 * For most projects you won't want to do this, instead you would probably want to do something like save the 
		 * filename to a database so you know which filename goes with which entity on your site.
		 */
		map.addAttribute("message", imageName);
		map.addAttribute("imgFileName", originalFileName);
		return "showFile";
	}
	
	

	
	/**
	 * Gets a FILE object with the path to the directory on the server
	 * where the files are stored.  This directory MUST be mapped as a resource in the springmvc-servlet.xml
	 * This path must be in the servlet context, but
	 * cannot be inside the exploded WAR (project), so it cannot be inside the webapp folder.
	 * @return
	 */
	private File getImageFilePath() {
		String serverPath = getServerContextPath();
		
		/*
		 * This should only ever run once, but prevents the need for the folder to be manually
		 * created when the project is deployed.
		 */
		File filePath = new File(serverPath);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		return filePath;
	}
	
	/**
	 * Gets the path to the upload folder.  Use the ServletContext to get
	 * the path to Tomcat and then an upload folder inside of that folder.  This will allow for the folder
	 * to be mapped as a resource in the springmvc-servlet.xml/
	 * @return
	 */
	private String getServerContextPath() {
		return servletContext.getRealPath("/") + "images";
	}
	
	/**
	 * Writes the MultipartFile to the server.  In this case we use the MultipartFile's transferTo method, 
	 * which takes a File object that has the path to the file to be saved.
	 */
	private void createImage(MultipartFile file, String name) {
		File imageFile = new File(name);
		
		try {
			file.transferTo(imageFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
