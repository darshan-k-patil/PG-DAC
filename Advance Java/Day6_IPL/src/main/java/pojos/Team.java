package pojos;

public class Team {
//id , name, abbrevation,owner,max_age,batting_avg,wickets_taken
	private int teamId;
	private String name;
	private String abbrevation;
	private String owner;
	private int maxAge;
	private double minBatting_avg;
	private int minWicketsTaken;
	public Team() {
		super();
	}
	public Team(int teamId, String abbrevation) {
		super();
		this.teamId = teamId;
		this.abbrevation = abbrevation;
	}

	public Team(int teamId, String name, String abbrevation, String owner, int maxAge, double minBatting_avg,
			int minWicketsTaken) {
		super();
		this.teamId = teamId;
		this.name = name;
		this.abbrevation = abbrevation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.minBatting_avg = minBatting_avg;
		this.minWicketsTaken = minWicketsTaken;
	}
	@Override
	public String toString() {
		return "Teams [teamId=" + teamId + ", name=" + name + ", abbrevation=" + abbrevation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", minBatting_avg=" + minBatting_avg + ", minWicketsTaken=" + minWicketsTaken
				+ "]";
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbrevation() {
		return abbrevation;
	}
	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public double getMinBatting_avg() {
		return minBatting_avg;
	}
	public void setMinBatting_avg(double minBatting_avg) {
		this.minBatting_avg = minBatting_avg;
	}
	public int getMinWicketsTaken() {
		return minWicketsTaken;
	}
	public void setMinWicketsTaken(int minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}
	
}
