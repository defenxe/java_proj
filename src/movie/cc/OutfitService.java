package movie.cc;

public class OutfitService {
    Outfit selector;

    void setSelector(Outfit selector) {
        this.selector = selector;
    }

    void recommend(User user) {
        Clothing[] outfit = selector.selectOutfit(user);

        System.out.println("\n=== 추천 코디 ===");
        for(int i = 0; i < outfit.length; i++) {
            outfit[i].info();
        }
    }
}
