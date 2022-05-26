package main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.AccountVO;
import model.UserVO;
import service.AccountService;
import service.UserService;



public class MyProjMain {

	public static void main(String[] args) {

		UserService userService = UserService.getInstance();
		AccountService accountService = AccountService.getInstance();
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("====================");
			System.out.println("가계부 작성하기");
			System.out.println("====================");
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 종료");
			System.out.print(">>> ");
			
			int command = 0;
			try {
				command = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요");
				continue;
			}
			
			if(command == 1) {
				// 회원가입
				System.out.println("아이디를 입력해주세요");
				System.out.print(">>> ");
				String id = sc.nextLine();
				System.out.println("비밀번호를 입력해주세요");
				System.out.print(">>> ");
				String pw = sc.nextLine();
				
			
			// 중복체크
			boolean isDuple = userService.dupleCheck(id);
		
			
			if(isDuple) {
				System.out.println("중복된 아이디 입니다.");
			}else {
				// 회원가입 진행
				int cnt = userService.registMem(new UserVO(id, pw));
				
				if(cnt > 0) {
					System.out.println("회원가입이 성공적으로 이루어졌습니다.");
				}else {
					System.out.println("회원가입 실패. 관리자에게 문의하세요");
				}
			}
		
		}else if(command == 2) {
			// 로그인
			System.out.println("아이디를 입력해주세요");
			System.out.print(">>> ");
			String id = sc.nextLine();
			System.out.println("비밀번호를 입력해주세요");
			System.out.print(">>> ");
			String pw = sc.nextLine();
			
			UserVO login = userService.loginMem(id);
			
			if(login != null) {
				if(login.getMemPw().equals(pw)) {
					// 로그인 성공
					System.out.println(login.getMemId() + "님 환영합니다.");
					
					// 가계부 입장
					while(true) {
						System.out.println("행동을 선택해주세요");
						System.out.println("1. 내역 쓰기 | 2. 내역 조회 | 3. 내역 수정 | 4. 로그아웃");
						System.out.print(">>> ");
						
						int select = 0;
						try {
							select = Integer.parseInt(sc.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("숫자만 입력해주세요");
							continue;
						}
						
						if(select == 1) {
							// TODO 글쓰기
							System.out.println("날짜를 입력해주세요.");
							System.out.print(">>> ");
							String date = sc.nextLine();
							System.out.println("내용을 입력해주세요.");
							System.out.print(">>> ");
							String contents = sc.nextLine();
							System.out.println("금액을 입력해주세요.");
							System.out.print(">>> ");
							Integer.parseInt(sc.nextLine());
							

							AccountVO account = new AccountVO(date, contents, login.getMemId();
							int count = accountService.writeAccount(account);
							
							if(count > 0) {
								System.out.println("내역 작성 완료되었습니다.");
							}else {
								System.out.println("내역 작성 실패");
							}
							
						}else if(select == 2) {
							// TODO 글조회
							System.out.println("글 번호를 입력해 주세요");
							System.out.print(">>> ");
							
							int no = Integer.parseInt(sc.nextLine());
							
							BoardVO board = boardService.getBoard(no);
							
							if(board != null) {
								System.out.println("=========================");
								System.out.println("제목: " + board.getBoardTitle());
								System.out.println("작성자: " + board.getBoardAuthor());
								System.out.println("작성일: " + board.getBoardDate());
								System.out.println("내용: " + board.getBoardContent());
								System.out.println("=========================");
							}else {
								System.out.println("해당 글번호는 존재하지 않습니다.");
							}
							
						}else if(select == 3) {
							// 로그아웃
							break;
						}else {
							System.out.println("잘못 입력하셨습니다.");
						}
						
						
					}
					
					
				}else {
		
					// 로그인 실패
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			}else {
				System.out.println("존재하지 않는 아이디입니다.");
			}
		}else if(command == 3) {
			// 종료
			System.out.println("종료합니다.");
			break;
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
