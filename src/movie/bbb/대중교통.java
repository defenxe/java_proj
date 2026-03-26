package movie.bbb;

public class 대중교통 extends 이동수단{

	public 대중교통(String 수단명) {
		super(수단명);
	}
	
	@Override
	public void 이동하다() {
		// TODO Auto-generated method stub
		super.이동하다();
		System.out.println( 수단명+"을 통해 이동한다.");
	}
	
	
	
}
