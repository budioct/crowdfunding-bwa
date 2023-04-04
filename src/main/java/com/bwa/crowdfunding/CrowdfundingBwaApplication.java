package com.bwa.crowdfunding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(
		basePackages = {
				"com.bwa.crowdfunding.utilities.config"
		}
)
public class CrowdfundingBwaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrowdfundingBwaApplication.class, args);
	}

}
