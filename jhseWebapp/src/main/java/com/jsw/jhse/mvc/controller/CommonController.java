package com.jsw.jhse.mvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsw.jhse.data.dto.DropDownDto;
import com.jsw.jhse.data.services.TeamService;

@Controller
public class CommonController {
	
	private static final Logger log = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private TeamService teamService;
	
	/**
     * Returns all leagues as a JSON string.
     * 
     * @return A <code>List</code> of <code>DropDownDto</code> objects as a JSON string.
     */
    @RequestMapping(value = "/json/getAllLeagues.do")
    public @ResponseBody
    List<DropDownDto> getAllLeagues() {

        log.info("Calling getBusinessUnits()...");

        List<DropDownDto> buDtoList = teamService.getAllLeagues();

        return buDtoList;
    }

}
