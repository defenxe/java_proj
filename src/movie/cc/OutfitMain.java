package movie.cc;

import java.util.Scanner;

public class OutfitMain {
	
	public static void Outfit() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n== 영화관 예매 프로젝트 ==");
		System.out.println("\n== 오늘의 outfit 추천 ==\n");
		System.out.println("1. 날씨 2. 성별 3. 스타일");
		System.out.println("선택:");
		//System.out.print("성별 입력(남자/여자) : ");
        int choice = sc.nextInt();
        
        Outfit selector = null;

        if (choice == 1) {
            selector = new WeatherBaseSelector();
        } else if (choice == 2) {
            selector = new GenderBaseSelector();
        } else if (choice == 3) {
        	selector = new StyleBaseSelector();    	
        }else {
            System.out.println("잘못된 선택입니다.");
            return;
        }
        
        selector.recommend();
    }
	
}	
/*		
        String gender = sc.next();

        System.out.print("현재 온도 입력 : ");
        int temp = sc.nextInt();

        User user = new User(gender, temp);

        OutfitService service = new OutfitService();
        service.setSelector(new WeatherBaseSelector());
        service.recommend(user);
*/
        //sc.close();

	
	
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("성별 입력(남자/여자) : ");
//        String gender = sc.next();
//
//        System.out.print("현재 온도 입력 : ");
//        int temp = sc.nextInt();
//
//        User user = new User(gender, temp);
//
//        OutfitService service = new OutfitService();
//        service.setSelector(new WeatherBaseSelector());
//        service.recommend(user);
//
//        sc.close();
//    }
    
