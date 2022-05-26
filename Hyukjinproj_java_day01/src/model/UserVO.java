package model;

public class UserVO {

	private String memId;
	private String memPw;
	
	public UserVO() {
		
	}

	public UserVO(String memId, String memPw) {
		super();
		this.memId = memId;
		this.memPw = memPw;
	}

	@Override
	public String toString() {
		return "UserVO [memId=" + memId + ", memPw=" + memPw + "]";
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
