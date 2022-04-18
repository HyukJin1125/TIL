package ch03_system_inout;

import java.util.Scanner;

public class SystemMain {
	public static void main(String[] args) {
		// 자동 줄 맞추기
		// 단축기 [Ctrl + Shift + F]
		// (단, 현재 클래스에 에러가 없어야 동작!!)

		// 콘솔에 텍스트 출력하기
		// println() 콘솔창에 출력 후 줄바꿈(개행문자)을 넣어준다.
		System.out.println("알고 있긴 한데 좀 헷갈리긴 해요");
		System.out.println(); // 내용은 없지만 줄바꿈은 들어간다.
		System.out.println("아 정말요? 하지만 내일되면 다 까먹겠죠?");  // -----------완료

		// print() 괄호안 텍스트를 콘솔에 출력
		// 줄바꿈(개행문자)가 들어가지 않음
		System.out.print("그냥 println쓰자");
		System.out.print("그냥 print만 쓰면 줄바꿈이 일어나지 않음!!\n"); // ------------완료	
		System.out.println("이건 줄바꿈(개행문자 가능)");
		System.out.print("이건 줄바꿈(개행문자 불가능)");
		
		

		System.out.println("\n===========================\n");

		// 제어문자
		// 문자열 내에 역슬래시( \ )를 이용하여, 특정 기능을 사용할 수 있다.

		// \t 탭

		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("1\t2\t3\t4\t5\t6\t7");
		System.out.println("1월\t2월\t3월\t4월\t5월");
		
		
		// \n 줄바꿈
		System.out.print("나도 println이 되고 싶어\n");
		System.out.print("아까 해봤던 println은 가능하고 print는 불가능했던 줄바꿈(개행문자) 하지만 여기에 \"\\n\"을 붙인다면??짜잔~ 그냥 프린트도 줄바꿈이 되지롱~\n");
		

		// 기능을 가지는 문자(\, ", ')를 콘솔창에
		// 출력하고 싶다면 앞에 \를 붙인다.
		System.out.println("제어문자는 앞에 \\를 붙인다.");
		System.out.println("소크라테스: \"너 자신을 알라\"");

		// 특수문자도 출력 가능하다.
		System.out.println("●");

		System.out.println("\n=============================\n");

		// printf() 은 포맷 문자열(format string)
		// 과 함께 사용
		System.out.printf("%d명이 밥을 먹고있습니다.\n", 5000);
		System.out.printf("%d명이 춤을 %d째 추고 있습니다.\n", 21, 2000);
		System.out.printf("%d명이 %s을 듣고 있습니다.\n", 21, "음악");

		// 예시
		System.out.printf("%02d장 표준입출력\n", 3); // %02d 같은 경우에는 두자리수를 넣지 않았을 때 앞에 0을 넣어라
		System.out.printf("%.03f \n", 3.141592);
		System.out.printf("%.03f \n", 3.14);

		System.out.println("\n=============== 표준 입력 ====================\n");

		// 표준 입력
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 회사를 입력하세요");
		System.out.print(">>> ");
		String name = scanner.nextLine();
		System.out.println(name);
		System.out.println("대전에서 근무하실 건가요?");
		System.out.print(">>> ");
		String str = scanner.nextLine();
		System.out.println(str);
		scanner.close();
		
		// scanner.nextInt() 은 사용하지 마세요.
//		int temperature = scanner.nextInt();
		


		// 키보드 입력을 받는 통로를 열어 두었던 것을 닫는다.
		// (안닫아도 큰 문제가 생기지는 않는다)
//		scanner.close();
		
		
		
		
		
		
		
		
		

	}
}
