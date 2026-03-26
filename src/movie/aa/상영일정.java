package movie.aa;

import java.util.ArrayList;
import java.util.List;

public class 상영일정 {

	public static final int 좌석행수 = 3;
	public static final int 좌석열수 = 3;

	private final String 영화제목;
	private final String 날짜;
	private final String 상영시간;
	private final Ticket[][] 좌석정보;

	public 상영일정(String 영화제목, String 날짜, String 상영시간) {
		this.영화제목 = 영화제목;
		this.날짜 = 날짜;
		this.상영시간 = 상영시간;
		this.좌석정보 = new Ticket[좌석행수][좌석열수];
		좌석초기화();
	}

	private void 좌석초기화() {
		for (int row = 0; row < 좌석행수; row++) {
			for (int column = 0; column < 좌석열수; column++) {
				String 좌석명 = (row + 1) + "-" + (column + 1);
				좌석정보[row][column] = new Ticket(좌석명, 영화제목, 날짜, 상영시간);
			}
		}
	}

	public boolean is유효좌석(int row, int column) {
		return row >= 0 && row < 좌석행수 && column >= 0 && column < 좌석열수;
	}

	public boolean is좌석예매가능(int row, int column) {
		return is유효좌석(row, column) && !좌석정보[row][column].isReserved();
	}

	public Ticket reserveSeat(int row, int column) {
		if (!is좌석예매가능(row, column)) {
			return null;
		}

		Ticket ticket = 좌석정보[row][column];
		ticket.setReserved(true);
		return ticket;
	}

	public int get총좌석수() {
		return 좌석행수 * 좌석열수;
	}

	public int get잔여좌석수() {
		int remainSeatCount = 0;

		for (Ticket[] row : 좌석정보) {
			for (Ticket ticket : row) {
				if (!ticket.isReserved()) {
					remainSeatCount++;
				}
			}
		}

		return remainSeatCount;
	}

	public List<String> get예매좌석목록() {
		List<String> reservedSeats = new ArrayList<>();

		for (Ticket[] row : 좌석정보) {
			for (Ticket ticket : row) {
				if (ticket.isReserved()) {
					reservedSeats.add(ticket.get좌석());
				}
			}
		}

		return reservedSeats;
	}

	public boolean hasReservation() {
		return get잔여좌석수() < get총좌석수();
	}

	public String get영화제목() {
		return 영화제목;
	}

	public String get날짜() {
		return 날짜;
	}

	public String get상영시간() {
		return 상영시간;
	}

	public Ticket[][] get좌석정보() {
		return 좌석정보;
	}
}
