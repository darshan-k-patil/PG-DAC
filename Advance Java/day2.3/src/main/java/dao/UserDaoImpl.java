package dao;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;

import static utils.DBUtils.*;

import pojos.User;

public class UserDaoImpl implements UserDao {
	// fields
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;

	public UserDaoImpl() throws SQLException {
		// open connection
		cn = openConnection();
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		pst2 = cn.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
		System.out.println("user dao created!");
	}

	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		// set IN params-
		pst1.setString(1, email);		
		pst1.setString(2, password);
		try(ResultSet rst=pst1.executeQuery()) {
			if(rst.next()) //=> success
				/*
				 * int id, String firstName, String lastName, String email, String password, Date dob,
			boolean votingStatus, String role
				 */
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), email, password, 
						rst.getDate(6), rst.getBoolean(7), rst.getString(8));
		}
		return null;
	}
	
	@Override
	public boolean authenticateNewUser(String firstName, String lastName, String email, String password, String dob) throws SQLException {
		Date d = Date.valueOf(dob);
		boolean status = false;
		String role = "voter";
		if(Period.between(LocalDate.parse(dob), LocalDate.now()).getYears()>21) 
		{
			pst2.setString(1, firstName);
			pst2.setString(2, lastName);
			pst2.setString(3, email);
			pst2.setString(4, password);
			pst2.setString(5, dob);
			pst2.setBoolean(6, status);
			pst2.setString(7, role);
			
			int rst1 = pst2.executeUpdate();
			if(rst1>0)
			{
				return true;
			}
		}
		
		return false;
	}


	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("user dao cleaned up!");
	}

}
