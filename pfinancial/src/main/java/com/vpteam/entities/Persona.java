// @author QUINCHO

package com.vpteam.entities;
 
public class Persona 
{
    private String nombre;
    private String apellidos;
    private int sexo;
    private String cedula;
    
    public Persona()
    {
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getApellidos() 
    {
        return apellidos;
    }

    public void setApellidos(String apellidos) 
    {
        this.apellidos = apellidos;
    }

    public int getSexo() 
    {
        return sexo;
    }

    public void setSexo(int sexo) 
    {
        this.sexo = sexo;
    }

    public String getCedula() 
    {
        return cedula;
    }

    public void setCedula(String cedula) 
    {
        this.cedula = cedula;
    } 
}
