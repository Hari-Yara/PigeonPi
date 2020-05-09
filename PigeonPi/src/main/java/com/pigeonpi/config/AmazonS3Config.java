package com.pigeonpi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;

@Configuration
public class AmazonS3Config {

	@Value("${aws.access.key.id}")
	private String awsAccessKeyId;
	@Value("${aws.access.secret.key}")
	private String awsAccessSecretKey;
	@Value("${aws.region}")
	private String awsRegion;
	@Value("${aws.s3.circles.bucket}")
	private String awsS3CirclesBucket;

	@Bean(name = "awsAccessKeyId")
	public String getAwsAccessKeyId() {
		return awsAccessKeyId;
	}

	@Bean(name = "awsAccessSecretKey")
	public String getAwsAccessSecretKey() {
		return awsAccessSecretKey;
	}

	@Bean(name = "awsRegion")
	public Region getAwsRegion() {
		return Region.getRegion(Regions.fromName(awsRegion));
	}

	@Bean(name = "awsS3CirclesBucket")
	public String getAwsS3CirclesBucket() {
		return awsS3CirclesBucket;
	}

	@Bean(name = "awsCredentialsProvider")
	public AWSCredentialsProvider getAwsCredentials() {
		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(awsAccessKeyId, awsAccessSecretKey);
		return new AWSStaticCredentialsProvider(awsCredentials);
	}
}
