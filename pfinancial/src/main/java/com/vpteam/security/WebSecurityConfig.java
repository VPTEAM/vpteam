package com.vpteam.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery(
			"select username, role from user_roles where username=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		  http
          .authorizeRequests().antMatchers("/dasboard", "/insertarPersona").access("hasRole('ROLE_ADMIN')")
              .antMatchers("/", "/home", "/css/**", "/handlebars/**", "/js/**", "/fragments/**").permitAll()
              .anyRequest().authenticated()
              .and()
          .formLogin()
              .loginPage("/login")
              .permitAll()
              .defaultSuccessUrl("/dashboard")
              .and()
          .logout().logoutSuccessUrl("/login").deleteCookies("JSESSIONID").invalidateHttpSession(true)
          .and().csrf().ignoringAntMatchers("/login");
		
	}
	

}
