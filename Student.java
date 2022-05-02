package ch09_class.school;

import ch09_class.UtilClass;

public class Student implements Comparable {
	// 캡슐화
	private String name;
	private int kor; // 국어 점수
	private int eng; // 영어 점수
	private int math; // 수학 점수
	private double avg; // 평균 점수

	public Student() {

	}

	public Student(String name, int kor, int eng, int math) {
		/*
		 * this.name = name; this.kor = kor; this.eng = eng; this.math = math;
		 * 
		 * double average = (kor + eng + math)/3.0; this.avg = Utilclass.weRound(average
		 * ,2);
		 */
		// this(name, kor, eng, math, UtilClass.weRound((kor + eng + math) / 3.0, 2);

	}

	public Student(String name, int kor, int eng, int math, double avg) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.avg = avg;
	}

	private void changeAvg() {
		this.avg = UtilClass.weRound((this.kor + this.eng + this.math) / 3.0, 2);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", avg=" + avg + "]";
	}

	// 단축키 : [Alt + Shift + S]
	// Generate Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		changeAvg();
	}

	public int getEng() {
		return eng;

	}

	public void setEng(int eng) {
		this.eng = eng;
		changeAvg();
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
		changeAvg();
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
		changeAvg();
	}

	@Override
	public int compareTo(Object stu2) {

		int result = 1;
		// < 오름차순
		// > 내림차순
		if (this.avg - ((Student) stu2).getAvg() > 0) {
			result = -1;
		}

		// 총점으로 해도 정렬 되잖아?
		int myTotal = this.kor + this.eng + this.math;
		int yourTotal = ((Student) stu2).getKor() 
				   	+ ((Student) stu2).getEng()
				   	+ ((Student) stu2).getMath();

		// myTotal - yourTotal 은 오름차순이고,
		// yourTotal - myTotal 은 내림차순이다.
		return myTotal - yourTotal;
	}

}
