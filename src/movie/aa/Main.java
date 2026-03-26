package movie.aa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 
public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		
		영화관 movie = new 영화관();
		
		
		
		//영화제목 a = new 예매표();
		
		//List<ticketInfo> myTickets = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
            System.out.println("\n=== 영화 예매 시스템 메인 메뉴 ===");
            System.out.println("1. 영화 예매하기");
            System.out.println("2. 예매 내역 확인");
            System.out.println("3. 티켓 출력하기");
            System.out.println("4. 프로그램 종료");
            System.out.print("메뉴를 선택해주세요: ");

            int choice = sc.nextInt();

            if (choice == 1) {
            
            	movie.input();
            	
//                ticketInfo newTicket = a.selectMovie();
//                myTickets.add(newTicket);
//                
//                System.out.println("\n=== 예매가 성공적으로 완료되었습니다 ===");
//                System.out.println("영화 제목: " + newTicket.제목);
//                System.out.println("예매 좌석: " + (newTicket.열 + 1) + "열 " + (newTicket.좌석번호 + 1) + "번");
                
            } else if (choice == 2) {
            	
            	movie.print();
                
//                System.out.println("\n=== 나의 예매 내역 ===");
//                if (myTickets.isEmpty()) {
//                    System.out.println("현재 예매된 내역이 없습니다.");
//                } else {
//                    for (int i = 0; i < myTickets.size(); i++) {
//                        ticketInfo t = myTickets.get(i);
//                        System.out.println((i + 1) + ". " + t.제목 + " / " + (t.열 + 1) + "열 " + (t.좌석번호 + 1) + "번");
//                    }
//                }
                
            } else if (choice == 3) {
                 fileWrite fw = new fileWrite(movie.getTicket());
                 fw.findExistSeat();
                 fw.writeTicket();
                
            } else if (choice == 4) {
            	System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 1~3 사이의 숫자를 입력해주세요.");
            }
        }
        
        sc.close();
    }
}