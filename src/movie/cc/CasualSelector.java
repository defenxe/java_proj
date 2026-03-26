package movie.cc;

public class CasualSelector implements Outfit {

	public Clothing[] selectOutfit(User user) {
		return new Clothing[] {
				new Clothing("티셔츠","상의"),
				new Clothing("청바지","하의"),
				new Clothing("운동화","신발")
		};
	}

}