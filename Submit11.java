package hyukjin.submit11;

import java.util.ArrayList;
import java.util.Collections;

import ch09_class.school.Student;

public class Submit11 {

	public static void main(String[] args) {

		ArrayList<Product> productList = new ArrayList<>();

		productList.add(new Product("냉장고", 2000000));
		productList.add(new Product("TV", 1000000));
		productList.add(new Product("에어컨", 800000));
		productList.add(new Product("컴퓨터", 1300000));
		productList.add(new Product("선풍기", 100000));

		for (int i = 0; i < productList.size(); i++) {
			for (int j = 0; j < productList.size() - 1 - i; j++) {
				// i > i+1 하면 오름차순
				// i < i+1 하면 내림차순
				if (productList.get(j).getProductPrice() > productList.get(j + 1).getProductPrice()) {
					Product tmp = productList.get(j);
					productList.set(j, productList.get(j + 1));
					productList.set(j + 1, tmp);
				}
			}
		}
		for (Product i : productList) {
			System.out.println(i);
		}

		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getProductName().equals("TV")) {
				System.out.println(i);
				break;
			}

		}

	}

}
