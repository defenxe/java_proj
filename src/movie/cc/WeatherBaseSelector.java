package movie.cc;

public class WeatherBaseSelector implements Outfit{

	public Clothing[] selectOutfit(User user) {
		
		if(user.temp <= 5) {
			return new Clothing[] {
	                new Clothing("패딩", "상의"),
	                new Clothing("기모팬츠", "하의"),
	                new Clothing("부츠", "신발")
	            };
	        } else if(user.temp <= 20) {
	            return new Clothing[] {
	                new Clothing("니트", "상의"),
	                new Clothing("청바지", "하의"),
	                new Clothing("운동화", "신발")
	            };
	        } else {
	            return new Clothing[] {
	                new Clothing("반팔", "상의"),
	                new Clothing("반바지", "하의"),
	                new Clothing("샌들", "신발")
	        };
	    }
	}
}

