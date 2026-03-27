package movie.cc;

import java.util.Scanner;

public class StyleBaseSelector implements Selector{

	@Override
	public void recommend() {
		 Scanner sc = new Scanner(System.in);

	        System.out.print("스타일 선택 (캐주얼/포멀): ");
	        String style = sc.next();

	        System.out.println("\n[스타일 기반 추천]");

	        if (style.equals("캐주얼")) {
	            System.out.println("상의: 후드티");
	            System.out.println("하의: 청바지");
	            System.out.println("신발: 스니커즈");
	        } else if (style.equals("포멀")) {
	            System.out.println("상의: 셔츠");
	            System.out.println("하의: 슬랙스");
	            System.out.println("신발: 구두");	            
	        } else {
	            System.out.println("기본 코디");
	        }
	    }
		
	}


