package com.test.filePoller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.test")
public class FilePollerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilePollerApplication.class, args);
	}

}
