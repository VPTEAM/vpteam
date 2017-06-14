package com.vpteam.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.vpteam.security.WebSecurityConfig;
import com.vpteam.utils.Propiedades;

@Configuration
@ComponentScan({ "com.vpteam" })
@Import({WebSecurityConfig.class})
public class AuthenticationConfig {
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setUrl("jdbc:mysql://"+Propiedades.obtenerInstancia().getMysqlHost()+":3306/"+Propiedades.obtenerInstancia().getMysqlDatabase());
	    driverManagerDataSource.setUsername(Propiedades.obtenerInstancia().getMysqlUser());
	    driverManagerDataSource.setPassword(Propiedades.obtenerInstancia().getMysqlPassword());
	    return driverManagerDataSource;
	}

}
