package hyukjin.submit13;

import java.util.ArrayList;

import hyukjin.submit12.Book;

public class PenaltyKick {

	private ArrayList<PenaltyKick> playerList = new ArrayList<>();
	
	String strPlayer = "박지성, 이영표, 이운재, 손흥민, 차두리";
	
	String[] strArray = strPlayer.split(",");
	
	public void choice(int num) {
		for(int i = 0; i < playerList.size();i++) {
			if(playerList.get(i).getPlayerNo() == num){
			System.out.println(playerList.get(i).getplayerNo());
				}else{
					System.out.println("잘못 된 입력입니다.");
				}
			}
		}
		
		












}
