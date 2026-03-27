package movie.cc;

import java.util.List;
import java.util.Scanner;

public class OutfitMain {
	
	public static void Outfit() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n== 영화관 예매 프로젝트 ==");
		System.out.println("\n== 오늘의 outfit 추천 ==\n");
		System.out.println("1. 날씨 2. 스타일");
		System.out.println("선택:");
		int choice = sc.nextInt();
		
		System.out.print("성별 입력(남/여) : ");
		String gender = sc.next();        
        
        Outfit selector = null;

        if (choice == 1) {
        	
        	System.out.print("온도입력(숫자로입력):");
        	int temp=sc.nextInt();
            selector = new WeatherBaseSelector(temp);
        } else if (choice == 2) {
        	
        	System.out.print("스타일입력(포멀/캐주얼): ");
        	String style=sc.next();
            selector = new StyleBaseSelector(style);
                }else {
            System.out.println("잘못된 선택입니다.");
            return;
        }
        //실행
        List<String> result = selector.recommend(gender);
        
       // System.out.println("\n[추천 코디]");
        for(String item : result) {
        	System.out.println(item);
        }
        
        
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
    
