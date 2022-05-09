package question;

public class Question3 {
	public static void main(String[] args) {

		String star = "";
		for (int i = 0; i < 5; i++) {
			star += "*";
			System.out.println(star);
		}

		String blank = "     ";
		String starTree = "";
		for (int i = 0; i < 5; i++) {
			starTree += "*";
			System.out.println(blank.substring(i) + starTree);
		}

		for (int i = 1; i <= 9; i += 2) {
			for (int t = 1; t <= (9 - i) / 2; t++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

	}
}
