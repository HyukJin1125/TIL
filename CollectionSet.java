package ch08_collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionSet {

	public static void main(String[] args) {
		// 집합(HashSet)의 선언
		HashSet<String> stuSet = new HashSet<String>();
		HashSet<String> stuSet2 = new HashSet<>();
		Set<String> stuSet3 = new HashSet<String>();

		// .add() 값을 추가
		stuSet.add("이한정");
		stuSet.add("박기현");
		stuSet.add("유동준");
		System.out.println(stuSet);

		// set은 담은 데이터의 순서를 보장하지 않는다.
		System.out.println(stuSet);

		// 중복 값을 허용하지 않음(에러가 나는건 아님)
		stuSet.add("박기현");
		System.out.println(stuSet);

		System.out.println("\n======================\n");

		// .contains(값)
		// 해당 값이 Set 안에 있으면 true, 없으면 false 이다.
		System.out.println(stuSet.contains("이한정"));

		// .size()
		// Set 내 데이터의 개수를 리턴
		System.out.println(stuSet.size());

		System.out.println("\n===========\n");

		// Set 조회
		// 1. while문 사용
		Iterator<String> iterator = stuSet.iterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}

		// 2. 향상된 for문
		for (String name : stuSet) {
			System.out.println(name);
		}

		// 3. forEach 사용
		// 람다식의 경우 명령어가 한줄이면
		// 중괄호{} 와 세미콜론 ; 이 필요없다.
		// 두줄 부터는 중괄호와 세미콜론은 필수이다.
		stuSet.forEach(name -> System.out.println(name));
		stuSet.forEach(name -> {
			System.out.println(name);
			System.out.println(name);
		});

		System.out.println("\n==============\n");

		// Set은 집합을 쓰는 경우가 아니라면 잘 쓰진 않는다.
		// 그나마 Set을 사용한다면 Set의 중복을 허용하지 않는 속성을 이용하는 경우이다.

		ArrayList<Integer> intList = new ArrayList<>();

		// 10부터 20사이의 랜덤 숫자를 10개 담기
		for (int i = 1; i <= 10; i++) {
			intList.add((int) (int) ((Math.random() * (20 - 10)) + 10));
		}
		System.out.println(intList);

		// ArrayList에서 HashSet으로 변환
		HashSet<Integer> tempSet = new HashSet<Integer>();
		tempSet.addAll(intList);
		System.out.println(tempSet);
		
		//HashSet에서 ArrayList로 변환
		intList.clear();
		intList = new ArrayList<Integer>();
		intList.addAll(tempSet);
		System.out.println(intList);
		
		
	
	
	
	}

}
