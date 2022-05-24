package ch14_jdbc_jsp.model;

public class StudentVO {
	private String stuId;
	private String stuName;
	private String stuPw;
	private int stuScore;

	public StudentVO(String stuId, String stuName, String stuPw, int stuScore) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuPw = stuPw;
		this.stuScore = stuScore;
	}

	public StudentVO() {
		super();
	}

	@Override
	public String toString() {
		return "학생 [아이디: " + stuId + ", 이름: " + stuName + ", 점수: " + stuScore + "]" + stuPw;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuPw() {
		return stuPw;
	}

	public void setStuPw(String stuPw) {
		this.stuPw = stuPw;
	}

	public int getStuScore() {
		return stuScore;
	}

	public void setStuScore(int stuScore) {
		this.stuScore = stuScore;
	}

}
