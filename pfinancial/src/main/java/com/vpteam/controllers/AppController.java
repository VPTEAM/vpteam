package com.vpteam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class AppController 
{	
	@RequestMapping(value="/login")
	public String login()
	{	
		return "login";
	}
	
	@RequestMapping(value="/dashboard")
	public String dashboard()
	{
		return "dashboard";
	}
	
	@RequestMapping(value="/storeData", method=RequestMethod.POST)
	public String storeData(WebRequest request)
	{
		//TODO HACER ALGO Y RETORNAR UN PLANTILLA
		return "dashboard";
	}
}
