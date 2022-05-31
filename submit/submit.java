package submit;

import java.util.Scanner;

public class submit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("이름을 입력해주세요");
		System.out.print(">>>");
		String name = sc.nextLine();
		
		System.out.println("생년월일을 입력해주세요");
		System.out.print(">>>");
		String birth = sc.nextLine();
		
		System.out.println("연락처를 입력해주세요");
		System.out.print(">>>");
		String phone = sc.nextLine();
		
		System.out.println("이메일을 입력해주세요");
		System.out.print(">>>");
		String mail = sc.nextLine();
		
		System.out.println("이름: " + name + "\n생년월일: " + birth + "\n연락처: " + phone + "\n이메일: " + mail);
	}

}
