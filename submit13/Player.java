package hyukjin.submit13;

public class Player {
	int number;
	String player;
	int score;
	public Player(int number, String player, int score) {
		super();
		this.number = number;
		this.player = player;
		this.score = score;
	}
	@Override
	public String toString() {
		return "번호 : " + number + " 번 이름 : " + player + "]";
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
