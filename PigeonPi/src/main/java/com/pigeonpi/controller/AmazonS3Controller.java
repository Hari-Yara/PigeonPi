package com.pigeonpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pigeonpi.service.AmazonS3ClientServiceImpl;

@RestController
public class AmazonS3Controller {

	@Autowired
	public AmazonS3ClientServiceImpl amazonS3ClientServiceImpl;

	@PostMapping("/uploadimage")
	public void uploadFile(@RequestPart(value = "file") MultipartFile multipartFile) {
		amazonS3ClientServiceImpl.uploadFilesToS3Bucket(multipartFile, true);
	}

}
