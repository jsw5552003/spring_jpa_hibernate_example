package com.jsw.jhse.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsw.jhse.data.AppConstants;
import com.jsw.jhse.data.jpa.domain.City;
import com.jsw.jhse.data.jpa.domain.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

	public List<Team> findByCity(City city);
	
	public List<Team> findByLeague(AppConstants.League league);
}
