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

        log.info("Calling getAllLeagues()...");

        List<DropDownDto> buDtoList = teamService.getAllLeaguesAsDropDown();

        return buDtoList;
    }
    
    /**
     * Returns all cities as a JSON string.
     * 
     * @return A <code>List</code> of <code>DropDownDto</code> objects as a JSON string.
     */
    @RequestMapping(value = "/json/getAllCities.do")
    public @ResponseBody
    List<DropDownDto> getAllCities() {

        log.info("getAllCities: starting...");
        List<DropDownDto> dropDownList = teamService.getAllCitiesAsDropDown();
        log.info("getAllCities: returning...");
        return dropDownList;
    }
    
    /**
     * Returns all teams as a JSON string.
     * 
     * @return A <code>List</code> of <code>DropDownDto</code> objects as a JSON string.
     */
    @RequestMapping(value = "/json/getAllTeams.do")
    public @ResponseBody
    List<DropDownDto> getAllTeams() {

        log.info("getAllTeams: starting...");
        List<DropDownDto> dropDownList = teamService.getAllTeamsAsDropDown();
        log.info("getAllTeams: returning...");
        return dropDownList;
    }
    
    /**
     * Returns all players as a JSON string.
     * 
     * @return A <code>List</code> of <code>DropDownDto</code> objects as a JSON string.
     */
    @RequestMapping(value = "/json/getAllPlayers.do")
    public @ResponseBody
    List<DropDownDto> getAllPlayers() {

        log.info("getAllPlayers: starting...");
        List<DropDownDto> dropDownList = teamService.getAllPlayersAsDropDown();
        log.info("getAllPlayers: returning...");
        return dropDownList;
    }

}
