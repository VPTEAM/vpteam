//@author QUINCHO

package com.vpteam.dao;

import static com.vpteam.dao.Conexion.logger;
import com.vpteam.entities.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao 
{
    public void insertar(Persona objPersona)
    {           
        try 
        {
        	logger.info(Conexion.obtenerInstancia().obtenerConexion());
            PreparedStatement estado = Conexion.obtenerInstancia().obtenerConexion().prepareStatement(
                    "INSERT INTO personas (nombre, apellidos, sexo, cedula) VALUES (?, ?, ?, ?)");
            estado.setString(1, objPersona.getNombre());
            estado.setString(2, objPersona.getApellidos());
            estado.setInt(3, objPersona.getSexo());
            estado.setString(4, objPersona.getCedula());
            estado.executeUpdate();
        }
        catch(SQLException exception)
        {
            logger.error(exception);
            System.out.println("Error: " + exception.getErrorCode() + exception.getMessage());
        }
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
}
