package ProblemSet_4a;

public class Session {
	private String sessionName;
	private int startTime;
	private int endTime;

	public Session(String sessionName, int startTime, int endTime) {
		super();
		this.sessionName = sessionName;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getSessionName() {
		return this.sessionName;
	}

	public int getStartTime() {
		return this.startTime;
	}

	public int getEndTime() {
		return this.endTime;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return String.format("%s: %d - %d\n",
				this.sessionName,
				this.startTime,
				this.endTime);
	}
}
