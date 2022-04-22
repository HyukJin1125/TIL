package submit06;

import java.util.Scanner;

public class Submit06 {

	public static void main(String[] args) {

		makeCard("오혁진", "010-8030-2514", "gurwls5524@naver.com");
		System.out.println("\n===============\n");
		
		makeTree(5);
		makeTree(7);
		
		System.out.println("\n====================\n");
		
		// 십진수를 이진수(String 타입)으로 리턴해주는
				// makeBinary 함수
				
				String binaryString = Integer.toBinaryString(30);
				System.out.println(binaryString);
				System.out.println(makeBinary(30));
				
				String hexString = Integer.toHexString(23);
				System.out.println(hexString); 
		
		
		
	
		
		
		
		
	

	
	} // main 끝지점
	
	static String reverse(String str) {
		// 로꾸꺼 (String을 뒤집는 녀석)
		String reverse = "";
		for(int i = str.length()-1; i >= 0; i--) {
			reverse += str.substring(i, i+1);
		}
		return reverse;
	}
	
		
	
	

	static String makeBinary(int num) {
		// 30이 들어왔다.
		// 30을 2로 나눠서 나머지 0 / 몫은 15
		// 15를 2로 나눠서 나머지 1 / 몫은 7
		// 7을 2로 나눠서 나머지 1 / 몫은 3
		// 3을 2로 나눠서 나머지 1 / 몫은 1
		String result = "";
		while(true) {
			result += num % 2;
			if(num == 1) {
				break;
			}
			num /= 2;
		}
		return reverse(result);
	}
	
	
	
	
	
	static void makeCard(String name, String num, String email) {
		System.out.print("\n================\n");
		System.out.println("이름 : " + name);
		System.out.println("연락처 : " + num);
		System.out.print("이메일 : " + email);
		System.out.println("\n================\n");
	}

	static void makeTree(int n) {
		for(int i = 1; i <= n; i++) {
			System.out.print(i + ": ");
			for(int t = 1; t <= (n - i); t++) {
				System.out.print(" ");
			}
			for(int k = 0; k < (i*2)-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	
	}

}
