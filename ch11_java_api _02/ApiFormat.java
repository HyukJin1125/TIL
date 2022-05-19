package ch11_java_api;

import java.text.DecimalFormat;

public class ApiFormat {
	
	public static void main(String[] args) {
		// 숫자 형식 DecimalFormat
		
		// 자리수에 맞춰 숫자 앞에 0 붙이기
		// 1이면 001, 11이면 011, 111이면 111
		DecimalFormat deciFormat = new DecimalFormat("000");
		int anyNum = 13;
		String strNum = deciFormat.format(anyNum);
		System.out.println(strNum);
		
		System.out.println("\n================\n");
		
		// 자리수에 맞춰 소수 뒤에 0붙이기
		// 0.1이면 0.100, 0.11이면 0.110, 0.111이면 0.1 이 나오고 싶다
		
		deciFormat = new DecimalFormat("0.000");
		double anyDouble = 0.13;
		strNum = deciFormat.format(anyDouble);
		System.out.println(strNum);
		
		// 소수 넷째자리에서 반올림하시오
		double pi = 3.141592;
		deciFormat = new DecimalFormat("#.###");
		strNum = deciFormat.format(pi);
		System.out.println(strNum);
		
		double hi = Double.parseDouble(strNum);
		System.out.println(hi);
		
		
		System.out.println("\n=====================\n");
		
		// 천 단위마다 ,(쉼표) 붙이기
		int money = 12000000;
		deciFormat = new DecimalFormat("#,###");
		strNum = deciFormat.format(money);
		System.out.println(strNum);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
