package movie.ccc;

public class Clothing {
	
	String type; 
	String clothes; 
	
	public Clothing(String clothes, String type){
		this.clothes=clothes;
		this.type=type;
	}
	
	void info() {
		System.out.println(clothes + " : " + type);
	}

}
