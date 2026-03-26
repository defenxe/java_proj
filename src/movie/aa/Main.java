package movie.aa;

import java.io.IOException;
import java.util.Scanner;

import movie.bbb.이동테스트;
import movie.cc.OutfitMain;

 
public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		
		//옷입기 클래스 실행
		OutfitMain.Outfit();
		
		//이동 클래스 실행
		이동테스트.moveMain();
		
		
		
		//영화관 클래스 시작
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
            	
                
            } else if (choice == 2) {
            	
            	movie.print();
                
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