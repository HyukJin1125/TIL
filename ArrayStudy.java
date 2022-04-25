package ch07_array;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class ArrayStudy {

	public static void main(String[] args) {
		// 배열(Array)

		String samjang = "삼장";
		String woogong = "오공";
		String saojeong = "사오정";
		String palgye = "저팔계";

		// 문자(String) 배열
		// 배열의 선언 1

		String[] seoyugi = new String[4]; // <<<< 이때 숫자 4는 첨자를 의미하며,
											// 배열의 크기(4)를 의미한다.

		// . length 배열의 크기를 리턴
		System.out.println(seoyugi.length);

		// 배열 내 요소(element)의 값을 확인
		// 인덱스 사용 그 사용하는 과정을(= 인덱싱)이라고 한다.
		System.out.println(seoyugi[0]);

		// 크기만 선언된 배열 내에는 기본값이 들어있다.

		// 기본값 (디폴트(default))
		// 참조타입: null
		// 기본타입(숫자형, boolean) <<< 두가지 외우기!!!!
		// 숫자타입: 정수는 0, 실수는 0.0
		// boolean타입: false
		int[] numbers = new int[2];
		System.out.println(numbers[1]);

		// for문을 이용하여 0부터 array.length 미만까지
		// 순회하면 배열의 모든 요소에 접근 가능하다
		for (int i = 0; i < seoyugi.length; i++) {
			System.out.println(seoyugi[i]);
		}

		System.out.println("\n==============\n");

		// 배열에 값 넣기

		seoyugi[0] = samjang;
		seoyugi[1] = "손오공";
		printArray(seoyugi);

		seoyugi[2] = "사오정";
		seoyugi[3] = "저팔계";

		printArray(seoyugi);

		// 배열의 단점
		// 크기가 고정됨!!!!!!!!!!!!!(그릇이 너무 작아ㅠㅠㅠ)
		// 늘어나지도, 줄어들지도 않는다.
		// = 값이 추가되지 않고, 값을 제거도 못한다.

		// 빨간줄 에러는 컴파일 에러로,
		// 실행을 안해봐도 이클립스가 캐치
		// 실행했을 경우 발생하는 에러는 런타임 에러
// 	seoyugi[4] = "크리링";

		// 배열의 장점
		// 배열에 담긴 모든 요소들은 한번에 처리할 수 있다.
		for (int i = 0; i < seoyugi.length; i++) {
			seoyugi[i] = "서유기 " + seoyugi[i];
		}
		printArray(seoyugi);

		// 배열 내 특정 요소에 접근하여 처리할 수 있다.
		for (int i = 0; i < seoyugi.length; i++) {
			// 손오공임?
			// 그럼 서유기를 드래곤볼로 바꿔
			// seoyugi[i].contains("손오공")               
			if (seoyugi[1].indexOf("손오공") != -1) {
				seoyugi[1] = seoyugi[1].replace("서유기", "드래곤볼");
			}
			printArray(seoyugi);
		}
		System.out.println("\n=========================\n");

		// 배열 안에 랜덤 숫자 넣기
		// 로또 번호 넣어주기
		// 1 ~ 45 사이의 랜덤 정수

		int[] intArray = new int[6];
		for (int i = 0; i < intArray.length; i++) {
			int randInt = (int) (Math.random() * 45) + 1;
			intArray[i] = randInt;
		}

		printArray(intArray);

		System.out.println("\n=============\n");

		// 배열의 선언 2
		String[] students = { "송나겸", "남궁혜연", "김달현" };

		// 기존방식
		String[] stu = new String[3];
		stu[0] = "송나겸";
		stu[1] = "남궁혜연";
		stu[2] = "김달현";

		printArray(students);

		System.out.println("\n==============\n");

		// 문자열 나누기
		String myInfo = "오혁진, 010-8030-2514, gurwls5524@naver.com";

		// .split(문자열)
		// 괄호안 문자열을 기준으로 해당 문자열을
		// 나누어 문자열 배열로 리턴한다.
		String[] infoArray = myInfo.split(",");
		System.out.println(infoArray.length);
		System.out.println(infoArray[0]);
		System.out.println(infoArray[1]);
		System.out.println(infoArray[2]);

		// 데이터가 거지같다면 ,로 일단 나누고
		// 이후 양쪽 공백을 제거해주면 된다.
		for (int i = 0; i < infoArray.length; i++) {
			infoArray[i] = infoArray[i].trim();
		}
		printArray(infoArray);
		
		System.out.println("\n==================\n");
		
		String calStr = "1+4+2";
		String[] calArray = calStr.split("\\+");
		// regex란 정규표현식(Regular Expression)의 약자
		// 정규표현식에서 *, ?, + 의 경우 특정 의미를 가지는
		// 특수문자 이므로 일반 문자로 쓰려면
		// 해당 특수기호 앞에 \\(역슬래쉬)를 붙인다.
		printArray(calArray);
	
		// 정규표현식 사용 예
		// 연락처를 숫자만 기입했는지 체크
		// 비밀번호에 알파벳 소문자, 대문자, 숫자, 특수기호 최소 1개 이상 넣었는지 체크
		System.out.println("\n==============\n");
		
		// 배열의 복사
		String[] sinSeoyugi = seoyugi;
		printArray(seoyugi);
		printArray(sinSeoyugi);
		
		sinSeoyugi[0] = "이승기";
		sinSeoyugi[1] = "이수근";
		printArray(seoyugi);
		printArray(sinSeoyugi);
		
		// @ 뒤에 붙은건 hashCode를 16진수로 나타낸 것
		System.out.println(seoyugi);
		System.out.println(sinSeoyugi);
		System.out.println(seoyugi.hashCode());
		System.out.println(sinSeoyugi.hashCode());
		System.out.println(Integer.toHexString(seoyugi.hashCode()));
		
		// 해쉬코드(hashcode)
		// 객체의 메모리 주소값을 이용해서
		// 해쉬를 적용한 코드
	
		// 해쉬(hash)란?
		// 해쉬함수(암호화 알고리즘을 말함)를 이용해서 
		// 데이터를 암호화하하는 기법(RSA, SHA 등...이 있다.)
		
		// 암호화, 복호화 정말 쉽다.
		// 암호화
		
		Encoder base64Encoder = Base64.getEncoder();
		String password = "1q2w3e4";
		// 문자열을 byte 배열로 변환
		byte[] passByte = password.getBytes();
		String encryption = new String(base64Encoder.encode(passByte));
		System.out.println(encryption);
		
		// 복호화
		Decoder base64Decoder = Base64.getDecoder();
		String decryption = new String(base64Decoder.decode(encryption));
		System.out.println(decryption);
		
		// 암호화시 사용된 알고리즘(여기선 base64 사용)과 일치하는 알고리즘을 이용하여,
		// 복호화 해야한다는 것에만 주의!!!
		
		System.out.println("\n================\n");
		
		// 올바른 배열 복사
		String[] synSeoyugi2 = seoyugi.clone();
		synSeoyugi2[0] = "안재현";
		
		printArray(seoyugi);
		printArray(synSeoyugi2);
		
		
		// clone을 까먹었어요
		String[] synSeoyugi3 = new String[seoyugi.length];
		
		// 문제
		// synSeoyugi3의 각각의 요소에
		// seoyugi의 각각의 요소를 넣으면 됨
		for(int i = 0; i < seoyugi.length; i++){
			synSeoyugi3[i] = seoyugi[i];
		}
		printArray(synSeoyugi3);
	
	} // main 끝

	static void printArray(int[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			if (i == intArray.length - 1) {
				System.out.println(intArray[i]);
			} else {
				System.out.print(intArray[i] + ", ");
			}
		}
	}

	static void printArray(String[] strArray) {
		for (int i = 0; i < strArray.length; i++) {
			if (i == strArray.length - 1) {
				System.out.println(strArray[i]);
			} else {
				System.out.print(strArray[i] + ", ");
			}
		}

	}

}
