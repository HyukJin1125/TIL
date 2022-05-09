package question;

public class Question6 {

	public static void main(String[] args) {

		System.out.println(factorial(5)); // 120이 출력되도록 factorial메소드를 작성하세요
	}

	static int factorial(int n) {

		int facResult = 1;
		for (int i = 1; i <= n; i++) {
			facResult *= i;
		}
		return 0 + facResult;
	}
}
