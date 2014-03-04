package com.jsw.jhse.data.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsw.jhse.data.AppConstants;
import com.jsw.jhse.data.AppConstants.League;
import com.jsw.jhse.data.dto.DropDownDto;
import com.jsw.jhse.data.jpa.domain.City;
import com.jsw.jhse.data.jpa.domain.Player;
import com.jsw.jhse.data.jpa.domain.Team;
import com.jsw.jhse.data.jpa.repository.CityRepository;
import com.jsw.jhse.data.jpa.repository.PlayerRepository;
import com.jsw.jhse.data.jpa.repository.TeamRepository;
import com.jsw.jhse.data.services.TeamService;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	
	@Resource
    private TeamRepository teamRepository;
	
	@Resource
	private CityRepository cityRepository;
	
	@Resource
	private PlayerRepository playerRepository;
	
	private static final Logger log = LoggerFactory.getLogger(TeamService.class);

	@Override
	public List<Team> getAllTeams() {
		List<Team> teams = teamRepository.findAll();
		for(Team team : teams)
		{
			team.getPlayers().size();
		}
		return teams;
	}
	
	@Override
	public List<DropDownDto> getAllTeamsAsDropDown() {
		List<Team> teams = teamRepository.findAll();
		List<DropDownDto> dropDownList = new ArrayList<DropDownDto>();
		if(teams != null)
		{
			for(Team team : teams)
			{
				dropDownList.add(new DropDownDto(team.getName(), team.getTeamId()));
			}
		}
		return dropDownList;
	}

	@Override
	public List<Team> getAllTeamsByCity(City city) {
		List<Team> teams = teamRepository.findByCity(city);
		for(Team team : teams)
		{
			team.getPlayers().size();
		}
		return teams;
	}

	@Override
	public List<Team> getAllTeamsByLeague(League league) {
		List<Team> teams = teamRepository.findByLeague(league);
		for(Team team : teams)
		{
			team.getPlayers().size();
		}
		return teams;
	}
	
	public List<DropDownDto> getAllLeaguesAsDropDown()
	{
		return AppConstants.getLeaguesAsDropDownDtos();
	}

	@Override
	public List<City> getAllCities() {
		log.info("Calling getAllCities()...");
		return cityRepository.findAll();
	}
	
	@Override
	public List<DropDownDto> getAllCitiesAsDropDown() {
		List<City> cities = cityRepository.findAll();
		List<DropDownDto> dropDownList = new ArrayList<DropDownDto>();
		if(cities != null)
		{
			for(City city : cities)
			{
				dropDownList.add(new DropDownDto(city.getName(), city.getTeamId()));
			}
		}
		return dropDownList;
	}
	
	@Override
	public List<DropDownDto> getAllPlayersAsDropDown() {
		List<Player> players = playerRepository.findAll();
		List<DropDownDto> dropDownList = new ArrayList<DropDownDto>();
		if(players != null)
		{
			for(Player player : players)
			{
				dropDownList.add(new DropDownDto((player.getFirstName() + " " + player.getLastName()),
						player.getTeamId()));
			}
		}
		return dropDownList;
	}

}
