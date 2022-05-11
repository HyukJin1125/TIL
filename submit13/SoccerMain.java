package hyukjin.submit13;

import java.util.Scanner;

public class SoccerMain {

	public static void main(String[] args) {
		Soccer quest = Soccer.getinstance();
		Scanner sc = new Scanner(System.in);
		quest.addName("손흥민");
		quest.addName("박지성");
		quest.addName("호날두");
		quest.addName("메시");
		quest.addName("즐라탄");
		while(true) {
			System.out.println("패널티 킥 게임");
			System.out.println("1. 시작 | 2. 종료");
			int command = Integer.parseInt(sc.nextLine());
			if(command==1) {
				System.out.println("플레이 할 선수를 고르세요");
				quest.showList();
				int playNum = Integer.parseInt(sc.nextLine());
				quest.game(playNum);
				System.out.println("다시하시겠습니까?");
				System.out.println("1. 다시하기 | 2. 종료");
				int reGame = Integer.parseInt(sc.nextLine());
				if(reGame==2) {
					break;
				}
				
			}else if(command==2) {
				break;
			}
			
		}
		
		
		
		
	}

}
