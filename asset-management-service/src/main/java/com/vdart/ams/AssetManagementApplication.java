package com.vdart.ams;

import com.vdart.ams.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class AssetManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetManagementApplication.class, args);
	}
}
