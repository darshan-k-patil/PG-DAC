package pojos;

import java.sql.Date;

public class Player {
//id , first_name,last_name, dob,batting_avg,wickets_taken....
	private int playerId;//PK
	private String firstName;
	private String lastName;
	private Date dob;
	private double battingAverage;
	private int wicketsTaken;
	//FK
	private int teamId;
	public Player() {
		super();
	}
	public Player(int playerId, String firstName, String lastName, Date dob, double battingAverage, int wicketsTaken,
			int teamId) {
		super();
		this.playerId = playerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAverage = battingAverage;
		this.wicketsTaken = wicketsTaken;
		this.teamId = teamId;
	}
	@Override
	public String toString() {
		return "Players [playerId=" + playerId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", battingAverage=" + battingAverage + ", wicketsTaken=" + wicketsTaken + ", teamId=" + teamId + "]";
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public double getBattingAverage() {
		return battingAverage;
	}
	public void setBattingAverage(double battingAverage) {
		this.battingAverage = battingAverage;
	}
	public int getWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	
}
