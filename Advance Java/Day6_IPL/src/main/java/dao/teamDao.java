package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Team;

public interface teamDao {
	//add a method to get team details
	List<Team> getSelectedDetails() throws SQLException;
}
