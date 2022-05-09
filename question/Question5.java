package question;

public class Question5 {
	public static void main(String[] args) {

		int result = 1;
		for (int n = 5; n >= 1; n--) {
			result = n * result;
		}
		System.out.println(result);

	}
}
