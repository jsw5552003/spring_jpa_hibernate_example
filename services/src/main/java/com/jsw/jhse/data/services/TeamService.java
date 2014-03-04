package com.jsw.jhse.data.services;

import java.util.List;

import com.jsw.jhse.data.AppConstants;
import com.jsw.jhse.data.dto.DropDownDto;
import com.jsw.jhse.data.jpa.domain.City;
import com.jsw.jhse.data.jpa.domain.Team;

public interface TeamService {
	
	List<Team> getAllTeams();
	
	List<DropDownDto> getAllTeamsAsDropDown();
	
	List<Team> getAllTeamsByCity(City city);
	
	List<Team> getAllTeamsByLeague(AppConstants.League league);
	
	List<City> getAllCities();
	
	List<DropDownDto> getAllCitiesAsDropDown();
	
	List<DropDownDto> getAllLeaguesAsDropDown();
	
	List<DropDownDto> getAllPlayersAsDropDown();

}
