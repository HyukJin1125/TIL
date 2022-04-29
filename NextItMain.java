package ch09_class.nextit;

import java.util.ArrayList;
import java.util.Collections;

// 실행(main 메소드)만 하는 클래스
public class NextItMain {

	public static void main(String[] args) {
		String nameHyukjin = "오혁진";
		int ageHyukjin = 31;
		int levelHyukjin = 3;

		String nameGildong = "홍길동";
		int ageGildong = 30;
		int levelGildong = 6;

		System.out.println("\n========================\n");

		// 클래스 객체 선언
		Student Hyukjin = new Student();

		System.out.println(Hyukjin);

		// 객체의 필드 변수에 접근하기
		System.out.println(Hyukjin.name);
		System.out.println(Hyukjin.age);
		System.out.println(Hyukjin.level);

		// 필드 변수에 값을 입력하지 않으면,
		// 객체의 필드변수들은 초기값들로 설정되어 있다.
		// 숫자타입: 0 || boolean타입: false
		// 그외 나머지(참조타입이라고함): null

		System.out.println("\n==================\n");

		// 객체의 상태(State), 필드 변수에 값 넣기
		Hyukjin.name = "오혁진";
		Hyukjin.age = 31;
		Hyukjin.level = 3;

		System.out.println(Hyukjin.name);
		System.out.println(Hyukjin.age);
		System.out.println(Hyukjin.level);

		// 나이 한살 추가 하기
		Hyukjin.age++;
		System.out.println(Hyukjin.age);

		Hyukjin.printInfo();
		Student.printInfo();

		// 객체의 메소드 실행
		Hyukjin.endDay();
		System.out.println(Hyukjin.level);

		// 두 번째 객체
		Student nagyeom = new Student();
		nagyeom.name = "송나겸";
		nagyeom.age = 25;
		nagyeom.level = 8;

		nagyeom.endDay();

		System.out.println(nagyeom.name);
		System.out.println(nagyeom.age);
		System.out.println(nagyeom.level);

		System.out.println("\n====================\n");

		// 필드값을 입력 받는 생성자로 객체 선언
		Student syuli = new Student("박설리", 32, 10);

		System.out.println(syuli.name);
		System.out.println(syuli.age);
		System.out.println(syuli.level);

		// 객체의 상태(State)를 한번에 보고싶다!!
		// toSting() 만들어줌
		System.out.println(syuli.toString());

		System.out.println("\n===============\n");

		// 이름과 나이만 입력받는 생성자로 객체 선언
		Student nahye = new Student("가나혜", 30);
		System.out.println(nahye);

		System.out.println("\n===================\n");

		// 객체 복사
		Student nahyeBot = new Student(nahye.name + " 봇", nahye.age, nahye.level);
		System.out.println(nahyeBot);

		Hyukjin.endDay();
		nagyeom.endDay();
		syuli.endDay();
		nahye.endDay();
		nahyeBot.endDay();

		ArrayList<Student> stuList = new ArrayList<>();

		stuList.add(Hyukjin);
		stuList.add(nagyeom);
		stuList.add(syuli);
		stuList.add(nahye);
		stuList.add(nahyeBot);

		for (int i = 0; i < stuList.size(); i++) {
			stuList.get(i).endDay();
			stuList.get(i).isSubmit = true;
		}

		for (Student stu : stuList) {
			System.out.println(stu);
		}

		System.out.println("\n====================\n");

		// 레벨을 이용하여 정렬하기
		// 버블정렬
		
		for (int j = 0; j < stuList.size(); j++) {
			for (int i = 0; i < stuList.size() - 1 - j; i++) {
				// i > i+1 하면 오름차순
				// i < i+1 하면 내림차순
				if (stuList.get(i).level < stuList.get(i + 1).level) {
					Student tmp = stuList.get(i);
					stuList.set(i, stuList.get(i + 1));
					stuList.set(i + 1, tmp);
				}
			}
		}
		
		for(int i = 0; i < stuList.size();i++) {
			System.out.println((i+1) + "등. " + stuList.get(i));
		}
		
		System.out.println("\n===================\n");
		
		// 오름차순
		Collections.sort(stuList, (stu1, stu2) 
				-> stu1.level - stu2.level);
		
		// 내림차순
		Collections.sort(stuList, (stu1, stu2) 
				-> stu2.level - stu1.level);
		
		for(int i = 0; i < stuList.size();i++) {
			System.out.println((i+1) + "등. " + stuList.get(i));
		}
		
		
		
		
		
		
		
		
		
	}

}
