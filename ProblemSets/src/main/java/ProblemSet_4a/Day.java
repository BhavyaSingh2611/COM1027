package ProblemSet_4a;

public class Day {
	private String name;
	private Session[] sessions;
	
	public Day(String name) {
		this.name = name;
	}
	
	public void setSession(int index, String moduleName, int startTime, int endTime) {
		sessions[index] = new Session(moduleName, endTime, endTime);
	}
	
	public String getName() {
		return name;
	}

	public Session getSessions(int i) {
		return sessions[i];
	}
	
}
