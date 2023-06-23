package dao;

import java.util.List;

import pojos.Team;

public interface TeamDao {
	//add  a method o lift id n abbreviation from all the teams
	List<Team> getAllTeams();
	
	String addNewTeam(Team t);
	
	Team getTeamDetails(long teamId);
}
