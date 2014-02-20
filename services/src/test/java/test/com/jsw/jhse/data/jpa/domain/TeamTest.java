package test.com.jsw.jhse.data.jpa.domain;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.jsw.jhse.data.jpa.DbHibernateConfig;
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
		log.info("In tearDown(), removing created common objects and closing context.");
		context.close();
	}
	
	@Test
	public void testRetrieveTeam(){
		log.info("-------------------------------");
        log.info("testRetrieveTeam: starting");
		
	}
}
