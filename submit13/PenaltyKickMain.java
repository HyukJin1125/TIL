package hyukjin.submit13;

import java.util.Scanner;

public class PenaltyKickMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("승부차기를 시작하시겠습니까?");
			System.out.println("1. 시작 | 2. 종료");
			System.out.print(">>> ");
			int command = Integer.parseInt(sc.nextLine());
			if(command == 1) {
			System.out.println("승부차기를 시작합니다.");
			System.out.println("\n====================\n");
			System.out.println("어떤 선수를 선택하시겠습니까?");
			
			int num = Integer.parseInt(sc.nextLine());
			System.out.println( " 선수를 선택하였습니다");
			
			
			
			
			
			}else if(command == 2){
				System.out.println("게임이 종료되었습니다.");
			}
				
				
			
	
	
	
	
	
	
	
	
	
	
		}
	
	
	
	
	
	
	
	
	
	
	
	}

}
