package com.bwa.crowdfunding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

// (scanBasePackages = {"org.hibernate"}, exclude = Session.class)
@SpringBootApplication
@ComponentScan(
		basePackages = {
//				"org.hibernate",
				"com.bwa.crowdfunding",
				"com.bwa.crowdfunding.utilities.config",
				"com.bwa.crowdfunding.dao"
		}
)
public class CrowdfundingBwaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrowdfundingBwaApplication.class, args);
	}


}
