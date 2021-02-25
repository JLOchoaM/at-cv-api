package com.jlochoam.atcvapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AtCvApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtCvApiApplication.class, args);
	}

}
