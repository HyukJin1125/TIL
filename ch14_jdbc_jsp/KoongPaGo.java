package ch14_jdbc_jsp;

import java.util.ArrayList;
import java.util.Scanner;

import ch14_jdbc_jsp.model.StudentVO;
import ch14_jdbc_jsp.model.WordGameVO;
import ch14_jdbc_jsp.service.StudentService;
import ch14_jdbc_jsp.service.WordGameService;

public class KoongPaGo {

	public static void main(String[] args) {
		StudentService stuService = StudentService.getInstance();
		WordGameService wordService = WordGameService.getInstance();
		
		ArrayList<WordGameVO> wordGameList = wordService.getWordList();
		ArrayList<String> wordList = new ArrayList<>();
		for(int i = 0; i < wordGameList.size();i++) {
			wordList.add(wordGameList.get(i).getWords());
		}
		System.out.println(wordList.size());
		
		
		
		
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 로그인 | 2. 회원가입 | 3. 종료");
			System.out.print(">>> ");
			
			int command = 0;
			try {
				command = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해주세요.");
				continue;
			}
			
			if(command == 1) {
				//  로그인
				System.out.println("아이디를 입력해주세요.");
				System.out.print(">>> ");
				String id = sc.nextLine();
				System.out.println("비밀번호를 입력해주세요.");
				System.out.print(">>> ");
				String pw = sc.nextLine();
				StudentVO login = stuService.loginStu(id);
				
				if(pw.equals(login.getStuPassword())) {
				// 로그인 성공
				System.out.println(login.getStuName() + "님 환영합니다.");
				
				while(true) {
					System.out.println("행동을 선택해주세요.");
					System.out.println("1. 끝말잇기 시작 | 2. 랭킹");
					System.out.print(">>> ");
				
				int select = 0;
				select = Integer.parseInt(sc.nextLine());
				System.out.println("숫자를 입력해주세요");
				continue;
				}
				if(select == 1) {
					// TODO 끝말잇기 시작
					
					// wordList에서 랜덤 인덱스의 단어를 하나 출력 한다.
					int randInt = (int)(Math.random() * wordList.size());
					String computerWord = wordList.get(randInt);
					System.out.println("제시어: " + computerWord);
					
					System.out.print(">>> ");
					String inputText = sc.nextLine();
					
					// 1. inputText의 앞글자가 computerWord의 뒷글자와 같냐 판단해야한다.
					// 2. inputText가 wordList에 포함되어 있는 단어냐 판단해야한다.
					
				}else if(select ==2) {
					// 랭킹 보기
				}else if(select ==3) {
					break;
				}else {
					System.out.println("잘못 입력하셨습니다.");
				}
					
				
				}else {
					// 로그인 실패
					System.out.println("아이디 혹은 비밀번호가 다릅니다.");
				}
				
			}else if(command == 2) {
				// 회원가입 (Insert)
				System.out.println("아이디를 입력해주세요.");
				System.out.print(">>> ");
				String id = sc.nextLine();
				System.out.println("이름을 입력해주세요.");
				System.out.print(">>> ");
				String name = sc.nextLine();
				System.out.println("비밀번호를 입력해주세요.");
				System.out.print(">>> ");
				String pw = sc.nextLine();
				
				StudentVO temp = new StudentVO(id, name, pw, 0);
				stuService.insertStu(temp);
				
			}else if(command == 3) {
				System.out.println("종료합니다.");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
		}
		
	}

}
