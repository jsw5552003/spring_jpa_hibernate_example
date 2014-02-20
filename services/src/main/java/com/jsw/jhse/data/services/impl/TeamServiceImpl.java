package com.jsw.jhse.data.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsw.jhse.data.jpa.domain.Team;
import com.jsw.jhse.data.jpa.repository.TeamRepository;
import com.jsw.jhse.data.services.TeamService;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	
	@Resource
    private TeamRepository teamRepository;

	@Override
	public List<Team> getAllTeams() {
		return teamRepository.findAll();
	}

}
