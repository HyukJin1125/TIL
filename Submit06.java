package submit06;

public class Submit06 {

	public static void main(String[] args) {

		makeCard("오혁진", "010-8030-2514", "gurwls5524@naver.com");
		
		makeTree(5);
		makeTree(7);
		
		
		
	
		
		
		
		
	

	
	} // main 끝지점

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
