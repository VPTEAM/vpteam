
package com.vpteam;

import com.vpteam.dao.PersonaDao;
import com.vpteam.entities.Persona;
import org.junit.Assert;
import org.junit.Test;

public class PersonaDaoTests 
{
    @Test
    public void insertar()
    {
        PersonaDao personaDao = new PersonaDao();
        int resultado = personaDao.insertar( new Persona("Arturo", "Sanchez", 1, "777"));
        Assert.assertEquals(7, resultado);
    }
}
