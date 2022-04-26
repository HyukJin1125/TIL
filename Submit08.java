package submit08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Submit08 {

	public static void main(String[] args) {
		
		
		// Q.01 - 1 
		ArrayList<Integer> intList = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++){
		 intList.add((int)(int)((Math.random() * (20 - 10)) + 10));
			}
		System.out.println(intList);
		
		// Q.01 - 2
		
		for(int i : intList) {
		System.out.print(i + " ");
		}
		System.out.println();
		
		// Q.01 - 3
		ArrayList<Integer> intList2 = new ArrayList<>();
		
		for(int i = 0; i < intList.size(); i++){
		if(!intList2.contains(intList.get(i)))
			intList2.add(intList.get(i));
		}
		System.out.println(intList2);
		
		// Q.01 - 4
		// 오름차순
		Collections.sort(intList2);
		for(int i = 0; i < intList2.size();i++) {
			System.out.print(intList2.get(i)+" ");
		}
		System.out.println();
		
		// Q.01 - 5
		// 내림차순
		Collections.sort(intList2,Collections.reverseOrder());
		System.out.println(intList2);
		for (int i = 0; i < intList2.size(); i++) {
			System.out.print(intList2.get(i)+" ");
		}
		System.out.println();
		
		// Q.02
		ArrayList<String> woman = new ArrayList<>();
		ArrayList<String> man = new ArrayList<>();
		
		woman.add("냉장고");
		woman.add("세탁기");
		woman.add("에어컨");
		
		man.add("노트북");
		man.add("TV");
		man.add("에어컨");
		
		System.out.println(woman);
		System.out.println(man);
		
		
					
		
		
		
	}

}
