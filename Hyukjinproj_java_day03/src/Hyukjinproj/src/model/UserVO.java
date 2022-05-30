package Hyukjinproj.src.model;

public class UserVO {

	private String memId;
	private String memPw;
	private int age;
	public UserVO() {
		
	}
	public UserVO(String memId, String memPw, int age) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.age = age;
	}
	@Override
	public String toString() {
		return "[ 평균 사용금액 " + memPw + ", 연령대 : " + age + "]";
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
