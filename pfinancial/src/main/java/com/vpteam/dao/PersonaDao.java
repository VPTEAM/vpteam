//@author QUINCHO

package com.vpteam.dao;

import static com.vpteam.dao.Conexion.logger;
import com.vpteam.entities.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao 
{
    private Statement estado;
    
    public void insertar(Persona objPersona)
    {   
        String query = "INSERT INTO personas (nombre, apellidos, sexo, cedula) VALUES " + 
                       "(" + "'" + objPersona.getNombre() + "'" + 
                       ", " + "'" + objPersona.getApellidos() + "'" + 
                       ", " + + objPersona.getSexo() + 
                       ", " + "'" + objPersona.getCedula() + "'" + ")";
        
        try 
        {                    
            estado = Conexion.obtenerInstancia().obtenerConexion().createStatement();  // EN ESTA LINEA ME DA EL ERROR
            estado.execute(query);
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
            estado = Conexion.obtenerInstancia().obtenerConexion().createStatement();
            rs = estado.executeQuery("SELECT * FROM personas");
            
            while(rs.next())
                lista.add( new Persona( rs.getString(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4) ) );
        }
        catch(SQLException exception)
        {
            logger.error(exception);
            System.out.println("Error: " + exception.getErrorCode() + exception.getMessage());
        }
        
        return lista;
    }
}
