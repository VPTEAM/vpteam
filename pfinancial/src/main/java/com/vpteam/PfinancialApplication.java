package com.vpteam;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.vpteam.dao.PersonaDao;
import com.vpteam.entities.Persona;

@ComponentScan("com.vpteam")
@SpringBootApplication
public class PfinancialApplication {

	public static void main(String[] args) {
		SpringApplication.run(PfinancialApplication.class, args);
                
                Persona persona = new Persona();
                persona.setNombre("Maria");
                persona.setApellidos("Araya");
                persona.setSexo(1);
                persona.setCedula("333");
                
                PersonaDao personaDao = new PersonaDao();
                personaDao.insertar(persona);
	}
}
