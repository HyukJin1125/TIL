package hyukjin.submit15.model;

public class BoardVO {
	private int num;
	private String user;
	private String date;
	private String title;
	private String contents;
	
	public BoardVO() {
		
	}

	public BoardVO(int num, String user, String date, String title, String contents) {
		super();
		this.num = num;
		this.user = user;
		this.date = date;
		this.title = title;
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", user=" + user + ", date=" + date + ", title=" + title + ", contents="
				+ contents + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	
	
	
	
	
	
	
	
	
}
