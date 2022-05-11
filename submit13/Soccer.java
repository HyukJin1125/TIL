package hyukjin.submit13;

import java.util.ArrayList;
import java.util.Scanner;

public class Soccer {
	ArrayList<Player> player = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	private  Soccer() {

	}
	private static Soccer instance = new Soccer();
	public static Soccer getinstance() {
		return instance;
	}
	public void addName(String name) {
		player.add(new Player(player.size()+1,name,0));
	}
	public void showList() {
		for(int i=0; i<player.size();i++) {
			System.out.println(player.get(i));
		}
	}
	public void game(int num) {
		int randInt = (int)(Math.random()*2)+1;
		for(int i=0;i<player.size();i++) {
			if(num==player.get(i).getNumber()) {
				int playtry=0;
				System.out.println(player.get(i).getPlayer()+"선수를 선택하셨습니다.");
				while(playtry<5) {
				randInt = (int)(Math.random()*2)+1;
				System.out.println(" 찰 방향을 선택해주세요");
				System.out.println("1. 왼쪽 | 2. 중앙 | 3. 오른쪽");
				int kickNum = Integer.parseInt(sc.nextLine());
				if(kickNum==randInt) {
					System.out.println("골키퍼가 잡아냅니다!!");
					playtry++;
				}else {
					System.out.println("골~~!!");
					player.get(i).setScore(player.get(i).getScore()+1);
					playtry++;
				}
				
				}
				System.out.println(player.get(i).getPlayer()+
						" 선수 "+player.get(i).getScore()+" 점");
				return;
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
