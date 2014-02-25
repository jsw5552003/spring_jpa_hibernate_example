package com.jsw.jhse.data.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsw.jhse.data.AppConstants;
import com.jsw.jhse.data.AppConstants.League;
import com.jsw.jhse.data.dto.DropDownDto;
import com.jsw.jhse.data.jpa.domain.City;
import com.jsw.jhse.data.jpa.domain.Team;
import com.jsw.jhse.data.jpa.repository.CityRepository;
import com.jsw.jhse.data.jpa.repository.TeamRepository;
import com.jsw.jhse.data.services.TeamService;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	
	@Resource
    private TeamRepository teamRepository;
	
	@Resource
	private CityRepository cityRepository;

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
	
	public List<DropDownDto> getAllLeagues()
	{
		return AppConstants.getLeaguesAsDropDownDtos();
	}

	@Override
	public List<City> getAllCities() {
		return cityRepository.findAll();
	}

}
