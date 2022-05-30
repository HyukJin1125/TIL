package Hyukjinproj.src.model;

public class AccountVO {

	private String date;
	private String contents;
	private int price;
	private String id;
	public AccountVO() {
		
	}

	public AccountVO(String id, String date, String contents, int price) {
		super();
		this.id = id;
		this.date = date;
		this.contents = contents;
		this.price = price;
	}

	@Override
	public String toString() {
		return "AccountVO [date=" + date + ", contents=" + contents + ", price=" + price + ", id=" + id + "]";
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	
	
	
	
	
	
	
	
}
