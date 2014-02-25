package com.jsw.jhse.data;

import java.util.ArrayList;
import java.util.List;

import com.jsw.jhse.data.dto.DropDownDto;

public class AppConstants {

	public static enum League { NBA, NHL, NFL, MLB};
	
	public static List<DropDownDto> getLeaguesAsDropDownDtos()
	{
		List<DropDownDto> returnList = new ArrayList<DropDownDto>();
		for(League league : League.values())
		{
			returnList.add(new DropDownDto(league.name(), (long)league.ordinal()));
		}
		return returnList;
	}
}
