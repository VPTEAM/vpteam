package com.vpteam.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public final class Propiedades 
{	
	private static Propiedades instancia = null;
	final static Logger logger = Logger.getLogger(Propiedades.class);
	Properties properties = new Properties();
	
	private static String mysqlDatabase;
	private static String mysqlHost;
	private static String mysqlUser;
	private static String mysqlPassword;
	
	private Propiedades()
	{
		getProperties();
	}
	
	private void getProperties()
	{
		InputStream inpStream = getClass().getClassLoader().getResourceAsStream("application.properties");
		if(inpStream != null)
		{
			try 
			{
				properties.load(inpStream);
			} 
			catch (IOException e) 
			{
				logger.error(e.getStackTrace());
			}
		}
		
		mysqlDatabase = properties.getProperty("mysql.database");
		mysqlHost = properties.getProperty("mysql.host");
		mysqlUser = properties.getProperty("mysql.user");
		mysqlPassword = properties.getProperty("mysql.password");
	}
	
	public static Propiedades obtenerInstancia()
	{
		if(instancia == null)
		{
			return new Propiedades();
		}
		return instancia;
	}

	public String getMysqlDatabase() {
		return mysqlDatabase;
	}

	public String getMysqlHost() {
		return mysqlHost;
	}

	public String getMysqlUser() {
		return mysqlUser;
	}

	public String getMysqlPassword() {
		return mysqlPassword;
	}
}
