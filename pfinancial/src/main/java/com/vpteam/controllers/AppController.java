package com.vpteam.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vpteam.dao.PersonaDao;
import com.vpteam.entities.Persona;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController 
{	
	List<Persona> listaPersona = new ArrayList<>();
	final static Logger logger = Logger.getLogger(AppController.class);
	@RequestMapping(value="/login")
	public String login()
	{	
		return "login";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response)
	{	
		HttpSession session= request.getSession(false);
	    SecurityContextHolder.clearContext();
        session= request.getSession(false);
        if(session != null) 
        {
            session.invalidate();
        }
        for(Cookie cookie : request.getCookies()) 
        {
            cookie.setMaxAge(0);
        }
	    return "login";
	}
	
	@RequestMapping(value="/dashboard")
	public String dashboard(Model model)
	{
            model.addAttribute("persona", new Persona());
            List<Persona> listaPersona = new ArrayList<>();
            PersonaDao personaDao = new PersonaDao();
            listaPersona = personaDao.seleccionar();
            model.addAttribute("personas", listaPersona); 
            return "dashboard";
	}
	
	@RequestMapping(value="/insertarPersona")
	public String storeData(Model model)
	{	
            model.addAttribute("persona", new Persona());
            return "nueva_persona";
	}
	
	@RequestMapping(value="/insertarPersona", method=RequestMethod.POST)
	public String storeData(@ModelAttribute Persona persona, Model model)
	{
            PersonaDao personaDao = new PersonaDao();
            int id = personaDao.insertar(persona);
            persona.setId(id);
            listaPersona = personaDao.seleccionar();
            model.addAttribute("personas", listaPersona); 
            return "redirect:/dashboard";
	}
        
        @RequestMapping(value="/imprimirPersonas")
        public String meCago(Model modelo)
        {
            List<Persona> listaPersona = new ArrayList<>();
            PersonaDao personaDao = new PersonaDao();
            listaPersona = personaDao.seleccionar();
            modelo.addAttribute("personas", listaPersona); 
            
            /*for (Persona persona : personaDao.seleccionar())
                logger.info(persona.getNombre() + "\t" + persona.getApellidos() + "\t" + persona.getSexo() +
                        "\t" + persona.getSexo());*/
            return "dashboard";
        }
  }
