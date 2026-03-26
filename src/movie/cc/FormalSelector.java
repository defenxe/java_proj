package movie.cc;

public class FormalSelector implements Outfit{

	public Clothing[] selectOutfit(User user) {
		return new Clothing[] {
				new Clothing("셔츠","상의"),
				new Clothing("슬랙스","하의"),
				new Clothing("구두","신발"),
		};
	}
}
