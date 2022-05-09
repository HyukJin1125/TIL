package question;

public class Question4 {
	public static void main(String[] args) {

		int money = 2760;
		int[] coin = { 500, 100, 50, 10 };

		for (int i = 0; i < coin.length; i++) {
			System.out.println(coin[i] + "원 : " + money / coin[i] + "개");

			money = money % coin[i];
		}
	}
}
