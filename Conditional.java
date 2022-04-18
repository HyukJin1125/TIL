package ch05_contrll;

public class Conditional {
	// 이부분이 클래
	String txt = "메모";

	public static void main(String[] args) {
		// 조건문

		// if문
		int price = 30000;
		int myMoney = 10000;

		if (myMoney <= price) {
			System.out.println("돈이 최고입니다.");
		}

		if (myMoney < price) {
			System.out.println("돈이 최고입니다.");
		}

		// 블록을 생략할 수 있다.
		if (myMoney < price)
			System.out.println("카드값이 너무 많이 나왔습니다.");

		System.out.println("\n===================\n");

		// 변수의 사용범위(Scope)
		String review = "맛없어요~";
		String warning = "";
		if (review.length() < 12) {
			warning = "리뷰 먹튀하지마세요.";
		}

		// 블록 {} 중괄호 안에 선언된 변수는
		// 해당 중괄호 바깥에선 사용할 수 없다. 이것을 지역 변수라 한다.

		// 전역 변수: class 중괄호 안에서 선언된 변수
		// 해당 클래스 내 어디서든 사용이 가능하다.

		System.out.println("리뷰: " + review);
		System.out.println("결과: " + warning);

		System.out.println("\n====================\n");

		int intVal = 23;

		if (intVal > 0) {
			System.out.println("별점 5개 부탁드려요!!");
		} else if (intVal >= 0) {
			System.out.println("리뷰이벤트 참여하겠습니다.");
		}

		if (intVal > 0) {
			System.out.println("크다");
		} else if (intVal == 23) {
			System.out.println("크긴 크다");
		} else {
			System.out.println("오늘 큰 햄버거 먹고싶다");
		}
		int fday = 5;
		if (fday > 6) {
			System.out.println("오늘은 금요일");
		} else {
			System.out.println("오늘만 버티면 주말");
		}

		String dd = "JAVA는 어려웡";
		if (dd == "JAVA는 어려워") {
			System.out.println("미친소리하네");
		} else {
			System.out.println("그게 정상이지");
		}

		System.out.println("\n=================\n");

		// 웹 브라우저에서 사용자가 로그인을 하면
		// 해당 브라우저의 세션 스토리지에 로그인
		// 정보를 저장하는데, 이 정보를 이용해서
		// 로그인 된 화면 혹은 로그인하지 않은 화면을 보여준다.

		String userInfo = "gurwls4594";
		if (userInfo != null) {
			System.out.println("로그인 상태의 화면을 보여준다.");
		} else {
			System.out.println("로그인 화면으로 이동시킨다.");
		}

		// 리모콘의 전원 버튼의 경우
		// 버튼 하나로 on/off가 다 가능하다.
		boolean isPowerOn = false;

		// 전원 버튼을 눌렀을때의 로직
		if (isPowerOn) {
			System.out.println("TV를 끌까요?킬까요?말까요?");
			isPowerOn = false;
		} else {
			System.out.println("꼭 리모콘은 찾을려고 하면 없더라");
			isPowerOn = true;
		}

		if (isPowerOn) {
			System.out.println("TV를 끌까요?킬까요?말까요?");
			isPowerOn = false;
		} else {
			System.out.println("꼭 리모콘은 찾을려고 하면 없더라");
			isPowerOn = true;
		}

		// boolean의 true/false를 스위치의 on/off
		// 처럼 사용하는 boolean 변수를
		// 토글(toggle) 혹은 플래그(flag)라고 합니다.

		System.out.println("\n===============\n");

		// 주민번호 뒷자리의 첫번째 숫자로 성별구분
		String idBack = "2342567";
		int as = Integer.parseInt(idBack.substring(0, 1));

		if (as % 2 == 1) {
			System.out.println("남성");
		} else {
			System.out.println("여성");
		}

		// 이중 삼항 연산자 썼던거
		int score = 50;
		String grade = "C";

		if (score > 90) {
			grade = "A";
		} else if (score > 80) {
			grade = "B";
		}
		System.out.println(grade);

		score = 92;
		if (score > 80 && score <= 90) {
			grade = "B";
		} else if (score > 90) {
			grade = "A";
		}
		System.out.println("등급: " + grade);

		System.out.println("\n===================\n");

		// 회원가입 조건 체크
		// level 1
		String name = "혁진이";
		String phone = "01080302514";
		int age = 31;

		if (!name.isEmpty()) {
			if ((phone.length() == 10) || (phone.length() == 11))
				if (age >= 14)
					System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 불가");
		}

		// level 2
		boolean isOkay = false;
		if (!name.isEmpty()) {
			if (phone.length() == 10 || phone.length() == 11) {
				if (age >= 14) {
					isOkay = true;
					System.out.println("회원가입 성공");
				}
				isOkay = false;
				System.out.println("회원가입 실패");
			}

			// level 3

			// 여러분들의 교육기간(단위: 월)
		int month = 0;
		if (month == 0) {
			System.out.println("포기할까 생각중");
		} else if (month == 1) {
			System.out.println("오라클 DB 이대로 괜찮을까...?");
		} else if (month == 2) {
			System.out.println("이대로 취업 가능한가...?");
		} else if (month == 3) {
			System.out.println("지금도 어려운데...");
		} else if (month == 4) {
			System.out.println("팀에 민폐끼칠거 같아...");
		} else if (month == 5) {
			System.out.println("이쯤되면 놓아줄까...?");
		} else {
			System.out.println("화이팅!!");
		}

		// switch문
		switch (month) {
		case 0:
			System.out.println("그래도 해보자");
			break;
		case 1:
			System.out.println("하다보면 되겠지");
			break;
		case 2:
			System.out.println("근데 너무 배고프다");
			break;
		case 3:
			System.out.println("선생님 곰같아요");
			break;
		case 4:
			System.out.println("머리로 이해하는게 아니라 손이 이해하네");
			break;
		case 5:
			System.out.println("거리두기 풀린대!!!!");
			break;
		}
		
		
		
		
		
		
		
		}
	}
}
