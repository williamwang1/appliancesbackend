package com.capgemini.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//public class TestApplication extends SpringBootServletInitializer {
public class TestApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
}

//@Override
//protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//	return application.sources(TestApplication.class);
//}
//
//	public static void main(String[] args) throws Exception {
//		SpringApplication.run(TestApplication.class, args);
//	}
//
//}



