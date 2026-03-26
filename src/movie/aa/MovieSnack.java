package movie.aa;

import java.util.Scanner;

public class MovieSnack {

	public static int snack() {
		return snack(new Scanner(System.in));
	}

	public static int snack(Scanner sc) {
		String[] pop = {"오리지널팝콘", "어니언팝콘", "치즈팝콘"};
		String[] drink = {"콜라", "사이다", "레몬에이드"};
		String[] other = {"핫도그", "나초", "버터오징어"};

		int[] popPrice = {5000, 6000, 7000};
		int[] drinkPrice = {2000, 2000, 2500};
		int[] otherPrice = {3000, 4000, 5000};

		while (true) {
			int popCount = 0;
			int drinkCount = 0;
			int otherCount = 0;
			int popTotal = 0;
			int drinkTotal = 0;
			int otherTotal = 0;
			int timeSpent = 0;

			System.out.println("\n----------------- 팝콘 -----------------");
			printMenu(pop, popPrice);
			int popIndex = readMenuSelection(sc, pop.length + 1);
			if (popIndex != pop.length) {
				popCount = readPositiveCount(sc);
				popTotal = popPrice[popIndex] * popCount;
				timeSpent += popCount * 2;
				System.out.println("현재 선택 금액: " + popTotal + "원");
			}

			System.out.println("\n----------------- 음료 -----------------");
			printMenu(drink, drinkPrice);
			int drinkIndex = readMenuSelection(sc, drink.length + 1);
			if (drinkIndex != drink.length) {
				drinkCount = readPositiveCount(sc);
				drinkTotal = drinkPrice[drinkIndex] * drinkCount;
				timeSpent += drinkCount * 2;
				System.out.println("현재 선택 금액: " + (popTotal + drinkTotal) + "원");
			}

			System.out.println("\n----------------- 스낵 -----------------");
			printMenu(other, otherPrice);
			int otherIndex = readMenuSelection(sc, other.length + 1);
			if (otherIndex != other.length) {
				otherCount = readPositiveCount(sc);
				otherTotal = otherPrice[otherIndex] * otherCount;
				timeSpent += otherCount * 2;
			}

			int total = popTotal + drinkTotal + otherTotal;
			printSelectedMenu(pop, drink, other, popIndex, drinkIndex, otherIndex, popCount, drinkCount, otherCount, total);

			if (total == 0) {
				return timeSpent;
			}

			System.out.println("\n1. 영수증 출력  2. 선택 취소  3. 처음으로");
			int menu = readRange(sc, 1, 3);

			if (menu == 1) {
				영수증(pop, drink, other, popIndex, drinkIndex, otherIndex, popCount, drinkCount, otherCount, popTotal, drinkTotal, otherTotal);
				return timeSpent;
			}

			if (menu == 2) {
				int canceledTime = 취소처리(sc, pop, drink, other, popPrice, drinkPrice, otherPrice,
						popIndex, drinkIndex, otherIndex, popCount, drinkCount, otherCount,
						popTotal, drinkTotal, otherTotal);
				if (canceledTime >= 0) {
					return timeSpent - canceledTime;
				}
				continue;
			}
		}
	}

	private static int 취소처리(Scanner sc, String[] pop, String[] drink, String[] other,
			int[] popPrice, int[] drinkPrice, int[] otherPrice,
			int popIndex, int drinkIndex, int otherIndex,
			int popCount, int drinkCount, int otherCount,
			int popTotal, int drinkTotal, int otherTotal) {

		if (popCount > 0) {
			System.out.println("1. " + pop[popIndex] + " " + popCount + "개");
		}
		if (drinkCount > 0) {
			System.out.println("2. " + drink[drinkIndex] + " " + drinkCount + "개");
		}
		if (otherCount > 0) {
			System.out.println("3. " + other[otherIndex] + " " + otherCount + "개");
		}

		System.out.print("취소할 메뉴 번호 입력: ");
		int cancelMenu = readRange(sc, 1, 3);
		System.out.print("취소할 수량 입력: ");
		int cancelCount = readPositiveCount(sc);

		if (cancelMenu == 1 && cancelCount <= popCount) {
			popCount -= cancelCount;
			popTotal = popPrice[popIndex] * popCount;
		} else if (cancelMenu == 2 && cancelCount <= drinkCount) {
			drinkCount -= cancelCount;
			drinkTotal = drinkPrice[drinkIndex] * drinkCount;
		} else if (cancelMenu == 3 && cancelCount <= otherCount) {
			otherCount -= cancelCount;
			otherTotal = otherPrice[otherIndex] * otherCount;
		} else {
			System.out.println("취소할 수량이 올바르지 않습니다.");
			return -1;
		}

		StringBuilder canceledMenu = new StringBuilder("\n취소 후 메뉴: ");
		if (popCount > 0) {
			canceledMenu.append(pop[popIndex]).append(" ").append(popCount).append("개 ");
		}
		if (drinkCount > 0) {
			canceledMenu.append(drink[drinkIndex]).append(" ").append(drinkCount).append("개 ");
		}
		if (otherCount > 0) {
			canceledMenu.append(other[otherIndex]).append(" ").append(otherCount).append("개 ");
		}
		System.out.println(canceledMenu.toString().trim());
		System.out.println("취소 후 총 금액: " + (popTotal + drinkTotal + otherTotal) + "원");

		System.out.println("\n1. 영수증 출력  2. 처음으로");
		int menu = readRange(sc, 1, 2);
		if (menu == 1) {
			영수증(pop, drink, other, popIndex, drinkIndex, otherIndex, popCount, drinkCount, otherCount, popTotal, drinkTotal, otherTotal);
			return cancelCount * 2;
		}

		return -1;
	}

	private static void printMenu(String[] names, int[] prices) {
		for (int i = 0; i < names.length; i++) {
			System.out.println((i + 1) + ". " + names[i] + " - " + prices[i] + "원");
		}
		System.out.println((names.length + 1) + ". 건너뛰기");
		System.out.print(": ");
	}

	private static int readMenuSelection(Scanner sc, int maxMenuNumber) {
		return readRange(sc, 1, maxMenuNumber) - 1;
	}

	private static int readPositiveCount(Scanner sc) {
		while (true) {
			System.out.print("개수를 입력하세요: ");
			int count = readInt(sc);
			if (count > 0) {
				return count;
			}
			System.out.println("1개 이상 입력하세요.");
		}
	}

	private static int readRange(Scanner sc, int min, int max) {
		while (true) {
			int value = readInt(sc);
			if (value >= min && value <= max) {
				return value;
			}
			System.out.println(min + "부터 " + max + " 사이의 숫자를 입력하세요.");
			System.out.print(": ");
		}
	}

	private static int readInt(Scanner sc) {
		while (!sc.hasNextInt()) {
			System.out.println("숫자만 입력하세요.");
			sc.next();
			System.out.print(": ");
		}
		return sc.nextInt();
	}

	private static void printSelectedMenu(String[] pop, String[] drink, String[] other,
			int popIndex, int drinkIndex, int otherIndex,
			int popCount, int drinkCount, int otherCount, int total) {

		StringBuilder selectedMenu = new StringBuilder("\n선택 메뉴: ");
		if (popCount > 0) {
			selectedMenu.append(pop[popIndex]).append(" ").append(popCount).append("개 ");
		}
		if (drinkCount > 0) {
			selectedMenu.append(drink[drinkIndex]).append(" ").append(drinkCount).append("개 ");
		}
		if (otherCount > 0) {
			selectedMenu.append(other[otherIndex]).append(" ").append(otherCount).append("개 ");
		}

		System.out.println(selectedMenu.toString().trim());
		System.out.println("총 금액: " + total + "원");
	}

	public static void 영수증(String[] pop, String[] drink, String[] other,
			int popIndex, int drinkIndex, int otherIndex,
			int popCount, int drinkCount, int otherCount,
			int popTotal, int drinkTotal, int otherTotal) {

		int total = popTotal + drinkTotal + otherTotal;

		System.out.println("\n========== 영수증 ==========");
		if (popCount > 0) {
			System.out.println(pop[popIndex] + " " + popCount + "개 " + popTotal + "원");
		}
		if (drinkCount > 0) {
			System.out.println(drink[drinkIndex] + " " + drinkCount + "개 " + drinkTotal + "원");
		}
		if (otherCount > 0) {
			System.out.println(other[otherIndex] + " " + otherCount + "개 " + otherTotal + "원");
		}
		System.out.println("----------------------------");
		System.out.println("총 금액: " + total + "원");
		System.out.println("============================");
	}

	public static void main(String[] args) {
		snack();
	}
}
