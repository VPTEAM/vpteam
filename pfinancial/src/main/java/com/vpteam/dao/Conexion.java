package com.vpteam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.vpteam.PfinancialApplication;
import com.vpteam.utils.Propiedades;

public final class Conexion 
{
    private static final String MYSQL_DATABASE = Propiedades.obtenerInstancia().getMysqlDatabase();
	private static final String MYSQL_PASSWORD = Propiedades.obtenerInstancia().getMysqlPassword();
	private static final String MYSQL_USER = Propiedades.obtenerInstancia().getMysqlUser();
	private static final String CONNECTION_STRING = "jdbc:mysql://" + Propiedades.obtenerInstancia().getMysqlHost() +"/"+ MYSQL_DATABASE;
    
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
            return new Conexion();
	
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
            Class.forName("com.mysql.jdbc.Driver");
            conexionConBd = DriverManager.getConnection(CONNECTION_STRING, MYSQL_USER, MYSQL_PASSWORD);
	}
	
        catch(SQLException | ClassNotFoundException exception)
	{
            logger.error(exception);
	}
    }	
}
