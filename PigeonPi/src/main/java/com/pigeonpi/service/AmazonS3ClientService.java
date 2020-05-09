package com.pigeonpi.service;

import org.springframework.web.multipart.MultipartFile;

public interface AmazonS3ClientService {

	void uploadFilesToS3Bucket(MultipartFile multipartFile, boolean enablePublicReadAccess);

	void deleteFileFromS3Bucket();
}
