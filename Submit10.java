package hyukjin.submit10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Submit10 {

	public static void main(String[] args) {

		
		// Q.01
		// makeLotto를 ArrayList와 HashSet을 이용해서 만들어보세요
		HashSet<Integer> hashLotto = new HashSet<Integer>();
		while(true) {
		int randInt = (int)(Math.random() * 45) + 1;	
		hashLotto.add(randInt);
		if (hashLotto.size() == 6){
			break;
			}
		}		
		System.out.println(hashLotto);   // HashSet을 이용
		
		ArrayList<Integer> makeLotto = new ArrayList<>();
		makeLotto.addAll(hashLotto);
		System.out.println(makeLotto);   // HashSet을 ArrayList로 변환
		
		// Q.02
		// infoMap의 Key는 사용자의 아이디, 
		// Value는 사용자의 비밀번호라고 했을 때
		// 아래와 같이 데이터를 추가해주세요.

		HashMap<String, String> infoMap = new HashMap<>();
		
		infoMap.put("a001", "1234a");
		infoMap.put("b001", "1234b");
		infoMap.put("c001", "1234c");
		infoMap.put("d001", "1234d");
		infoMap.put("e001", "1234e");

		// 사용자가 아이디와 비밀번호를 파라미터로 넣었을때, 
		// infoMap의 Key(아이디)와 Value(비밀번호)와 비교하여
		// 아이디와 비밀번호가 infoMap 내에 존재하는 데이터와 일치하면 로그인 성공 출력
		// 아이디가 존재하지 않으면, 존재하지 않는 아이디입니다. 출력 
		// 아이디는 존재하지만 비밀번호가 일치하지 않으면 비밀번호가 틀렸습니다. 출력

		Scanner sc = new Scanner(System.in);
		
		System.out.println("아이디를 입력해주세요");
		System.out.print(">>> ");
		String id = sc.nextLine();
		System.out.println("비밀번호를 입력해주세요");
		System.out.print(">>> ");
		String pass = sc.nextLine();
		
		if(!infoMap.containsKey(id)) {
			System.out.println("존재하지 않는 아이디입니다.");
		}else { 
			if(infoMap.get(id).equals(pass)) {
			System.out.println("로그인 성공");
			return;
			}
			else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		}
	

	
}

}
