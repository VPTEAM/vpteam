// @author QUINCHO

package com.vpteam.entities;
 
public class Persona 
{
    private int id;
    private String nombre;
    private String apellidos;
    private int sexo;
    private String cedula;
    
    public Persona ()
    {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Persona(String nombre, String apellidos, int sexo, String cedula)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.cedula = cedula;
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
