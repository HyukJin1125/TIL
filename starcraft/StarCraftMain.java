package ch10_extends_interface.starcraft;

import java.util.ArrayList;

public class StarCraftMain {

	public static void main(String[] args) {

		Marine marine = new Marine();
		
		System.out.println(marine.getName());
		
		marine.stimpack();
		marine.move(10,20);
		
		Zealot zealot= new Zealot();
		
		
		Zealot zealot2 = new Zealot();
		Zealot zealot3 = new Zealot();
		Zealot zealot4 = new Zealot();
		Zealot zealot5 = new Zealot();
		Zealot zealot6 = new Zealot();
		
		// 질럿들을 드래그로 선택
		ArrayList<Zealot> zealotList = new ArrayList<>();
		zealotList.add(zealot);
		zealotList.add(zealot2);
		zealotList.add(zealot3);
		zealotList.add(zealot4);
		zealotList.add(zealot5);
		zealotList.add(zealot6);
		
		// 선택한 질럿들에게 이동 명령
		for(int i = 0; i < zealotList.size();i++) {
			zealotList.get(i).move(10,30);
		}
		
		HighTemplar highTemplar = new HighTemplar();
		highTemplar.psionicStorm();
		
		// 하이템플러도 같이 선택하기
		// zealotList.add(highTemplar);
		
		// 다형성(Polymorphism)
		// 하나의 객체가 여러가지 타입을 가질 수 있는 것
		// 부모 클래스 타입의 참조 변수로(ProtossUnit, StarUnit)
		// 자식 클래스 타입의 인스턴스(zealot 객체)를 참조할 수 있는 것
		
		// 자식 객체에서 부모 객체로 형변환이 가능하다.
		ProtossUnit protoss = zealot;   // <<< 이 모습은 자동 형변환의 모습이다.
		ProtossUnit protoss2 = (ProtossUnit)zealot2;   // <<< 이 못습은 강제 형변환의 모습이다.
		
		// 자식 객체에서 조부모 객체로도 형변환이 가능하다.
		StarUnit star = zealot;       // (증조부, 고조부 당연히 가능하다)
		
		// 드래그 선택
		ArrayList<StarUnit>starList = new ArrayList<>();
		starList.add(zealot);
		starList.add(zealot2);
		starList.add(zealot3);
		starList.add(zealot4);
		starList.add(zealot5);
		starList.add(zealot6);
		starList.add(highTemplar);
		starList.add(marine);
		
		for(int i = 0; i < starList.size(); i++) {
			starList.get(i).move(20, 40);
		}
		
		// StarUnit을 담는 ArrayList인 starList에
		// Zealot, Marine, HighTemplar가 담기는 순간
		// 자동 형변환이 된 상태로 담긴다.
		
		// .get으로 꺼낼때는 형변환이 된 상태이므로,      <<< 이때는 (Marine 에서 StarUnit)으로 형변환 된 상태
		// 자식이 가진 메소드를 바로 사용할 수 없다.
		
		System.out.println(starList.get(7).getName());
		
		// 다시 형변환을 통해 되돌려 준 이후에 사용이 가능하다.  <<< 이때는 (StarUnit 에서 Marine)으로 형변환 된 상태
		((Marine)starList.get(7)).stimpack();
		
		((HighTemplar)starList.get(6)).psionicStorm();
		
		// 배열 내 객체가 무슨 클래스인지 알아야 거기에 맞게 형변환이 가능하다.
		// ((HighTemplar)starList.get(0)).psionicStorm();
		
		 for(int i = 0; i < starList.size(); i++) {
		/*	if(starList.get(i).getName().equals("하이템플러")) {
				((HighTemplar)starList.get(i)).psionicStorm();
			}
		*/
				
		// 객체 instanceof 클래스
		// 좌측의 객체가 우측의 클래스로 형변환이 가능하다면 true를 리턴하고,
		// 불가능 하다면 false를 리턴한다.
		if(starList.get(i) instanceof HighTemplar) {
			((HighTemplar)starList.get(i)).psionicStorm();
		// 마린이면 스팀팩 써보기
		}
		if(starList.get(i) instanceof Marine) {
			((Marine)starList.get(i)).stimpack();
		}
	 }
		
		StarUnit puma = new StarUnit("퓨마", 0, 0, 0, 0 , 0, 0, 0, 0);
		
		// 일반적으로 부모 객체는 자식 객체로 형변환 할수 없다.
		System.out.println(puma instanceof ProtossUnit);
		System.out.println(puma instanceof Marine);
		
		// 자식 객체는 얼마든지 부모 객체로 형변환이 가능하다.
		System.out.println(zealot instanceof ProtossUnit);
		System.out.println(zealot instanceof StarUnit);
		
		// 부모 객체로 형변환 되었던 자식 객체는
		// 다시 자식 객체로 형변환이 가능하다.
		ProtossUnit pro = zealot;
		System.out.println(pro instanceof Zealot);
		StarUnit su = highTemplar;
		System.out.println(su instanceof HighTemplar);
		System.out.println(pro instanceof HighTemplar);
		
		
		
		
		
		
	}

}
