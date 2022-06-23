package com.study.free.dao;

import java.util.List;

import com.study.common.vo.PagingVO;
import com.study.freeboard.vo.FreeBoardVO;

public interface IFreeBoardDao {
	
public int getTotalRowCount(PagingVO paginVO);	
public List<FreeBoardVO> getBoardList(PagingVO paginVO) ;
	
	
  public FreeBoardVO getBoard( int boNo);  
  public int increaseHit(int boNo); 
  public int updateBoard( FreeBoardVO freeBoard);
  public int deleteBoard( FreeBoardVO freeBoard);
  public int insertBoard(FreeBoardVO freeBoard);

  
}
