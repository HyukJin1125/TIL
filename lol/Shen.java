package ch10_extends_interface.lol;

// 인터페이스를 구현(implement)하기 위해서는
// extends가 아닌 implements 를 사용한다.
public class Shen extends Champion implements LolInterface, VoiceInterface{

	public Shen(String name, int damage, int hp) {
		super(name, damage, hp);
	}
	
	
	
	
	@Override
	public void skillQ() {
	System.out.println("쎄게 3대 때림");
	}

	@Override
	public void skillW() {
	System.out.println("방어막 킴");
	}

	@Override
	public void skillE() {
	System.out.println("돌진함");
	}

	@Override
	public void skillR() {
	System.out.println("아군 도와줌");
	}

	@Override
	public void ctrl1() {
	System.out.println("넌 이미 죽어있다");
	}

	@Override
	public void ctrl2() {
	System.out.println("ㅁㄴㄹㅇㄴ");
	}

	@Override
	public void ctrl3() {
	System.out.println("빛의~~~~");
	}

	@Override
	public void ctrl4() {
	System.out.println("하하하");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
