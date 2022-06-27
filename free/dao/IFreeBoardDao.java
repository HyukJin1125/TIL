package com.study.free.dao;

import java.util.List;

import com.study.common.vo.PagingVO;
import com.study.freeboard.vo.FreeBoardSearchVO;
import com.study.freeboard.vo.FreeBoardVO;

public interface IFreeBoardDao {

	
public int getTotalRowCount(FreeBoardSearchVO searchVO);	
public List<FreeBoardVO> getBoardList(FreeBoardSearchVO searchVO) ;
	
	
  public FreeBoardVO getBoard( int boNo);  
  public int increaseHit(int boNo); 
  
  public int updateBoard( FreeBoardVO freeBoard);
  
  public int deleteBoard( FreeBoardVO freeBoard);
  
  public int insertBoard(FreeBoardVO freeBoard);
List<FreeBoardVO> getBoardList();

  
}
