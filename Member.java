package ch09_class.member;

public class Member {
	String id;        // 사용자 아이디
	String passWord;  // 사용자 비밀번호
	String name;      // 사용자 이름
	
	public Member(){
		
	}
	
	public Member(String id, String passWord, String name) {
		
		this.id = id;
		this.passWord = passWord;
		this.name = name;
	}

	@Override
	public String toString() {
		return "[아이디: " + id + ", 이름: " + name + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
