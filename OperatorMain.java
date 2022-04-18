package ch04_operator;

public class OperatorMain {

	public static void main(String[] args) {
		int numTen = 10;
		
		System.out.println(numTen);
		
		// 증감 연산자
		numTen++;           // 1 증가
		System.out.println(numTen);
		numTen++;
		System.out.println(numTen);
		numTen--;           // 1 감소
		System.out.println(numTen);
		
		++numTen;           // 연산기호를 앞에다가 써도 실행이 됨
		System.out.println(numTen);
		
		System.out.println(numTen++);  // 11
		System.out.println(numTen);    // 12
		System.out.println(++numTen);  // 13  <<< 3가지가 다 다르다
		System.out.println("\n========================\n");
		
		char hangul = 44032;
		System.out.println(hangul++);
		System.out.println(hangul++);
		System.out.println(hangul++);
		System.out.println(hangul++);
		System.out.println(hangul++);
		System.out.println(hangul++);
		
		// 대입 연산자
		
		numTen = 10;
		
		numTen += 1;
		System.out.println(numTen);     // 11
		numTen += 1;                    
		System.out.println(numTen);     // 12
		numTen += 56;					 
		System.out.println(numTen);     // 68
		numTen -= 30;					
		System.out.println(numTen);     // 38
		numTen *= 2;
		System.out.println(numTen);		// 76		
		numTen /= 3;
		System.out.println(numTen);		// 24	
		
		// 나머지 연산
		numTen %= 4;
		System.out.println(numTen);
		
		System.out.println("\n=============대입 연산자==========\n");
		
		
		// 산술 연산자
		
		int numFirst = 10;
		int numSecond = 3;
		
		numFirst = numFirst +1;
		System.out.println(numFirst);
		
		System.out.println("numFirst: 11, numSecond: 3");
		System.out.println("더하기: " + (numFirst + numSecond));
		System.out.println("빼기 : " + (numFirst - numSecond));
		System.out.println("곱하기: " + (numFirst * numSecond));
		System.out.println("나누기: " + (numFirst / numSecond));        // 소수점이 안나온
		System.out.println("나머지: "+ (numFirst % numSecond));
		
		double temp = 1.0 * numFirst / numSecond; 
		System.out.println(temp);
		
		// 먼저 계산할 부분에 대해 괄호 필수!! 단, 먼저 계산할 부분이 연산자 우선 규칙과 같다면 붙일 필요는 없다 
		int numThird = 10 + (3 * 10);
		System.out.println(numThird);
		
		System.out.println("\n==============================\n");
		
		// 나머지 연산자(%) 자주 쓰는 경우
		
		// 홀수 짝수 판별
		int anyNum = 7;
		
		int remain = anyNum % 2;
		System.out.println(remain);
		
		// 게시판 페이징 구현 할 때 사용
		int totalCountGul = 3158;       // 게시판에 글이 총 33개 있다.
		int showCountOnePage = 15;   // 한 페이지에서 보여줄 글의 수가 10개이다.
		
		// 총 페이지의 수   // 총 글의 수  // 페이지에 보여줄 글 개수          
		// 33 / 10 = 3.3 -> 올림 = 4
		int countPage = (int)Math.ceil((double)totalCountGul / showCountOnePage);
		System.out.println(countPage);
		int countLastPageGul = totalCountGul % showCountOnePage;
		// 마지막 페이지에 있는 글의 
		System.out.println("총 게시글 수 : " + totalCountGul);
		System.out.println("한 페이지당 보여줄 글의 수: " + showCountOnePage);
		System.out.println("총 페이지 수: " +  countPage);
		System.out.println("마지막 페이지에 있는 글의 수: " + countLastPageGul);
	    
		System.out.println("\n==========================\n");
		
		// 문자열 더하기
		String subway = "오룡";
		subway = subway + ", 용문";
		System.out.println(subway);
		subway = "종점, " + subway;
		System.out.println(subway);
		
		subway += ", 탄방";
		System.out.println(subway);
		
		System.out.println("\n=================\n");
		
		// 비교 연산자
		int numFive = 5;
		final double PI = 3.14;
		int numOne = 1;
		
		boolean boolVal = numFive > numOne;
		System.out.println(boolVal);
		boolVal = numFive < PI;
		System.out.println(boolVal);
		System.out.println(numOne > PI);
		
		System.out.println(10 >= 10);
		System.out.println(5 <= 5);
		
		System.out.println(10 == 10);
		System.out.println(5 != 10);
		
		// 문자열이 서로 같은지 비교
		String ship = "배";
		String pear = "배";
		String stomach = new String("배");
		System.out.println(ship == pear);
		System.out.println(ship == stomach);
		System.out.println(pear == stomach);
		System.out.println(ship.hashCode());
		System.out.println(pear.hashCode());
		System.out.println(stomach.hashCode());
		
						// OO.equals(문자열)
		// 해당 문자열이 괄호 안 문자열과
		// 같다면 true, 틀리면 false를 결과를 나타낸다
		System.out.println(ship.equals(stomach));
		
		String myMental = null;
		System.out.println(myMental == null);
		
		myMental = "";
		System.out.println(myMental.equals(""));
		System.out.println(myMental.length() == 0);
		System.out.println(myMental.isEmpty());
		
		System.out.println("\n=========================\n");
		
		// 삼항 연산자 (조건 연산자)
		String stuMental = "100";
		String state = (stuMental.isEmpty()) ? "내머리 텅텅" : "아무것도 들어있지 않아요";
		System.out.println(state);
		
		int stateNum = (stuMental.length() > 0) ? 100 : 0;
		System.out.println(stateNum);
		
		// 이중 삼항 연산자
		int score = 85;
		
		// score가 90점보다 크면 grade는 A
		// 80점보다 크면 B, 나머지는 C
		String grade = (score > 90) ? "A" : ((score > 80) ? "B" : "C");
		System.out.println(grade);
		
		// 논리 연산자
		
		myMental = "50";
		stuMental = "";
		
		// && 좌우 조건이 전부 참이어야만 true 리턴
		// 둘 중 하나라도 거짓이면 false 리턴
		System.out.println(myMental.isEmpty());
		System.out.println(stuMental.isEmpty());
		System.out.println(myMental.isEmpty() && stuMental.isEmpty());
		System.out.println(myMental.length() > 0 && stuMental.isEmpty());
		
		// || 좌우 조건 중 하나라도 참이라면 true,
		// 둘 다 거짓이라면 false 리턴
		System.out.println((myMental.isEmpty()) || (stuMental.isEmpty()));
		
		int numTwo = 2;
		int numThree = 3;
		int numFour = 4;
		
		// 2 < 3 < 4
		System.out.println((numTwo < numThree) && (numThree < numFour));
		// 논리연산자는 괄호안에 넣어주는게 좋다!!
		
		// 회원가입 예시
		String name = "혁진";
		String phone = "01080302514";
		int age = 12;
		
		// name 이 empty면 안되고
		//phone 이 10자리 또는 11자리
		//age 가 14 이상이어야함
		boolean checkName = name.length() > 0;
		boolean checkPhone = (phone.length() == 10) || (phone.length() == 11);
		boolean checkAge = age >=14;
		System.out.println(checkName && checkPhone && checkAge);
				
		
		// ! 는 boolean(true/false)의 값을 뒤집는다.
		checkName = !name.isEmpty();
		System.out.println(checkName);
		
		System.out.println("\n========================\n");
		
		// 비트 연산자
		int bitTen = 10;   // 2진수로 변환하면 1010
		int bitNine = 9;   // 2진수로 변환하면 1001
		
		// & AND
		System.out.println(bitTen & bitNine );
		// 8 -> 2진수로 변환하면 1000
		
		// |을 하나 쓰면 OR 연산자가 됨
		System.out.println(bitTen | bitNine);
		// 11 -> 이진수로 바꾸면 1011
		
		// ^ XOR
		System.out.println(bitTen ^ bitNine);
		
		System.out.println(303 & 147);
	
		
		
		
	
	
	
	}

}
