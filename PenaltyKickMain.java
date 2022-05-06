package hyukjin.submit13;

import java.util.ArrayList;
import java.util.Scanner;

public class PenaltyKickMain {

	public static void main(String[] args) {

		ArrayList<Player> playerList = new ArrayList<>();
		/*
		 * playerList.add(new Player("손흥민")); playerList.add(new Player("이영표"));
		 * playerList.add(new Player("이운재")); playerList.add(new Player("박지성"));
		 * playerList.add(new Player("차두리"));
		 */
		String player = "1. 손흥민 | 2. 이영표 | 3. 이운재 | 4. 박지성 | 5. 차두리";
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("승부차기를 시작하시겠습니까?");
			System.out.println("1. 시작 | 2. 종료");
			System.out.print(">>> ");
			int command = Integer.parseInt(sc.nextLine());
			if (command == 1) {
				System.out.println("승부차기를 시작합니다.");
				System.out.println("\n====================\n");
				System.out.println("어떤 선수를 선택하시겠습니까?");
				System.out.println(player);
				System.out.print(">>> ");
				int command2 = Integer.parseInt(sc.nextLine());
				if(command2 == 1 ){
				System.out.println("손흥민 선수를 선택하셨습니다.");
				}else if(command2 == 2) {
					System.out.println("이영표 선수를 선택하셨습니다.");
				}else if(command2 == 3) {
					System.out.println("이운재 선수를 선택하셨습니다.");
				}else if(command2 == 4) {
					System.out.println("박지성 선수를 선택하셨습니다.");
				}else if(command2 == 5) {
					System.out.println("차두리 선수를 선택하셨습니다.");
				}
				System.out.println("\n====================\n");
				System.out.println("슛의 방향을 선택해주세요.");
				System.out.println("1. 왼쪽 | 2. 중앙 | 3. 오른쪽");
				System.out.print(">>> ");
				int command3 = Integer.parseInt(sc.nextLine());
				int randInt = (int)(Math.random() * 3) + 1;
				if(command3 == randInt) {
				System.out.println("골키퍼에게 막혔습니다.");
				}else{
				System.out.println("골~~~!!!");
				}
				
				
				
			
			
			
			
			
			
			} else if (command == 2) {
				System.out.println("게임이 종료되었습니다.");
				break;
			}

		}

	}

}
