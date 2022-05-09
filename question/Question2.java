package question;

public class Question2 {
	public static void main(String[] args) {
		for (int i = 1; i <= 4; i++) {
			if (i > 5) {
				continue;
			}
			System.out.println("2 x " + i + " = " + (2 * i));
		}

	}
}
