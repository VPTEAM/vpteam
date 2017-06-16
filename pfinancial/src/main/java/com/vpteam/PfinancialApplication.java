package com.vpteam;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.vpteam")
@SpringBootApplication
public class PfinancialApplication {

	public static void main(String[] args) {
		SpringApplication.run(PfinancialApplication.class, args);
    
	}
}
