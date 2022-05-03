package ch09_class.homepage;

import java.util.ArrayList;

public class BoardDB {
	private ArrayList<Board> boardList = new ArrayList<>();
	
	private BoardDB() {}
	
	private static BoardDB instance = new BoardDB();
	
	public static BoardDB getInstance() {
		return instance;
	}
	
	// 글 작성
	public void write(String title, String content, String author) {
		boardList.add(new Board(boardList.size()+1, title, content, author));
	}
	
	// 게시글 목록 출력
	public void printBoards() {
		for(int i = 0; i < boardList.size(); i++) {
			System.out.println(boardList.get(i));
		}
	}
	
	// 게시글 조회(클릭한거)
	public boolean selectBoard(int no) {
		for(int i = 0; i < boardList.size(); i++) {
			if(boardList.get(i).getNo() == no) {
				Board bo = boardList.get(i);
				System.out.println("제목: " + bo.getTitle());
				System.out.println("작성자: " + bo.getAuthor());
				System.out.println("내용: " + bo.getContent());
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
}