package pojos;

/*
 * id , name, abbreviation,owner,max_age,batting_avg,wickets_taken	
# table
 */
public class Team {
	private int teamId;
	private String name;
	private String abbreviation;
	private String owner;
	private int maxAge;
	private double minBattingAvg;
	private int minWicketsTaken;
	public Team() {
		// TODO Auto-generated constructor stub
	}
	
	public Team(int teamId, String abbreviation) {
		super();
		this.teamId = teamId;
		this.abbreviation = abbreviation;
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
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
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
	public double getMinBattingAvg() {
		return minBattingAvg;
	}
	public void setMinBattingAvg(double minBattingAvg) {
		this.minBattingAvg = minBattingAvg;
	}
	public int getMinWicketsTaken() {
		return minWicketsTaken;
	}
	public void setMinWicketsTaken(int minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", minBattingAvg=" + minBattingAvg + ", minWicketsTaken=" + minWicketsTaken
				+ "]";
	}
	
}
