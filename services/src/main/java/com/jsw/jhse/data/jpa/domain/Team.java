package com.jsw.jhse.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



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
   


}
