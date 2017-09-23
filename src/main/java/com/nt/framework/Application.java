package com.nt.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackages = { "com.nt.framework", "com.gaia" })
//@ServletComponentScan(basePackages = { "com.nt.framework", "com.gaia.survey" })
//@MapperScan(basePackages = { "com.gaia.survey.mapper" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
