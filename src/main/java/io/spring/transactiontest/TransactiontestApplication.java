package io.spring.transactiontest;

import io.spring.transactiontest.configuration.JobAConfiguration;
import io.spring.transactiontest.configuration.JobBConfiguration;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.GenericApplicationContextFactory;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@EnableBatchProcessing(modular = true)
@EnableTask
@SpringBootApplication
public class TransactiontestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactiontestApplication.class, args);
	}

	//Doesn't compile
//	@Bean
//	ApplicationContextFactory getJobAContext() {
//		return new GenericApplicationContextFactory(JobAConfiguration.class);
//	}
//
//	@Bean
//	ApplicationContextFactory getJobBContext() {
//		return new GenericApplicationContextFactory(JobBConfiguration.class);
//	}

}
