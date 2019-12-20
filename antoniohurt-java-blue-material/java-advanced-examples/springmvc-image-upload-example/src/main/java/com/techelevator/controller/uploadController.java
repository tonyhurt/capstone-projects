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
 *  5. GET Method to retrieve the image
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
		 * Gets the File Path and gives it a name.  In this case all images are named 'testimage', which
		 * means it will overwrite images previously uploaded.   If your project needs more than a single image, then
		 * you will need to replace "testimage" with a unique name for each file being uploaded.   A Database Sequence or 
		 * a GUID would both be good choices.
		 */
		File imagePath = getImageFilePath();
		String imageName = imagePath + File.separator + "testImage";
		
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
		return "showFile";
	}
	
	
	/*
	 * This is an API method, even though it is in our standard controller.  Since the image cannot be stored in the
	 * webapp folder the view files cannot access it.  This API gets the image by the name created in the original 
	 * upload API call and returns it as a byte[].  The HTML <img> tag can display a byte[] if it contains an image.
	 * 
	 * In the JSP, the img src should be set to /image/<imageName>
	 * For example, if during the upload the image was saved with the name 123, then in the JSP, you would use
	 * 		<img src="<c:url value="/image/123" />" /> 
	 * to display the image
	 * 
	 */
	@RequestMapping(path="/image/{imageName}", method=RequestMethod.GET)
	@ResponseBody
	public byte[] getImage(@PathVariable(value="imageName") String imageName) {
		
		/*
		 * Gets the path to the image file on the server and creates a File object from it
		 */
		String imagePath = getServerContextPath() + File.separator + imageName;
		File image = new File(imagePath);
		
		try {
			/*
			 * Converts the Image File to a byte[] and returns it
			 */
			return Files.readAllBytes(image.toPath());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Gets a FILE object with the path to the directory on the server
	 * where the files are stored.   This path can be anywhere on the server, but
	 * cannot be inside the exploded WAR (project), so it cannot be inside the webapp folder.
	 * @return
	 */
	private File getImageFilePath() {
		String serverPath = getServerContextPath();
		File filePath = new File(serverPath);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		return filePath;
	}
	
	/**
	 * Gets the path to the upload folder.  In this case it uses the ServletContext to get
	 * the path to Tomcat and then an upload folder inside of that folder.  This context can 
	 * be changed to any folder on the server you like, PROVIDED that it is NOT IN THE WEBAPP folder
	 * of the project.
	 * @return
	 */
	private String getServerContextPath() {
		return servletContext.getRealPath("/") + "uploads";
	}
	
	/**
	 * Writes the MultipartFile to the server.  In this case we use the BufferredOutputStream, however, 
	 * there are other ways to write the file. 
	 */
	private void createImage(MultipartFile file, String name) {
		File image = new File(name);
		try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(image))) {
	
			stream.write(file.getBytes());
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
