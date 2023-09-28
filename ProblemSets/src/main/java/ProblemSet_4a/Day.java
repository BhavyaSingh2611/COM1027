package ProblemSet_4a;

public class Day {
	private String name = "";
	private Session[] sessions = {null, null, null, null, null , null, null};
	
	public Day(String name) {
		this.name = name;
	}
	
	public void setSession(int index, String moduleName, int startTime, int endTime) {
		sessions[index] = new Session(moduleName, startTime, endTime);
	}
	
	public String getName() {
		return name;
	}

	public Session getSessions(int i) {
		return sessions[i];
	}
	
	public String toString() {
		String toReturn = "";
		for (int i = 0; i < sessions.length; i++) {
			if(sessions[i] != null) {
				toReturn += sessions[i].getSessionName() + ": " + sessions[i].getStartTime() + " - " + sessions[i].getEndTime() + "\n";
			}
		}
		
		return toReturn;
	}
	
}
