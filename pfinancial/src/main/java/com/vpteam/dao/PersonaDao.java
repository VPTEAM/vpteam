//@author QUINCHO

package com.vpteam.dao;

import static com.vpteam.dao.Conexion.logger;
import com.vpteam.entities.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao 
{
    public int insertar(Persona objPersona)
    {  
        int id = 0;
        
        try 
        {
            logger.info(Conexion.obtenerInstancia().obtenerConexion());
            Statement statement = Conexion.obtenerInstancia().obtenerConexion().createStatement();
            PreparedStatement estado = Conexion.obtenerInstancia().obtenerConexion().prepareStatement(
                    "INSERT INTO personas (nombre, apellidos, sexo, cedula) VALUES (?, ?, ?, ?);"
                            , statement.RETURN_GENERATED_KEYS);
            estado.setString(1, objPersona.getNombre());
            estado.setString(2, objPersona.getApellidos());
            estado.setInt(3, objPersona.getSexo());
            estado.setString(4, objPersona.getCedula());
            estado.execute();
            ResultSet rs = estado.getGeneratedKeys();             
                         
            while(rs.next())             	
                id = rs.getInt(1);
            
            logger.info("Id: " + id);
        }
        catch(SQLException exception)
        {
            logger.error(exception);
        }
        
        return id;
    }
    
    public List<Persona> seleccionar()
    {
        ResultSet rs;
        List<Persona> lista = new ArrayList<>();
        
        try 
        {
             PreparedStatement estado = Conexion.obtenerInstancia().obtenerConexion().prepareStatement(
                    "SELECT * FROM personas");
            //estado = Conexion.obtenerInstancia().obtenerConexion().createStatement();
            rs = estado.executeQuery();
            
            while(rs.next())
                lista.add( new Persona( rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getString(5) ) );
            
        }
        catch(SQLException exception)
        {
            logger.error(exception);
            System.out.println("Error: " + exception.getErrorCode() + exception.getMessage());
        }
        
        return lista;
    }
    
    public void eliminar(int id)
    {
        try
        {
            PreparedStatement estado = Conexion.obtenerInstancia().obtenerConexion().prepareStatement(
                    "DELETE * FROM personas WHERE id = ?");
            estado.setInt(1, id);
            estado.executeUpdate();
        }
        catch(SQLException exception)
        {
            logger.error(exception);
            System.out.println("Error: " + exception.getErrorCode() + exception.getMessage());
        }
    }
    
    public void actualizar(int id, Persona persona)
    { 
        String query = "UPDATE personas SET nombre = ?, apellidos = ?, sexo = ?, cedula = ? " +
                       "WHERE id = ?";
        
        try 
        {
            PreparedStatement estado = Conexion.obtenerInstancia().obtenerConexion().prepareStatement(query);
            estado.setString(1, persona.getNombre());
            estado.setString(2, persona.getApellidos());
            estado.setInt(3, persona.getSexo());
            estado.setString(4, persona.getCedula());
            estado.setInt(5, id);
            estado.executeUpdate();
        }
        catch(SQLException exception)
        {
            logger.error(exception);
            logger.info("Error: " + exception.getErrorCode() + exception.getMessage());
        }
    }
    
    
    public int numeroDePaginas()
    {
    	ResultSet rs;
    	String query = "SELECT COUNT(*)   FROM personas";
    	int cantidadDePaginas = 0;
    	try 
    	{
    		PreparedStatement preparedStatement = Conexion.obtenerInstancia().obtenerConexion().prepareStatement(query);
    		rs = preparedStatement.executeQuery();
    	 	while(rs.next())
        	{
    	 		cantidadDePaginas = rs.getInt(1);
        	}
		} catch (SQLException sql) 
    	{
			logger.error(sql);
		}
    	return cantidadDePaginas;
    }
    
    /////////////////////////////////////   (2-1 * 10)           10
    public List<Persona> pagSeleccionar(int indice, int cantidad)
    {
        ResultSet rs;
        List<Persona> lista = new ArrayList<>();
        String query = "SELECT * FROM personas LIMIT ?, ?";
        
        try 
        {
            PreparedStatement estado = Conexion.obtenerInstancia().obtenerConexion().prepareStatement(query);
            estado.setInt(1, indice);
            estado.setInt(2, cantidad);
            rs = estado.executeQuery();
            
            while(rs.next())
                lista.add( new Persona( rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getString(5) ) );
        }
        catch(SQLException exception)
        {
            logger.error(exception);
            logger.info("Error: " + exception.getErrorCode() + exception.getMessage());
        }
        
        return lista;
    }
}
