package com.study.free.service;

import java.util.List;

import com.study.common.vo.PagingVO;
import com.study.exception.BizNotEffectedException;
import com.study.exception.BizNotFoundException;
import com.study.exception.BizPasswordNotMatchedException;
import com.study.freeboard.vo.FreeBoardVO;

public interface IFreeBoardService {
	
	// javadoc
	/**
	 * free_board 테이블에서(조건에 맞는) 데이터만 가지고 오는 메소드 
	 * @author 한창희
	 * @param	아직은 없는데 나중에 FreeBoardSearchVO
	 * @return List<FreeBoardVO>
	 * 
	 */
	
	
	
	
	public List<FreeBoardVO> getBoardList(PagingVO pagingVO);
	public FreeBoardVO getBoard(int boNo) throws BizNotFoundException;
	
	public void increaseHit(int boNo) throws BizNotEffectedException;
	
	public void modifyBoard(FreeBoardVO freeBoard) 
			throws BizNotFoundException,BizPasswordNotMatchedException, BizNotEffectedException ;
	public void removeBoard(FreeBoardVO freeBoard)
			throws BizNotFoundException,BizPasswordNotMatchedException, BizNotEffectedException ;
	public void registBoard(FreeBoardVO freeBoard) throws BizNotEffectedException;

}
