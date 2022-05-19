package ch11_java_api;

public class ApiStringBuffer {

	public static void main(String[] args) {
		// 지금까지 문자열하면? String을 사용했다
		// String을 계속 수정하게 되면 힙메모리 영역에
		// 매번 새로운 String 객체가 만들어지고,
		// 그로인해 가비지컬렉터가 할 일이 많아진다.
		// 한마디로 !비효율적! 이라는 얘기다.
		
		// 랜덤숫자 10자리를 더한다
		String strVal = "";
		for(int i = 0; i < 10; i++) {
			// 0 ~ 9 랜덤 수 만들기
			int randInt = (int)(Math.random()*10);
			strVal += randInt;
		}
		System.out.println(strVal);
		
		System.out.println("\n===============\n");
		
		// StringBuffer
		StringBuffer strBuff = new StringBuffer();
		System.out.println(strBuff);
		
		// 문자열 추가해보자
		strBuff.append("안녕");
		System.out.println(strBuff);
		strBuff.append("하세요");
		System.out.println(strBuff);
		
		// StringBuffer 가 가진 문자열을 String 으로 꺼내오기
		String str = strBuff.toString();
		System.out.println(str);

		
		System.out.println("\n================\n");
		
		// StringBuilder
		StringBuilder strBuild = new StringBuilder();
		strBuild.append("안녕히");
		System.out.println(strBuild);
		strBuild.append("가세요");
		System.out.println(strBuild);
		
		String strB = strBuild.toString();
		System.out.println(strB);
		
		// 둘의 차이점은 무었일까?
		// StringBuffer는 동기화를 지원한다.
		// StringBuilder는 동기화를 미지원한다.
		
		// 그렇다면 '동기화를 지원한다' 란??
		// 멀티 쓰레드 환경에서 해당 객체가
		// 모든 쓰레드에서 안정적으로 사용 가능하도록 하는 것이다.
		
		// 동기화 미지원 (StringBuilder)
		// 쓰레드 a, b, c 에서 strBuild를 사용한다면
		// 쓰레드 a에서 strBuild의 값을 바꿨을 때
		// 쓰레드 b, c에서 이를 모른다.
		// 단일 쓰레드에서는 더 좋은 성능을 가진다.
		
		// 동기화를 지원 (StringBuffer)
		// 쓰레드 a, b, c에서 strBuff를 사용한다면,
		// 쓰레드 a에서 strBuff의 값을 바꿨을 때
		// 쓰레드 b,c에서 이를 안다.
		// 대신 단일 쓰레드에서 느린 성능 이다.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
