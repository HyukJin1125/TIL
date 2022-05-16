package ch10_extends_interface.starcraft;

public class Zealot extends ProtossUnit{

	private int shield;
	
	public Zealot() {
		super("질럿", 16, 100, 1, 1, 2, 1, 100, 0, 60);
	}
	public void attack(StarUnit enemy) {
		enemy.setHp(enemy.getHp() - getDamage());
	}















}
