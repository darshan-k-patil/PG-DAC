package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pojos.Player;
import pojos.Team;
import utils.HibernateUtils;

class TestTeamDao {
	private static TeamDao dao;
	private static PlayerDao dao1;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//build SF n create DAO instance
		HibernateUtils.getFactory();//triggers creation of SF
		dao=new TeamDaoImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		HibernateUtils.getFactory().close();
	}

	@Test
	void test() {
		//create team instance : hard coded details
		Team newTeam = new Team("Kolkata Knight Riders", "KKR", "Sham", 20, 35, 15);
		//invoke dao's method
		String mesg = dao.addNewTeam(newTeam);
		System.out.println(mesg);
		//assert : if id = 1
		assertEquals(4, newTeam.getId());
	}
	
	@Test
	void testGetAllTeams() {
		List<Team> teams = dao.getAllTeams();
		teams.forEach(t -> System.out.println(t.getId()+" "+t.getAbbreviation()));
		assertEquals(4, teams.size());
	}
	
	@Test
	void testAddPlayer() {
		//String firstName, String lastName, LocalDate dob, double battingAvg, int wicketsTaken, Team myTeam
		Player newPlayer = new Player("darsh@gmail.com","darshan", "patil", LocalDate.parse("2001-01-03"), 40, 5);
		String mesg = dao1.addPlayerToTeam(newPlayer, 1);
		assertEquals(1, newPlayer.getId());
	}
	
	@Test
	void testShowTeam() {
		//System.out.println(dao.getTeamDetails(2));
		
	}

}
