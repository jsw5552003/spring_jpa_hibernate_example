package com.jsw.jhse.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsw.jhse.data.services.TeamService;

@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping(value = "/home")
	public String home()
	{
		log.info("  Request mapping of home.");
		return "home";
	}

}
