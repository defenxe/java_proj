package movie.aa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class fileWrite {

	Ticket[][][] theater;
	ArrayList<Ticket> existSeat = new ArrayList<>();
	
	//영화관 class의 theater를 받아오기
	public fileWrite(Ticket[][][] theater) {
		this.theater = theater;
	}
	
	//티켓들을 txt 파일로 생성
	public void writeTicket() throws IOException {
		
		FileWriter fw;
		PrintWriter pw;
		
		for(int i=0; i<this.existSeat.size(); i++) {
			Ticket ticket = this.existSeat.get(i);
			String fileName = String.format("tickets/ticket%02d.txt", i+1);
			File file = new File(fileName);
			
			if(!file.exists()) {
				file.createNewFile();
			}
			
			fw = new FileWriter(file);
			pw = new PrintWriter(fw);
			
			
			pw.println("-------------------------");
			pw.println("좌석번호: "+ticket.get좌석());
			pw.println("영화 제목: "+ticket.get제목());
			pw.println("영화 시간: "+ticket.get시간());
			pw.println("영화 날짜: "+ticket.get날짜());
			
			pw.close();
		}
		
		
		
		
		
		
		
		
		
	}
	
	//실제로 착석한 좌석을 찾아서 arrayList에 저장
	public void findExistSeat() {
		
		for(int i=0; i<theater.length; i++) {
			for(int j=0; j<theater[i].length; j++) {
				for(int k=0; k<theater[i][j].length; k++) {
					
					//Ticket이고 착석여부가 true일 때 출력
					if((theater[i][j][k] instanceof Ticket) && (theater[i][j][k].isReserved()==true)) {
						this.existSeat.add(theater[i][j][k]);
					}
						
				}
			}
		}
		
	}
}
