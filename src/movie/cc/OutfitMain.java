package movie.cc;

import java.util.Scanner;

public class OutfitMain {
	
	public static void Outfit() {
		Scanner sc = new Scanner(System.in);

        System.out.print("성별 입력(남자/여자) : ");
        String gender = sc.next();

        System.out.print("현재 온도 입력 : ");
        int temp = sc.nextInt();

        User user = new User(gender, temp);

        OutfitService service = new OutfitService();
        service.setSelector(new WeatherBaseSelector());
        service.recommend(user);

        //sc.close();
	}
	
	
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
    
}