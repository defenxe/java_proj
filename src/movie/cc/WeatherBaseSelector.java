package movie.cc;

import java.util.Scanner;

public class WeatherBaseSelector implements Selector{
	 

	 @Override
	 public void recommend() {
		Scanner sc = new Scanner(System.in);

		System.out.print("현재 온도 입력: ");
		int temp = sc.nextInt();

		System.out.println("\n[날씨 기반 추천]");


		if (temp <=5) {
		    System.out.println("아우터: 롱코트");
		    System.out.println("상의: 니트");
		    System.out.println("하의: 기모청바지");
		    System.out.println("하의: 패딩부츠");
		    } else if (temp <=15) {
		    	System.out.println("아우터: 가디건");
			    System.out.println("상의: 긴팔셔츠");
			    System.out.println("하의: 청바지");
			    System.out.println("하의: 로퍼");
		    } else if (temp <=25) {		    	
			    System.out.println("상의: 셔츠");
			    System.out.println("하의: 면바지");
			    System.out.println("하의: 스니커즈");
		    }else {
		    	System.out.println("상의: 반팔티셔츠");
			    System.out.println("하의: 반바지");
			    System.out.println("하의: 샌들");
		    }
		   
	 }
	}