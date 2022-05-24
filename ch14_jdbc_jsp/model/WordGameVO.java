package ch14_jdbc_jsp.model;

public class WordGameVO {
	private String word;

	public WordGameVO(String word) {
		super();
		this.word = word;
	}

	public WordGameVO() {
		super();
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
