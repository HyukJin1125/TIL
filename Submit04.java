package hyukjin.sumbit04;

import java.util.Scanner;

public class Submit04 {

	public static void main(String[] args) {

		// 난 경품 초콜릿이 좋아

		int j = 5834;
		int avg = j % 360;

		String grade = "";
		if ((avg >= 0) && (avg < 60)) {
			grade = "사탕";
		} else if ((avg >= 60) && (avg < 120)) {
			grade = "초콜릿";
		} else if ((avg >= 120) && (avg < 180)) {
			grade = "쿠키";
		} else if ((avg >= 180) && (avg < 240)) {
			grade = "콜라";
		} else if ((avg >= 240) && (avg < 300)) {
			grade = "아이스크림";
		} else {
			grade = "초콜릿";
		}
		System.out.println(grade);
		System.out.println("돌아간 횟수: " + j / 360);

		System.out.println("\n===================\n");

//	로꾸꺼 로꾸꺼 말해말~
		
		 Scanner scanner = new Scanner(System.in);
		 System.out.print("거꾸로 뒤집을 문자열 입력: "); String kor = scanner.nextLine(); String
		 str = ""; for(int i = kor.length(); i > 0; i--) { str +=
		 kor.substring(i-1,i); } System.out.println("뒤집은 결과: " + str);
		 
		System.out.println("\n========================\n");

// 반짝반짝 트리		
		for (int i = 1; i <= 9; i += 2) {
			for (int t = 1; t <= (9 - i) / 2; t++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("\n============\n");

		for (int i = 9; i >= 0; i -= 2) {
			for (int s = 1; s <= (9 - i) / 2; s++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
