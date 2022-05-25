package hyukjin.submit15;

import java.util.ArrayList;
import java.util.Scanner;

import hyukjin.submit15.model.BoardVO;
import hyukjin.submit15.model.MemberVO;
import hyukjin.submit15.service.BoardService;
import hyukjin.submit15.service.MemberService;


public class HomeMain {

	public static void main(String[] args) {
		
		
		MemberService memService = MemberService.getInstance();
		BoardService boardService = BoardService.getInstance();
		
		ArrayList<BoardVO> BoardList = boardService.getBoardList();
		
		
		
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
				// 로그인
				System.out.println("아이디를 입력해주세요.");
				System.out.print(">>> ");
				String id = sc.nextLine();
				System.out.println("비밀번호를 입력해주세요.");
				System.out.print(">>> ");
				String pw = sc.nextLine();
				
				MemberVO login = memService.loginMem(id);
				
				if(pw.equals(login.getMemPassword())) {
					// 로그인 성공
					System.out.println(login.getMemId() + "님 환영합니다.");
					
					while (true) {
						// 게시글 목록 출력
					
						System.out.println("행동을 선택해주세요");
						System.out.println("1. 글쓰기 | 2. 글조회 | 3. 로그아웃");
						System.out.print(">>> ");

						int select = Integer.parseInt(sc.nextLine());

						if (select == 1) {
							// 글쓰기
							System.out.println("글 제목을 입력하세요");
							System.out.print(">>> ");
							String title = sc.nextLine();
							System.out.println("글 내용을 입력하세요");
							System.out.print(">>> ");
							String content = sc.nextLine();

							// BoardDB 에 글 등록 메소드 만들기
							// 글 제목, 글 내용, 작성자
							(title, content, member.getId());

						} else if (select == 2) {
							// 글조회
							System.out.println("글 번호를 입력해주세요");
							System.out.print(">>> ");

							int no = Integer.parseInt(sc.nextLine());

							// 해당 글의 내용까지 출력
							boardList.printBoards();
							if (!boardDB.selectBoard(no)) {
								System.out.println("해당 게시글이 존재하지 않습니다.");
							}

						} else if (select == 3) {
							// 로그아웃
							System.out.println("로그아웃 되었습니다.");
							break;
						}
					}
					
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
			
			MemberVO temp = new MemberVO(id, pw);
			memService.insertMem(temp);
			
		}else if(command == 3) {
			System.out.println("종료합니다.");
			break;
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}

	
	
	
	
	
	
	}
}	
