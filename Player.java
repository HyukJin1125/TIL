package hyukjin.submit13;

public class Player {

	private String name;    
	private int defence;

	
	private Player() {
		
	}

	public String getPlayer() {
		return name;
	}

	public void setPlayer(String player) {
		this.name = player;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	@Override
	public String toString() {
		return name;
	}

	public Player(String name) {
		super();
		this.name = name;
	
	}

	
	
	
	
	
	
	
	
	
}
