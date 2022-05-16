package ch10_extends_interface.board;

public class BoardMain {

	public static void main(String[] args) {
		// 기본 게시판

		Board basic = new Board("구인","넥스트IT",1,"제발 와주세요","두번 와주세요","연봉이??");
		System.out.println(basic);
		
		// 거래 게시판
		TradeBoard trade = new TradeBoard("팝니다","승주아빠",1,"초콜릿 팝니다.","한입밖에 안먹었어요.","삽니다.",5000,"초콜릿.jpg");
		System.out.println(trade);
		
		// 영상 게시판
		VideoBoard video = new VideoBoard("롤","찬웅쌤", 1, "찬웅쌤 매드무비", "쉔하세요.","굿","");
		System.out.println(video);
		
		
		
		
		
		
		
	}

}
