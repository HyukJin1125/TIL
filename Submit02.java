package hyukjin.submit02;

import java.util.Scanner;

public class Submit02 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("\n이름을 입력해주세요: ");
		String name = scanner.nextLine();
		System.out.println(name);
		System.out.print("\n국어 점수를 입력해주세요: ");
		String str1 = scanner.nextLine();
		int inas = Integer.parseInt(str1);
		System.out.println(str1);
		System.out.print("\n영어 점수를 입력해주세요: ");
		String str2 = scanner.nextLine();
		int inas1 = Integer.parseInt(str2);
		System.out.println(str2);
		System.out.print("\n수학 점수를 입력해주세요: ");
		String str3 = scanner.nextLine();
		int inas2 = Integer.parseInt(str3);
		System.out.println(str3);
		scanner.close();
				
		System.out.println("평균: " + (double)(inas + inas1 + inas2) / 3);
		
		System.out.println("\n==============\n");
		
		String idBack = "1231476";
		int as = Integer.parseInt(idBack.substring(0, 1));
		System.out.println((as %2 == 0) ? "여성" : "남성");
		
		
		
			
		
		
		
	}

}
