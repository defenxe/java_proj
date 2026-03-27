package movie.cc;

import java.util.ArrayList;
import java.util.List;

public class WeatherBaseSelector implements Outfit{
	
	private int temp;
	
	public WeatherBaseSelector(int temp) {
		this.temp=temp;
	}
	 

	 @Override
	 public List<String> recommend(String gender) {
		 
		List<String> list =new ArrayList<>();
		/*Scanner sc = new Scanner(System.in);

		System.out.print("현재 온도 입력: ");
		int temp = sc.nextInt();*/

		System.out.println("\n[날씨 기반 추천]");


		if (temp <=5) {
			if(gender.equals("남")) {
			list.add("아우터: 패딩");
			list.add("상의: 스웨터");
			list.add("하의: 기모청바지");
			list.add("신발: 패딩부츠");
			}if(gender.equals("여")) {
				list.add("아우터: 롱코트");
				list.add("상의: 니트");
				list.add("하의: 기모스커트");
				list.add("신발: 털부츠");
			}
		  } else if (temp <=15) {
		    if(gender.equals("남")) {
			  list.add("아우터: 재킷");
			  list.add("상의: 긴팔셔츠");
			  list.add("하의: 청바지");
			  list.add("신발: 운동화");
		    	} if(gender.equals("여")) {
		    		list.add("아우터: 가디건");
		    		list.add("상의: 얇은니트");
		    		list.add("하의: 면바지");
		    		list.add("신발: 로퍼");
				}
		   } else if (temp <=25) {
			   if(gender.equals("남")) {
			   list.add("상의: 셔츠");
			   list.add("하의: 면바지");
			   list.add("신발: 스니커즈");
			   } if(gender.equals("여")) {
				   list.add("상의: 긴팔티셔츠");
				   list.add("하의: 스커트");
				   list.add("신발: 슬립온");
			   }
		    }else {
		    	if(gender.equals("남")) {
		    	list.add("상의: 반팔티셔츠");
		    	list.add("하의: 반바지");
		    	list.add("신발: 크록스");
		    	}
		    	if(gender.equals("여")) {
		    		list.add("상의: 반팔티셔츠");
		    		list.add("하의: 반바지");
		    		list.add("신발: 샌들");
		    	}
		    	}
		return list;
		   
	 }

	}