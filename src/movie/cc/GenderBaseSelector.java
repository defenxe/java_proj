package movie.cc;

import java.util.Scanner;

public class GenderBaseSelector implements Outfit{

	@Override
	public void recommend() {
		Scanner sc = new Scanner(System.in);

        System.out.print("성별 입력 (남/여/관계없음): ");
        String gender = sc.next();

        System.out.println("\n[성별 기반 추천]");

        if (gender.equals("남")) {
        	System.out.println("상의: 셔츠");
            System.out.println("하의: 면바지");
            System.out.println("신발: 운동화");            
        } else if (gender.equals("여")) {
        	System.out.println("상의: 블라우스");
            System.out.println("하의: 스커트");
            System.out.println("신발: 로퍼");   
        } else {
        	System.out.println("상의: 맨투맨");
            System.out.println("하의: 청바지");
            System.out.println("신발: 스니커즈");  
        }
    }
	
}
