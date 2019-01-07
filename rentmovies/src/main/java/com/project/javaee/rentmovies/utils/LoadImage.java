package com.project.javaee.rentmovies.utils;

import java.io.File;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadImage
 */
@WebServlet(urlPatterns = "/image/*")
public class LoadImage extends HttpServlet {
	
	private String imagePath;
	
	@Override
	public void init() throws ServletException {
		imagePath = System.getProperty("catalina.home") + File.separator + "images";
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Get requested image by path info
		String requestedImage = request.getPathInfo();
		
		
		//Check if file name is actually supplied to the request URI
		if(requestedImage == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		//DEcode the file name and prepare file object
		File image = new File(imagePath, URLDecoder.decode(requestedImage, "UTF-8"));
		
		//Verify if file exists in filesystems
		if(!image.exists()) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		//Get content type by filename
		String contentType = getServletContext().getMimeType(image.getName());
		
		if(contentType == null || !contentType.startsWith("image")) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		response.reset();
		response.setContentType(contentType);
		response.setHeader("Content-Length", String.valueOf(image.length()));
		
		//Write image content to response
		Files.copy(image.toPath(), response.getOutputStream());
	}


}
