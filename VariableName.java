package ch02_variable;

public class VariableName {
	// 프로젝트 이름은 앞에 대문자를 쓴다.
	// 다음 단어의 앞글자도 대문자
	
	// 패키지 이름은 전부 소문자로 쓴다.
	// 단어와 단어 사이에 언더바(_) 추가
	
	// 클래스 이름은 프로젝트 이름 짓는법과 동일
	
	// 변수명 짓기
	// 카멜(Camel) 방식
	int todayISHappy = 0;
	// 스네이크 방식
	int today_is_happy = 0;
	// 헝가리안 방식
	int intTodayIsHappy = 0;
	String strTodayIsHappy = "행복해~";
	// 변수일때는 변수명 앞에 v_를 붙이고,
	// 함수일때는 함수명 앞에 f_를 붙이고,
	// 파라미터 변수에는 앞에 p_를 붙이는 방식
	int v_todayIsHappy = 0;
	
	
	// 변수명 규칙
	// 이미 선언된 변수명은 사용 불가
	
	// 공백문자 및 특수문자는 사용 불가

	// 영어 대소문자를 구분한다.
	int toDayIsHappy = 0;
	int todayIsHappy = 0;
	int TodayIsHappy = 0;
	// 위 내용 처럼 하지마라
	
	// 숫자를 맨 앞에 쓸 수 없다.
	int today2 = 0; //가능
//	int 2today = 0; //불가능
	// 변수명의 글자 수의 제한은 없다.
	int a = 30; // 단, 이렇게 하지말 것
	// 맨 앞에 $, _ 기호를 쓸 수 있다.
	int $todayIsHappy = 0;
	int _todayIsHappy = 0; // 둘 다 가능
	// 자바 예약어를 사용불가
	// 상수명 짓기
	// 단어 전부 대문자를 사용하며,
	// 단어 사이에 언더바( _ )를 붙여서 표기
	final String NEXT_IT_ADDRESS = "대전 희명빌딩 2층";
	
	
	
	
	
 	
	
	
	
	
	
	
	
}
