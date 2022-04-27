package ch08_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PlayList {

	public static void main(String[] args) {
	
		// 자동 import [단축키 Ctrl + Shift + o]
		ArrayList<String> playList = new ArrayList<String>(Arrays.asList("INVU: 태연", "사랑은 늘 도망가: 임영웅", "취중고백: 멜로망스", "언제나 사랑해: 케이시", "듣고 싶을까: MSG워너비", "ELEVEN: IVE", "Step Back: GOT the beat", "abcdefu: GAYLE", "회전목마: sokodomo", "너, 너: 휘인", "SMILEY: YENA", "호랑수월가: 탑현", "리무진: 비오", "RUN2U: STAYC", "눈이 오잖아: 이무진", "Counting Stars: 비오", "신호등: 이무진", "어제처럼: 폴킴", "잊었니: 임영웅", "잊을 수 있을까: 노을", "HERO: 임영웅", "Can't Control Myself: 태연", "Next Level: aespa", "strawberry moon: 아이유", "겨울잠: 아이유", "끝사랑: 임영웅", "드라마: 아이유", "Bk Love: 임영웅", "만남은 쉽고 이별은 어려워: 베이식", "Weekend: 태연", "Savage: aespa", "Butter: 방탄소년단", "Dynamite: 방탄소년단", "OHAYO MY NIGHT: 디핵", "사랑인가 봐: 멜로망스", "라일락: 아이유", "Celebrity: 아이유", "낙하: 악동뮤지션", "Blueming: 아이유", "롤린: 브레이브걸스", "고백: 멜로망스", "그런 밤: 태연"));
		
		System.out.println("사이즈: " + playList.size());
		
		// 페이징 처리해서 출력
		// 플레이리스트 페이징 구현
		showPlayList(playList);
		
		System.out.println("\n========== 정렬 ===========\n");

		Collections.sort(playList);
		showPlayList(playList);
		
		System.out.println("\n=========== 검색 =============\n");
		
		// 검색어를 입력받으면
		// playList 에서 해당 검색어를 포함하는
		// 데이터만 담는 ArrayList를 리턴하는 
		// 메소드 만들기
		ArrayList<String> searchList 
					= searchSong("사랑", playList);
		showPlayList(searchList);
		
		System.out.println("\n======================\n");
		
		// 가수 검색
		searchList = searchSong("가수", "태연", playList);
		showPlayList(searchList);
		
		// 노래 제목 검색
		searchList = searchSong("노래", "사랑", playList);
		showPlayList(searchList);
		
	
	
	
	
	
	} // main 끝
	
static ArrayList<String> searchSong(String search
		, ArrayList<String> inputList){
	
	ArrayList<String> resultList = new ArrayList<>();
	for(int i = 0; i < inputList.size(); i++) {
		if(inputList.get(i).indexOf(search) != -1) {
			resultList.add(inputList.get(i));
		}
	}
	return resultList;
}

static void showPlayList(ArrayList<String> playList) {
	// 플레이리스트 목록 안에 있는 노래 개수
	int totalCount = playList.size();	
	// 한 페이지에서 보여줄 노래의 수가 10개
	int showCountOnePage = 10;	
	
	// 총 페이지의 수
	// 42 / 10 = 4.2 -> 올림 = 5
	int countPage = (int)Math.ceil((double)totalCount 
									/ showCountOnePage);
	// 마지막 페이지에 있는 노래의 수
	int countLastPage = totalCount % showCountOnePage;
	
	for(int i = 0; i < countPage; i++) {
		System.out.println((i+1) + " 페이지");
		
		int start = i * showCountOnePage;
		int end = (i+1) * showCountOnePage;
		// 마지막 페이지인 경우
		if(i == countPage - 1) {
			end = totalCount;
		}
		for(int k = start; k < end; k++) {
			System.out.println(playList.get(k));
		}
		System.out.println("===================");
	}
	
}
	
	
static ArrayList<String> searchSong(String option, 
		String search, ArrayList<String> inputList){
	
	ArrayList<String> resultList = new ArrayList<>();
	for(int i = 0; i < inputList.size(); i++) {
		String[] strArr = inputList.get(i).split(": ");
		if(option.equals("노래")) {
			if(strArr[0].indexOf(search) != -1) {
				resultList.add(inputList.get(i));
			}
		}else if(option.equals("가수")) {
			if(strArr[1].indexOf(search) != -1) {
				resultList.add(inputList.get(i));
			}
		}
	}
	return resultList;
}

	
	
	
	
	
	
	
	
	
	
	
	
}
