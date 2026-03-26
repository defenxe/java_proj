package movie.cc;

import java.util.Scanner;

public class OutfitMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//사용자 정보입력
		System.out.print("성별을 입력하세요 (Male/Female): ");
        String gender = sc.next();
        
        System.out.print("현재 온도를 입력하세요: ");
        int temp = sc.nextInt();
		
		User user = new User(gender, temp); 
		
		//메뉴선택
		System.out.println("의상을 고르세요. 1. 캐쥬얼, 2. 포멀, 3. 날씨에 따른 의상");
		int choice= sc.nextInt();
		
		
		Outfit selector;
		
		if(choice ==1) {
			selector = new CasualSelector();
		}else if(choice ==2) {
			selector = new FormalSelector();
		}else if(choice ==3) {
			selector = new WeatherBaseSelector();
		}else {
			System.out.println("잘못된 입력입니다");
			return;
		}
		
		Clothing[] outfit = selector.selectOutfit(user);
		
		for(Clothing c : outfit) {
            System.out.println(c.type + " - " + c.customer);
		

	}

}


}