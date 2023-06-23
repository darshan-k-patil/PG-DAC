package beans;

import java.sql.SQLException;
import java.util.List;

import dao.*;
import pojos.Team;
public class IPLBean {
	//state : dependent : dao layer
	private TeamDaoImpl teamDao;
	//default Constructor
	public IPLBean() throws SQLException {
		//dao instance ----->will be called once
		teamDao = new TeamDaoImpl();
		System.out.println("IPL bean created...");
	}
	//getters and setters
	public TeamDaoImpl getTeamDao() {
		return teamDao;
	}
	public void setTeamDao(TeamDaoImpl teamDao) {
		this.teamDao = teamDao;
	}
	//add B.L method to return list of all teams to the caller(JSP)
	public List<Team> fetchAllTeams() throws SQLException  //for : getAllTeams() : use: ${applicationScope.ipl.allTeams}
	{
		//invoke dao's method
		return teamDao.getSelectedDetails();
	}
}
