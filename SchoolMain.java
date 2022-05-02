package ch09_class.school;

import java.util.ArrayList;
import java.util.Collections;

import ch09_class.UtilClass;

public class SchoolMain {

	public static void main(String[] args) {
		Student yunbin = new Student();
		
		System.out.println(yunbin.getName());
		System.out.println(yunbin.getKor());
		System.out.println(yunbin.getAvg());
		
		yunbin.setKor(85);
		yunbin.setName("신윤빈");
		yunbin.setEng(80);
		yunbin.setMath(86);
		
//		yunbin.setAvg((yunbin.getKor() + yunbin.getEng() + yunbin.getMath()) / 3.0);
//		System.out.println(yunbin.getAvg());
		
//		UtilClass util = new UtilClass();
		// static 메소드는 해당 클래스를
		// 객체로 만들지 않아도 사용이 가능
//		yunbin.setAvg(UtilClass.weRound(yunbin.getAvg(), 2));
		System.out.println(yunbin.getAvg());
		
		System.out.println("\n=========================\n");
		
		Student dongjun = new Student("유동준", 83, 91, 97, UtilClass.weRound((83 + 91 + 97)/3.0, 2));
		
		System.out.println(dongjun.getName());
		System.out.println(dongjun.getKor());
		System.out.println(dongjun.getAvg());
		
		System.out.println(dongjun.toString());
		
		System.out.println("\n=========================\n");
		
		Student hanjung = new Student("이한정", 88, 81, 78);
		
		System.out.println(hanjung);
		
		hanjung.setKor(92);
		System.out.println(hanjung);
		
		hanjung.setEng(83);
		System.out.println(hanjung);
		
		System.out.println("\n==========================\n");
		
		ArrayList<Student> stuList = new ArrayList<>();
		
		stuList.add(yunbin);
		stuList.add(hanjung);
		stuList.add(dongjun);
		stuList.add(new Student("김성빈", 90, 91, 91));
		stuList.add(new Student("석승원", 88, 87, 87));
		
		for(int i = 0; i < stuList.size(); i++) {
			System.out.println(stuList.get(i));
		}
		
		// stuList 의 학생들의 평균을 이용해서
		// 종합성적표를 출력해주세요.
		// 1등 김성빈 국어 90 영어 91 수학 91 평균 90.67
		// 2등 유동준 국어 xx 영어 xx 수학 xx 평균 xx.xx
		
		for(int k = 0; k < stuList.size(); k++) {
			for(int i = 0; i < stuList.size()-1-k; i++) {
				// i > i+1 하면 오름차순
				// i < i+1 하면 내림차순
				if(stuList.get(i).getAvg() < stuList.get(i+1).getAvg()) {	
					Student tmp = stuList.get(i);
					stuList.set(i, stuList.get(i+1));
					stuList.set(i+1, tmp);
				}
			}
		}
		
		for(int i = 0; i < stuList.size(); i++) {
			Student stu = stuList.get(i);
			System.out.println((i+1) + "등 " + stu.getName() 
				+ " 국어 " + stu.getKor() + " 영어 " + stu.getEng()
				+ " 수학 " + stu.getMath() + " 평균 " + stu.getAvg());
		}
		
		System.out.println("\n==========================\n");
		
		// Collections.sort 쓰기
		Collections.sort(stuList, (stu1, stu2) -> 
			(((Student)(stu1)).getAvg() - ((Student)(stu2)).getAvg() < 0) ? 1 : -1
		);
		
		for(int i = 0; i < stuList.size(); i++) {
			Student stu = stuList.get(i);
			System.out.println((i+1) + "등 " + stu.getName() 
				+ " 국어 " + stu.getKor() + " 영어 " + stu.getEng()
				+ " 수학 " + stu.getMath() + " 평균 " + stu.getAvg());
		}
		
		Collections.sort(stuList);
		
		for(int i = 0; i < stuList.size(); i++) {
			Student stu = stuList.get(i);
			System.out.println((i+1) + "등 " + stu.getName() 
				+ " 국어 " + stu.getKor() + " 영어 " + stu.getEng()
				+ " 수학 " + stu.getMath() + " 평균 " + stu.getAvg());
		}
		
		
	}

}