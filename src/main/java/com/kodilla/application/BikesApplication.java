package com.kodilla.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;


@SpringBootApplication
public class BikesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikesApplication.class, args);
	}

}
