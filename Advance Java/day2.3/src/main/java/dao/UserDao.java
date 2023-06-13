package dao;

import java.sql.SQLException;

import pojos.User;

public interface UserDao {
//add a method for user authentication(login)
	User authenticateUser(String email, String password) throws SQLException;
	boolean authenticateNewUser(String firstName, String lastName, String email, String password, String dob) throws SQLException;
}
