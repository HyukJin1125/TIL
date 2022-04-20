package submit05;

import java.util.Scanner;

public class Submit05 {

	public static void main(String[] args) {

		// 랜덤한 수 얻기

		// Math.random() 은 0 ~ 1 사이의 랜덤 실수 리턴
		// Math.random() * 10은 0 ~ 10 사이의 랜덤 실수
		// (int) (Math.random() * 10) 은 0 ~ 9 까지의 정수 중 랜덤으로 리턴한다.
		// 1 ~ 50까지 중 랜덤한 정수를 얻고 싶다
		// (int) (Math.random() * 50) 이렇게 해버리면 49까지만 나오기 때문에 +1 을 해준다.

		// TODO 반복문 (for문, while문)
		// 사용자로부터 숫자 입력 받음(int)
		// randInt 와 비교

		// 반복문 종료(break) 조건
		// 1. 정답을 맞춘 경우
		// 2. 5번 반복이 된 경우
		int randInt = (int) (Math.random() * 50 + 1);
		Scanner sc = new Scanner(System.in);

		
		  for (int i = 4; i >= 0; i--) { System.out.print("숫자를 입력해주세요. : "); int result
		  = Integer.parseInt(sc.nextLine());
		  
		  if (randInt == result) { System.out.println("정답입니다."); break; } else if (i ==
		  0) { System.out.println("실패하였습니다. 정답은 " + randInt + "입니다."); break; } else if
		  (randInt < result) { System.out.println("다운!! 기회가 " + i + "번 남았습니다."); } else
		  if (randInt > result) { System.out.println("업!! 기회가 " + i + "번 남았습니다."); } }
		 
		System.out.println("\n==================\n");

		// 엘리베이터
		// TODO 사용자의 위치를 입력 받고
		// 사용자의 위치와 각 엘리베이터의 층수 차이를 계산
		// 해당 층수 차이에 따른 엘리베이터 이동
		// (층수 차이가 적은게 이동, 층수 차이가 같다면, 높은 층에 있는 엘리베이터가 이

		int floorA = 10;
		int floorB = 4;
		String elev = "";

		while (true) {
			System.out.println("\n======희영빌딩 엘리베이터======\n");

			System.out.println("승강기 A의 현재 위치 : " + floorA + "층");
			System.out.println("승강기 B의 현재 위치 : " + floorB + "층");
			System.out.print("몇층에 계시나요?[종료하시려면 q 또는 exit 입력]:");
			String cmdStr = sc.nextLine();
			if (cmdStr.equals("q") || cmdStr.equals("exit")) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}

			int result2 = Integer.parseInt(cmdStr);
			System.out.println(result2 + "층에서 엘리베이터를 호출합니다.");

			if (Math.abs(result2 - floorA ) < Math.abs(result2 - floorB)) {
				floorA = result2;
				elev = "A";
				System.out.println("승강기 A가 " + result2 + "층으로 이동하였습니다.");
			} else if (Math.abs(result2 - floorA) > Math.abs(result2 - floorB)) {
				floorB = result2;
				elev = "B";
				System.out.println("승강기 B가 " + result2 + "층으로 이동하였습니다.");
			} else {
				if (Math.abs(result2 - floorA) <= Math.abs(result2 - floorB)) {
					System.out.println("승강기 A가 " + result2 + "층으로 이동하였습니다.");
					floorA = result2;
					elev = "A";
				} else {
					System.out.println("승강기 B가" + result2 + "층으로 이동하였습니다");
					floorB = result2;
					elev = "B";
				}
			}

			System.out.println("승강기 " + elev + "가 도착하였습니다.");
			System.out.print("이동할 층 입력: ");
			int elevDe = Integer.parseInt(sc.nextLine());
			System.out.println("승강기 " + elev + "가 " + elevDe + "층으로 이동합니다.");

			if (elev.equals("A")) {
				floorA = elevDe;
			}else{
				floorB = elevDe;
			}
		}

		
		
		
		
		
	}
}