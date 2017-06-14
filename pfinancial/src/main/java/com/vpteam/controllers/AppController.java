package com.vpteam.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.vpteam.dao.PersonaDao;
import com.vpteam.entities.Persona;

@Controller
public class AppController 
{	
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
	public String dashboard()
	{
		return "dashboard";
	}
	
	@RequestMapping(value="/insertarPersona")
	public String storeData()
	{
		//TODO HACER ALGO Y RETORNAR UN PLANTILLA
		return "nueva_persona";
	}
	
	@RequestMapping(value="/insertarPersona", method=RequestMethod.POST)
	public String storeData(WebRequest request)
	{
		logger.info(request.getParameter("nombre"));
		Persona nuevaPersona = new Persona();
		nuevaPersona.setNombre(request.getParameter("nombre"));
		nuevaPersona.setApellidos(request.getParameter("apellidos"));
		nuevaPersona.setSexo(Integer.parseInt(request.getParameter("sexo")));
		nuevaPersona.setCedula(request.getParameter("cedula"));
		PersonaDao personaDao = new PersonaDao();
		personaDao.insertar(nuevaPersona);
	
		return "dashboard";
	}
  }
