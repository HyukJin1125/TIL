package ch12_exception;

import java.util.Scanner;

public class TryWithResource {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("아무노래나 틀어 일단");
			System.out.print(">>>");
			String inputText = sc.nextLine();
			System.out.println(inputText);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//sc.close();
		}
		
		// try-with-resource 구문
		// 닫아야할 객체를 try() 괄호 안에 선언 후
		// try 블록{} 내에서 해당 객체를 사용한다.
		// 다만 객체의 클래스는 AutoCloseable 인터페이스를 구현하고 있어야 한다.
		
		try(Scanner sca= new Scanner(System.in)) {
			System.out.println("왜들그리 다운돼 있어");
			System.out.print(">>> ");
			String inputText = sca.nextLine();
			System.out.println(inputText);
		}catch(Exception e) {
			e.printStackTrace();
		}
		// try-with-resource의 경우, catch를 붙이지 않아도 된다. (닫는건 잘 닫음)
		
		// try() 괄호 안에 객체 여러개 선언도 가능하다.
		try(Scanner scan = new Scanner(System.in);
				Scanner scann = new Scanner(System.in)){
			System.out.println("뭐가문제야 say something: ");
			System.out.println(scan.nextLine());
			System.out.println("올때 병맥주랑 까까 몇개 사와: ");
			System.out.println(scann.nextLine());
		}
		
		
		
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
