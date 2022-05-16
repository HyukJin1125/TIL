package ch10_extends_interface.starcraft;



public class HighTemplar extends ProtossUnit {
	// 필드 변수들을 복사, 붙여넣기 => 중복코드
	// 중복코드를 한데 묶어 놓으면 편하다 뭐가편하다?? !수정이 편하다.!
	
	private int shield;
	private int mp;
	
	public HighTemplar() {
		super("하이템플러", 0, 40, 0, 0, 0, 1, 50, 150, 40);
		
		this.mp = 225;
	}
			
	public void psionicStorm() {
		System.out.println("사이오닉 스톰 시전!!");
		mp -= 75;
	}
	public void hallucination() {
		System.out.println("할루시네이션 시전!!");
		mp -= 100;
	}
	
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
}
