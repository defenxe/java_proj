package movie.bbb;

public class 도보 extends 이동수단{
	
	public 도보(String 수단명) {
		super(수단명);
	}

	@Override
	public void 이동하다() {
		// TODO Auto-generated method stub
		super.이동하다();
		System.out.println("걸어서 이동한다.");
	}
}
