package hyukjin.submit13;

public class Penalty {

	private int playerNo;
	private String player;          
	private boolean defence = false;
	
	private Penalty() {
		
	}

	public int getPlayerNo() {
		return playerNo;
	}

	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public boolean isDefence() {
		return defence;
	}

	public void setDefence(boolean defence) {
		this.defence = defence;
	}

	@Override
	public String toString() {
		return "Penalty [playerNo=" + playerNo + ", player=" + player + ", defence=" + defence + "]";
	}

	public Penalty(int playerNo, String player, boolean defence) {
		super();
		this.playerNo = playerNo;
		this.player = player;
		this.defence = defence;
	}
	
	
	
	
	
	
	
	
	
	
}
