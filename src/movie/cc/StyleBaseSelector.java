package movie.cc;

import java.util.ArrayList;
import java.util.List;

public class StyleBaseSelector implements Outfit{
	
	private String style;
	
	public StyleBaseSelector(String style) {
		this.style=style;
	}

	@Override
	public List<String> recommend(String gender) {
		
		List<String> list = new ArrayList<>();
		// Scanner sc = new Scanner(System.in);
/*
	        System.out.print("스타일 선택 (캐주얼/포멀): ");
	        String style = sc.next();
*/
	        System.out.println("\n[스타일 기반 추천]");

	        if (style.equals("캐주얼")) {
	        	list.add("상의: 후드티");
	        	list.add("하의: 청바지");
	        	list.add("신발: 스니커즈");
	        } else if (style.equals("포멀")) {
	        	list.add("상의: 셔츠");
	        	list.add("하의: 슬랙스");
	        	list.add("신발: 구두");	            
	        } else {
	        	list.add("기본 코디");
	        }
	        
	        if(gender.equals("여")) {
	        	list.add("기타: 가방");
	        }else {
	        	list.add("기타: 시계");
	        }
	        return list;
	    }
		
	}


