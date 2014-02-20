package test.com.jsw.jhse.data.jpa.domain;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.jsw.jhse.data.AppConstants.League;
import com.jsw.jhse.data.jpa.DbHibernateConfig;
import com.jsw.jhse.data.jpa.domain.City;
import com.jsw.jhse.data.jpa.domain.Player;
import com.jsw.jhse.data.jpa.domain.Team;
import com.jsw.jhse.data.services.TeamService;

@RunWith(JUnit4.class)
public class TeamTest {
	
	//Spring context
    private static AbstractApplicationContext context;
    //services
    private static TeamService teamService;

	protected final static Logger log = LoggerFactory
			.getLogger(TeamTest.class);
	
	@BeforeClass
	public static void setup() {
		log.info("In setup(), creating context and retrieving Services from context.");
		context = new AnnotationConfigApplicationContext(
                DbHibernateConfig.class);
		teamService = context.getBean(TeamService.class);
	}
	
	@AfterClass
	public static void tearDown(){
		log.info("-------------------------------");
		log.info("In tearDown(), removing created common objects and closing context.");
		context.close();
	}
	
	@Test
	public void testGetAllTeams(){
		log.info("-------------------------------");
        log.info("testGetAllTeams: starting");
        List<Team> teams = teamService.getAllTeams();
        log.info(("Retrieved " + teams.size() + " teams."));
        for(Team team : teams)
        {
        	log.info("    " + team.getCity().getName() + " " + team.getName() + " " + team.getLeague().name());
        	log.info("    Players:");
        	for(Player player : team.getPlayers())
        	{
        		log.info("        " + player.getFirstName() + " " + player.getLastName());
        	}
        }
        log.info("testGetAllTeams: complete");	
	}
	
	@Test
	public void testGetAllTeamsByLeague()
	{
		log.info("-------------------------------");
        log.info("testGetAllTeamsByLeague: starting");
        League league = League.NBA;
        List<Team> teams = teamService.getAllTeamsByLeague(league);
        log.info("Found " + teams.size() + " teams for the " + league.name());
        for(Team team : teams)
        {
        	log.info("    " + team.getCity().getName() + " " + team.getName());
        }
        log.info("testGetAllTeamsByLeague: complete");
	}
	
	@Test
	public void testGetAllTeamsByCity()
	{
		log.info("-------------------------------");
        log.info("testGetAllTeamsByCity: starting");
        City city = teamService.getAllCities().get(0);
        List<Team> teams = teamService.getAllTeamsByCity(city);
        log.info("Found " + teams.size() + " teams for the city of " + city.getName());
        for(Team team : teams)
        {
        	log.info("    " + team.getName());
        }
        log.info("testGetAllTeamsByCity: complete");
	}
}
