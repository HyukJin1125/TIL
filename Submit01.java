package hyukjin.sumbit01;

public class Submit01 {

	public static void main(String[] args) {
		String name = "오혁진";
		int age = 25;
		String email = "gurwls4594@gmail.com";

		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("이메일 : " + email);
		System.out.println("\n=============================\n");

		String enigma = "너오구늘리뭐너먹구지리";

		String tryOne = enigma.replace("너", "");
		System.out.println("1차 암호 해독[너 제거]: " + tryOne);
		String tryTwo = tryOne.replace("구", "");
		System.out.println("2차 암호 해독[구 제거]: " + tryTwo);
		String tryThree = tryTwo.replace("리", "");
		System.out.println("3차 암호 해독[리 제거]: " + tryThree);
		System.out.println(tryThree);
		System.out.println(enigma);
		enigma = enigma.replace("너","");
		System.out.println(enigma);
		enigma = enigma.replace("구","");
		enigma = enigma.replace("리","");
		System.out.println(enigma);
		
		enigma = enigma.replace("너","").replace("구","").replace("리","");
		System.out.println(enigma);
		
		System.out.println("\n====================\n");
		
		
		
//		String example = "278";
		
//		String str1 = example.substring(0, 1);
//		String str2 = example.substring(1, 2);
//		String str3 = example.substring(2, 3);
//		int int1 = Integer.parseInt(str1);
//		int int2 = Integer.parseInt(str2);
//		int int3 = Integer.parseInt(str3);
		
//	int result = int1 + int2 + int3;
//	System.out.println("결과는 : " + result);

	
	
			
		
		
		
		
		
	
	String example = "278";
	
	String str1 = example.substring(0, 1);
	String str2 = example.substring(1, 2);
	String str3 = example.substring(2, 3);
	int int1 = Integer.parseInt(str1);
	int int2 = Integer.parseInt(str2);
	int int3 = Integer.parseInt(str3);
	
int result = int1 + int2 + int3;
System.out.println("결과는 : " + result);
	
	
	
	
	
	
	
	
	}
	

}
