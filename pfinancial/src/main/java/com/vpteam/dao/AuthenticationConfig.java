package com.vpteam.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.vpteam.security.WebSecurityConfig;

@Configuration
@ComponentScan({ "com.vpteam" })
@Import({WebSecurityConfig.class})
public class AuthenticationConfig {
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/pfinancial");
	    driverManagerDataSource.setUsername("root");
	    driverManagerDataSource.setPassword("123456");
	    return driverManagerDataSource;
	}

}
