package com.example.demo;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.demo"})
public class FileUploadApplication {

	public static void main(String[] args) {
		
		new File(MainController.uploadDirectory).mkdir();
		
		SpringApplication.run(FileUploadApplication.class, args);
	}

}
