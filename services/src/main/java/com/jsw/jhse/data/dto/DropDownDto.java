package com.jsw.jhse.data.dto;

public class DropDownDto {
	
	private String name;
	private Long id;
	
	/**
	 * @param name
	 * @param id
	 */
	public DropDownDto(String name, Long id) {
		this.name = name;
		this.id = id;
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
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
