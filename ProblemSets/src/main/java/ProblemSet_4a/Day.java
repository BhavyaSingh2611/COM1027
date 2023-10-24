package ProblemSet_4a;

public class Day {
	private String name = null;
	private Session[] sessions = null;

	public Day(String name) {
		super();
		this.name = name;
		this.sessions = new Session[4];
	}

	public void setSession(int index, String moduleName,
			int startTime, int endTime) {
		this.sessions[index] = new Session(moduleName,
				startTime, endTime);
	}

	public String getName() {
		return this.name;
	}

	public Session getSessions(int i) {
		return this.sessions[i];
	}

	public void display() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		String toReturn = "";
        for (Session session : this.sessions) {
            if (session != null) {
				toReturn += session.toString();
            }
        }
		return toReturn;
	}
}
