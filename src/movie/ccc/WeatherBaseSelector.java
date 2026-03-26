package movie.ccc;

public class WeatherBaseSelector implements Outfit{
	 @Override
	    public Clothing[] selectOutfit(User user) {

	        if(user.gender.equals("남자")) {

	            if(user.temp <= 5) {
	                return new Clothing[] {
	                    new Clothing("아우터", "패딩"),
	                    new Clothing("상의", "니트"),
	                    new Clothing("하의", "기모바지"),
	                    new Clothing("신발", "부츠")
	                };
	            } else if(user.temp <= 15) {
	                return new Clothing[] {
	                    new Clothing("아우터", "자켓"),
	                    new Clothing("상의", "맨투맨"),
	                    new Clothing("하의", "청바지"),
	                    new Clothing("신발", "운동화")
	                };
	            } else if(user.temp <= 25) {
	                return new Clothing[] {
	                    new Clothing("상의", "반팔"),
	                    new Clothing("하의", "면바지"),
	                    new Clothing("신발", "스니커즈")
	                };
	            } else {
	                return new Clothing[] {
	                    new Clothing("상의", "민소매"),
	                    new Clothing("하의", "반바지"),
	                    new Clothing("신발", "샌들")
	                };
	            }

	        } else if(user.gender.equals("여자")) {

	            if(user.temp <= 5) {
	                return new Clothing[] {
	                    new Clothing("아우터", "롱코트"),
	                    new Clothing("상의", "니트"),
	                    new Clothing("하의", "기모치마 or 바지"),
	                    new Clothing("신발", "앵클부츠")
	                };
	            } else if(user.temp <= 15) {
	                return new Clothing[] {
	                    new Clothing("아우터", "가디건"),
	                    new Clothing("상의", "블라우스"),
	                    new Clothing("하의", "청바지 or 스커트"),
	                    new Clothing("신발", "로퍼")
	                };
	            } else if(user.temp <= 25) {
	                return new Clothing[] {
	                    new Clothing("상의", "반팔 블라우스"),
	                    new Clothing("하의", "스커트"),
	                    new Clothing("신발", "플랫슈즈")
	                };
	            } else {
	                return new Clothing[] {
	                    new Clothing("상의", "나시"),
	                    new Clothing("하의", "반바지 or 얇은 치마"),
	                    new Clothing("신발", "샌들")
	                };
	            }
	        }

	        return new Clothing[] {
	            new Clothing("오류", "성별 입력이 잘못되었습니다")
	        };
	    }
	}