package hyukjin.submit14;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BoardMain {
	public static void main(String[] args) {

		ArrayList<Board> boardList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		
		
		
		
		while (true) {
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 글 목록 | 2. 글 쓰기 | 3. 종료");
			System.out.print(">>> ");
			int command = Integer.parseInt(sc.nextLine());
			if (command == 2) {
				System.out.print("글 제목을 입력해주세요: ");
				String ttitle = sc.nextLine();
				System.out.print("글 내용을 입력해주세요: ");
				String ccontents = sc.nextLine();
				addtitle(boardList,ttitle,ccontents);
			}else if (command == 1) {
				for(int i = 0; i < boardList.size();i++) {
					System.out.println(boardList.get(i));
				}
			}else if (command == 3) {
				System.out.println("종료합니다.");
				break;
			}
		}
	}

	public static void addtitle(ArrayList<Board> list, String title, String contents) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String strToday = sdf.format(date);
	
		list.add(new Board(list.size()+1, title,strToday,contents));
	}
	
	
	
}
