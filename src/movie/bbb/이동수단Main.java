package movie.bbb;

import java.util.Scanner;

public class 이동수단Main {
	
	public static void moveMain() {
		
		Scanner sc = new Scanner(System.in);
        
        이동수단 transport = null; 
        
        System.out.println("\n == 이동수단 ==");
        
        while (true) {
            System.out.println("\n영화관으로 이동할 수단을 선택하세요.");
            System.out.println("1. 택시  2. 대중교통  3. 도보  0. 선택하지 않음");
            System.out.print("선택: ");
            
           
            if (!sc.hasNextInt()) {
                System.out.println("숫자만 입력 가능합니다.");
                sc.next(); 
                continue;
            }
            
            int choice = sc.nextInt();
            
            if (choice == 0) {
                System.out.println("이동수단을 선택하지 않습니다.");
                break;
            } else if (choice == 1) {
                transport = new 택시("택시"); 
            } else if (choice == 2) {
                transport = new 대중교통("대중교통");
            } else if (choice == 3) {
                transport = new 도보("도보");
            } else {
                System.out.println("잘못된 입력입니다. 1~3 사이의 숫자를 입력해주세요.");
                continue;
            }
            
            if (transport != null) {
                System.out.print("이동 결과: ");
               
                transport.이동하다();
                
                //이동수단에서 영화관 class로 넘어가게 하기 위해 추가
                break;
            }
        }
        
        //sc.close();
		
	}
	
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        
//        이동수단 transport = null; 
//        
//        System.out.println("=== 이동수단 다형성 검증 테스트 ===");
//        
//        while (true) {
//            System.out.println("\n영화관으로 이동할 수단을 선택하세요.");
//            System.out.println("1. 택시  2. 대중교통  3. 도보  0. 테스트 종료");
//            System.out.print("선택: ");
//            
//           
//            if (!sc.hasNextInt()) {
//                System.out.println("숫자만 입력 가능합니다.");
//                sc.next(); 
//                continue;
//            }
//            
//            int choice = sc.nextInt();
//            
//            if (choice == 0) {
//                System.out.println("테스트를 종료합니다.");
//                break;
//            } else if (choice == 1) {
//                transport = new 택시("택시"); 
//            } else if (choice == 2) {
//                transport = new 대중교통("대중교통");
//            } else if (choice == 3) {
//                transport = new 도보("도보");
//            } else {
//                System.out.println("잘못된 입력입니다. 1~3 사이의 숫자를 입력해주세요.");
//                continue;
//            }
//            
//            if (transport != null) {
//                System.out.print("이동 결과: ");
//               
//                transport.이동하다(); 
//            }
//        }
//        
//        sc.close();
//    }
}