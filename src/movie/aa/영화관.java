package movie.aa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 영화관 {

	private static final int 운영일수 = 30;
	private static final int 지각기준분 = 12;
	private static final String[] 고정상영시간표 = {"08:00", "12:00", "16:00", "18:00", "21:00", "23:00"};

	private final Scanner sc = new Scanner(System.in);
	private final List<String> movieName = Arrays.asList("아바타", "타이타닉");
	private final Map<String, Map<String, List<상영일정>>> 상영일정맵 = new LinkedHashMap<>();
	private final List<상영일정> 전체상영일정목록 = new ArrayList<>();

	public 영화관() {
		상영일정초기화();
	}

	private void 상영일정초기화() {
		for (String 영화제목 : movieName) {
			Map<String, List<상영일정>> 날짜별상영일정 = new LinkedHashMap<>();

			for (int day = 1; day <= 운영일수; day++) {
				String 날짜 = day + "일";
				List<상영일정> 시간별상영일정 = new ArrayList<>();

				for (String 상영시간 : 고정상영시간표) {
					상영일정 screening = new 상영일정(영화제목, 날짜, 상영시간);
					시간별상영일정.add(screening);
					전체상영일정목록.add(screening);
				}

				날짜별상영일정.put(날짜, 시간별상영일정);
			}

			상영일정맵.put(영화제목, 날짜별상영일정);
		}
	}

	public void input() {
		while (true) {
			String 영화제목 = 영화선택();
			String 날짜 = 날짜선택(영화제목);
			상영일정 screening = 시간선택(영화제목, 날짜);

			좌석현황출력(screening);
			Ticket reservedTicket = 좌석선택및예매(screening);

			System.out.println();
			System.out.println("예매가 완료되었습니다.");
			System.out.println("영화: " + reservedTicket.get제목());
			System.out.println("날짜: " + reservedTicket.get날짜());
			System.out.println("시간: " + reservedTicket.get시간());
			System.out.println("좌석: " + reservedTicket.get좌석());

			int timeSpent = goToBuySnack();
			if (timeSpent > 지각기준분) {
				System.out.println("스낵 구매로 " + timeSpent + "분이 소요되어 지각했지만, 이미 확정된 좌석 예매는 유지됩니다.");
			} else {
				System.out.println("스낵 구매 후 " + timeSpent + "분 만에 입장했습니다. 예매된 좌석으로 바로 착석하면 됩니다.");
			}

			if (!계속진행여부()) {
				break;
			}
		}
	}

	private String 영화선택() {
		System.out.println();
		System.out.println("=== 영화 선택 ===");
		for (int i = 0; i < movieName.size(); i++) {
			System.out.println((i + 1) + ". " + movieName.get(i));
		}

		int selectedIndex = readInt("영화를 선택하세요: ", 1, movieName.size());
		return movieName.get(selectedIndex - 1);
	}

	private String 날짜선택(String 영화제목) {
		List<String> 날짜목록 = new ArrayList<>(상영일정맵.get(영화제목).keySet());

		System.out.println();
		System.out.println("=== 날짜 선택 ===");
		for (int i = 0; i < 날짜목록.size(); i++) {
			System.out.printf("%2d. %-4s", i + 1, 날짜목록.get(i));
			if ((i + 1) % 5 == 0 || i == 날짜목록.size() - 1) {
				System.out.println();
			}
		}

		int selectedIndex = readInt("날짜를 선택하세요: ", 1, 날짜목록.size());
		return 날짜목록.get(selectedIndex - 1);
	}

	private 상영일정 시간선택(String 영화제목, String 날짜) {
		List<상영일정> 시간별상영일정 = 상영일정맵.get(영화제목).get(날짜);

		while (true) {
			System.out.println();
			System.out.println("=== 시간 선택 ===");
			for (int i = 0; i < 시간별상영일정.size(); i++) {
				상영일정 screening = 시간별상영일정.get(i);
				String 상태 = screening.get잔여좌석수() == 0 ? "매진" : "잔여 " + screening.get잔여좌석수() + "석";
				System.out.println((i + 1) + ". " + screening.get상영시간() + " (" + 상태 + ")");
			}

			int selectedIndex = readInt("상영 시간을 선택하세요: ", 1, 시간별상영일정.size());
			상영일정 selectedScreening = 시간별상영일정.get(selectedIndex - 1);

			if (selectedScreening.get잔여좌석수() == 0) {
				System.out.println("선택한 회차는 매진입니다. 다른 시간을 선택하세요.");
				continue;
			}

			return selectedScreening;
		}
	}

	private void 좌석현황출력(상영일정 screening) {
		System.out.println();
		System.out.println("=== 잔여 좌석 확인 ===");
		System.out.println("영화: " + screening.get영화제목() + " / 날짜: " + screening.get날짜() + " / 시간: " + screening.get상영시간());
		System.out.println("잔여 좌석: " + screening.get잔여좌석수() + " / " + screening.get총좌석수());
		System.out.println("[O] 예매 가능 / [X] 예매 완료");

		Ticket[][] seats = screening.get좌석정보();
		for (Ticket[] row : seats) {
			for (Ticket ticket : row) {
				String 상태 = ticket.isReserved() ? "[X]" : "[O]";
				System.out.print(ticket.get좌석() + 상태 + " ");
			}
			System.out.println();
		}
	}

	private Ticket 좌석선택및예매(상영일정 screening) {
		while (true) {
			System.out.print("좌석을 선택하세요. ex) 2-3 : ");
			String input = readNonEmptyLine();
			String[] rowColumn = input.split("-");

			if (rowColumn.length != 2) {
				System.out.println("좌석 형식이 올바르지 않습니다. 예: 1-2");
				continue;
			}

			try {
				int row = Integer.parseInt(rowColumn[0].trim()) - 1;
				int column = Integer.parseInt(rowColumn[1].trim()) - 1;

				if (!screening.is유효좌석(row, column)) {
					System.out.println("좌석 범위를 벗어났습니다. 1~3 사이의 행과 열을 선택하세요.");
					continue;
				}

				if (!screening.is좌석예매가능(row, column)) {
					System.out.println("이미 예매된 좌석입니다. 다른 좌석을 선택하세요.");
					continue;
				}

				return screening.reserveSeat(row, column);
			} catch (NumberFormatException e) {
				System.out.println("좌석 형식이 올바르지 않습니다. 숫자-숫자 형식으로 입력하세요.");
			}
		}
	}

	public void print() {
		boolean hasReservation = false;

		System.out.println();
		System.out.println("=== 예매 내역 ===");
		for (상영일정 screening : 전체상영일정목록) {
			if (!screening.hasReservation()) {
				continue;
			}

			hasReservation = true;
			System.out.println(screening.get영화제목() + " / " + screening.get날짜() + " / " + screening.get상영시간());
			System.out.println("예매 좌석: " + String.join(", ", screening.get예매좌석목록()));
			System.out.println("잔여 좌석: " + screening.get잔여좌석수() + " / " + screening.get총좌석수());
			System.out.println();
		}

		if (!hasReservation) {
			System.out.println("현재 예매된 좌석이 없습니다.");
		}
	}

	public int goToBuySnack() {
		return MovieSnack.snack(sc);
	}

	public List<상영일정> get상영일정목록() {
		return new ArrayList<>(전체상영일정목록);
	}

	private boolean 계속진행여부() {
		while (true) {
			System.out.print("계속 예매하시겠습니까? (Yes/No): ");
			String answer = readNonEmptyLine();

			if (answer.equalsIgnoreCase("yes")) {
				return true;
			}

			if (answer.equalsIgnoreCase("no")) {
				return false;
			}

			System.out.println("Yes 또는 No로 입력하세요.");
		}
	}

	private int readInt(String prompt, int min, int max) {
		while (true) {
			System.out.print(prompt);
			String input = readNonEmptyLine();

			try {
				int value = Integer.parseInt(input);
				if (value < min || value > max) {
					System.out.println(min + "부터 " + max + " 사이의 숫자를 입력하세요.");
					continue;
				}
				return value;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			}
		}
	}

	private String readNonEmptyLine() {
		while (true) {
			String input = sc.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			}
		}
	}
	
	
	public Ticket[][][] getTicket() {
	    int 회차수 = 전체상영일정목록.size();
	    
	    Ticket[][][] 전체좌석 = new Ticket[회차수][][];

	    for (int i = 0; i < 회차수; i++) {
	        전체좌석[i] = 전체상영일정목록.get(i).get좌석정보();
	    }

	    return 전체좌석;
	}
}
