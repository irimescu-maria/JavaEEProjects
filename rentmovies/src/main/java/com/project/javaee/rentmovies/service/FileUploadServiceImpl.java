package com.project.javaee.rentmovies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.javaee.rentmovies.model.FileUpload;
import com.project.javaee.rentmovies.repository.FileUploadRepository;

@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService{

	@Autowired
	private FileUploadRepository fileUploadRepository; 
	
	@Override
	@Transactional
	public FileUpload add(FileUpload fileUpload) {
		fileUploadRepository.save(fileUpload);
		return fileUpload;
	}

}
