package ProblemSet_4a;

import java.util.Arrays;

public class Day {
	private String name = "";
	private Session[] sessions = {};

	public Day(String name) {
		this.name = name;
		this.sessions = Arrays.copyOf(sessions, 7);
	}

	public void setSession(int index, String moduleName,
			int startTime, int endTime) {
		sessions[index] = new Session(moduleName,
				startTime, endTime);
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
			if (sessions[i] != null) {
				toReturn += sessions[i].getSessionName()
						+ ": "
						+ sessions[i].getStartTime()
						+ " - "
						+ sessions[i].getEndTime()
						+ "\n";
				}
			}
		return toReturn;
	}
}
