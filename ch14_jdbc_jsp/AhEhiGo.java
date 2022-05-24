package ch14_jdbc_jsp;

import java.util.ArrayList;
import java.util.Scanner;

import ch14_jdbc_jsp.model.StudentVO;
import ch14_jdbc_jsp.model.WordGameVO;
import ch14_jdbc_jsp.service.StudentService;
import ch14_jdbc_jsp.service.WordGameService;

public class AhEhiGo {

	public static void main(String[] args) {
		StudentService stuService = StudentService.getInstance();
		WordGameService wordService = WordGameService.getInstance();
		ArrayList<StudentVO> stuList = stuService.getStuList();
		ArrayList<WordGameVO> wordGameList = wordService.getWordList();
		ArrayList<String> wordList = new ArrayList<>();
		for(WordGameVO wordGame : wordGameList) {
			wordList.add(wordGame.getWord());
		}
		
		String inputCmd, id, pw, name, randomWord;
		int cmd;

		while (true) {
			System.out.println("1. 로그인 | 2. 회원가입 | 3. 회원 목록 조회 | 4. 종료");
			inputCmd = input("행동을 입력해주세요.");
			try {
				cmd = Integer.parseInt(inputCmd);
			} catch (NumberFormatException e) {
				System.out.println("유효하지 않은 명령어입니다.");
				continue;
			}

			if (cmd == 1) {
				id = input("아이디를 입력하세요.");
				pw = input("비밀번호를 입력하세요.");
				StudentVO session = stuService.getStuById(id);
				if (pw.equals(session.getStuPw())) {
					System.out.println(session.getStuName() + "님 환영합니다.");
					while (true) {
						System.out.println("1. 끝말잇기 시작 | 2. 랭킹 | 3. 로그아웃");
						inputCmd = input("행동을 입력해주세요.");
						try {
							cmd = Integer.parseInt(inputCmd);
						} catch (NumberFormatException e) {
							System.out.println("유효하지 않은 명령어입니다.");
							continue;
						}
						if (cmd == 1) {
							// TODO 끝말잇기 시작
							randomWord = wordList.get((int)(Math.random() * wordList.size()));
							System.out.println(randomWord);
							inputCmd = input("단어를 입력해주세요.");
						} else if (cmd == 2) {
							// TODO 랭킹 보기
						} else if (cmd == 3) {
							break;
						} else {
							System.out.println("유효하지 않은 명령어입니다.");
						}
					}
				} else {
					System.out.println("아이디 혹은 비밀번호가 틀렸습니다.");
				}
			} else if (cmd == 2) {
				name = input("이름을 입력하세요.");
				id = input("아이디를 입력하세요.");
				pw = input("비밀번호를 입력하세요.");
				if (stuService.addStu(new StudentVO(id, name, pw, 0)) == 1) {
					System.out.println("회원가입되었습니다.");
				} else {
					System.out.println("회원가입에 실패하였습니다.");
				}
			} else if (cmd == 3) {
				stuList = stuService.getStuList();
				for (Object o : stuList) {
					System.out.println(o);
				}
			} else if (cmd == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("유효하지 않은 명령어입니다.");
			}
		}
	}

	/**
	 * Python 스타일로 사용자 입력 받기
	 * 
	 * @param 표시할 메시지
	 * @return String 형태로 반환
	 */
	@SuppressWarnings("resource")
	public static String input(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg + "\n>>> ");
		String result = sc.nextLine();
		return result;
	}

	/**
	 * Python 스타일로 사용자 입력 받기
	 * 
	 * @return String 형태로 반환
	 */
	@SuppressWarnings("resource")
	public static String input() {
		Scanner sc = new Scanner(System.in);
		System.out.print(">>> ");
		String result = sc.nextLine();
		return result;
	}

	/**
	 * 구분선 출력
	 */
	public static void printLine() {
		System.out.println("==========");
	}

	/**
	 * ArrayList의 각 요소를 한 줄 씩 출력
	 * 
	 * @param 출력할 ArryList
	 */
	public static void print(ArrayList<Object> list) {
		for (Object o : list) {
			System.out.println(o);
		}
	}

}
