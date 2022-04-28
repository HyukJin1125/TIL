package ch08_collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionMap {

	public static void main(String[] args) {
		// 맵(HashMap)의 선언
		HashMap<String, String> stuMap = new HashMap<String, String>();
		HashMap<String, Integer> coinMap = new HashMap<>();
		
		// Map도 다형성이 있다.
		Map<Integer, String> stuMap2 = new HashMap<Integer, String>();
		
		// .put(key, value)
		// 맵에 데이터 추가
		stuMap.put("첫째", "성빈");
		stuMap.put("둘째", "달현");
		stuMap.put("셋째", "혁진");
		// 맵(Map)은 중복된 '키'를 허용하지 않는다.
		// 중복된 키를 추가하게 되면 기존 키의 값을 덮어 쓴다.
		// 또한 값을 추가한 순서를 보장하지 않는다.
		System.out.println(stuMap);
		
		coinMap.put("비트코인", 50_000_000);
		coinMap.put("이더리움", 3_700_000);
		System.out.println(coinMap);
		
		stuMap2.put(0, "윤정");
		stuMap2.put(1, "나혜");
		stuMap2.put(2, "승주");
		System.out.println(stuMap2);
		
		System.out.println("\n==============\n");
		
		// . get(key)
		// key에 해당하는 value를 리턴한다.
		System.out.println(stuMap.get("첫째"));
		// 존재하지 않는 key를 입력하면 null을 리턴한다.
		System.out.println(stuMap.get("아무말"));
		
		System.out.println(coinMap.get("비트코인"));
		System.out.println(stuMap2.get(1));
		
		// .size()
		// 맵(Map) 안에 데이터의 개수 리턴
		System.out.println(stuMap.size());
		
		// containsKey(값)
		// 맵(Map) 안에 있는 키(Key) 중에 값에 해당하는게
		// 있으면 true, 없으면 false를 리턴한다.
		System.out.println(stuMap.containsKey("첫째"));
		System.out.println(stuMap.containsKey(1));
		
		// containsValue(값)
		// 맵 안에 있는 값(value) 중에 괄호 안 값에
		// 해당하는게 있으면 true, 없으면 false를 리턴한다.
		System.out.println(stuMap2.containsValue("나혜"));
		System.out.println(stuMap2.containsValue("나"));
		
		// .remove(key)
		//  key에 해당하는 데이터를 삭제
		coinMap.remove("비트코인");
		System.out.println(coinMap);
		
		System.out.println("\n=======================\n");
		
		// Map 순회
		// 1. keySet 이용
		Set<String> keySet = stuMap.keySet();
		
		// set을 향상된 for문으로 순회
		for(String key : keySet) {
			System.out.println(key + " : " + stuMap.get(key));
		}
		
		Set<Integer> keySet2 = stuMap2.keySet();
		for(Integer num : keySet2){
			System.out.println(num + " : " + stuMap2.get(num));
		}
		
		// 2. EntrySet 이용
		Set<Entry<String, String>> entrySet = stuMap.entrySet();
		
		for(Entry<String, String> entry : entrySet) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " : " + value);
		}
		
		Set<Entry<Integer, String>> entrySet2 = stuMap2.entrySet();
		for(Entry<Integer, String> entry : entrySet2) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " : " + value);
		}
		
		// forEach
		stuMap.forEach((key, vlaue) -> System.out.println(key + " : " + vlaue));
		
		
		
		
		
	}

}
