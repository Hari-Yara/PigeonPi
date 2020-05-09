package com.pigeonpi.service;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Component
public class AmazonS3ClientServiceImpl implements AmazonS3ClientService {

	private AmazonS3 amazonS3;
	private String awsS3CirclesBucket;

	@Autowired
	public AmazonS3ClientServiceImpl(AWSCredentialsProvider awsCredentialsProvider, Region region,
			String awsS3CirclesBucket) {
		this.amazonS3 = AmazonS3ClientBuilder.standard().withCredentials(awsCredentialsProvider)
				.withRegion(region.getName()).build();
		this.awsS3CirclesBucket = awsS3CirclesBucket;
	}

	@Override
	public void uploadFilesToS3Bucket(MultipartFile multipartFile, boolean enablePublicReadAccess) {
		String fileName = multipartFile.getOriginalFilename();
		System.out.println(multipartFile.getOriginalFilename());
		System.out.println(multipartFile.getSize());
		try {
			File file = new File(fileName);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(multipartFile.getBytes());
			fos.close();
			System.out.println("length before: "+file.length());
			PutObjectRequest putObjectRequest = new PutObjectRequest(awsS3CirclesBucket, "abcdef", file);
			if (enablePublicReadAccess) {
				putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead);
				System.out.println("True");
			}
			amazonS3.putObject(putObjectRequest);
			System.out.println("length: "+file.length());
		

			file.delete();

		} catch (Exception e) {

		}

	}

	@Override
	public void deleteFileFromS3Bucket() {
		// TODO Auto-generated method stub

	}

}
