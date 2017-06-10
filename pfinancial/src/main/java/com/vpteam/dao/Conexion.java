package com.vpteam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.vpteam.PfinancialApplication;


public final class Conexion 
{
	final static Logger logger = Logger.getLogger(PfinancialApplication.class);
	private static Conexion instancia = null;
	private Connection conexionConBd;
	
	private Conexion()
	{
		crearConexion();
	};
	
	public static Conexion obtenerInstancia()
	{
		if(instancia == null)
		{
			return new Conexion();
		}
		return instancia;
	}
	
	public Connection obtenerConexion()
	{
		return conexionConBd;
	}
	
	private void crearConexion()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexionConBd = DriverManager.getConnection("jdbc:mysql://localhost/pfinancial", "root", "123456");
		}
		catch(SQLException | ClassNotFoundException exception)
		{
			logger.error(exception);
		}
	}
	
}
