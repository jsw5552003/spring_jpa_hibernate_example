package com.jsw.jhse.data.jpa.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.jsw.jhse.data.AppConstants;



@Entity
@Table(name = "TEAM")
public class Team {    
    @Id
    @Column(name = "TEAM_ID", insertable = false, updatable = false)
    @SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "DATABASE_SEQUENCE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGenerator")
    protected Long  teamId;
    
    @Column(name = "NAME")
    protected String name;
    
    @ManyToOne
    @JoinColumn(name="CITY_ID")
    City city;
    
    @Column(name = "LEAGUE")
	@Enumerated(EnumType.STRING)
    AppConstants.League league;
    
    @ManyToMany
    @JoinTable(name="TEAM_PLAYER_XREF",
    		joinColumns={@JoinColumn(name="TEAM_ID")}, 
    	    inverseJoinColumns={@JoinColumn(name="PLAYER_ID")})
    List<Player> players;

	/**
	 * @return the teamId
	 */
	public Long getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * @return the players
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	/**
	 * @return the league
	 */
	public AppConstants.League getLeague() {
		return league;
	}

	/**
	 * @param league the league to set
	 */
	public void setLeague(AppConstants.League league) {
		this.league = league;
	}
   


}
