package com.project.javaee.rentmovies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.javaee.rentmovies.model.FileUpload;

@Repository("fileUploadRepository")
public interface FileUploadRepository extends JpaRepository<FileUpload, Long>{

}
