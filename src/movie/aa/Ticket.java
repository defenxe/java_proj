package movie.aa;

public class Ticket {

	private final String 좌석;
	private final String 제목;
	private final String 날짜;
	private final String 시간;
	private boolean isReserved;

	public Ticket(String 좌석, String 제목, String 날짜, String 시간) {
		this.좌석 = 좌석;
		this.제목 = 제목;
		this.날짜 = 날짜;
		this.시간 = 시간;
		this.isReserved = false;
	}

	public void setReserved(boolean reserved) {
		this.isReserved = reserved;
	}

	public String get좌석() {
		return 좌석;
	}

	public String get제목() {
		return 제목;
	}

	public String get날짜() {
		return 날짜;
	}

	public String get시간() {
		return 시간;
	}

	public boolean isReserved() {
		return isReserved;
	}

	@Override
	public String toString() {
		return "[좌석:" + 좌석 + "]";
	}
}
