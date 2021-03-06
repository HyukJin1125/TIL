package com.study.member.service;

import java.util.List;

import com.study.exception.BizDuplicateKeyException;
import com.study.exception.BizNotEffectedException;
import com.study.exception.BizNotFoundException;
import com.study.member.dao.IMemberDao;
import com.study.member.dao.MemberDaoOracle;
import com.study.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{
	IMemberDao memberDao = new MemberDaoOracle();
	
	@Override
	public List<MemberVO> getMemberList() {
		// TODO Auto-generated method stub
		return memberDao.getMemberList();
	}

	@Override
	public MemberVO getMember(String memId) throws BizNotFoundException {
		MemberVO member=memberDao.getMember(memId);
		
		if(member==null) {
			throw new BizNotFoundException();
		}
		return member;
	}

	@Override
	public void modifyMember(MemberVO member) throws BizNotEffectedException, BizNotFoundException {
		MemberVO vo= memberDao.getMember(member.getMemId());
		if(vo==null) {
			throw new BizNotFoundException();
		}	
		if(vo.getMemId().equals(member.getMemId())) {
			int cnt = memberDao.updateMember(member);
		if(cnt<1) throw new BizNotEffectedException();
			}
		}
		
	

	@Override
	public void removeMember(MemberVO member) throws BizNotEffectedException, BizNotFoundException {
		MemberVO vo= memberDao.getMember(member.getMemId());
		if(vo==null) {
			throw new BizNotFoundException();
		}	
	
		if(vo.getMemId().equals(member.getMemId())) {
				//vo는 DB에 있는 현재 값
				//freeBoard는 edit.jsp에서 사용자가 입력한 값 
				int cnt = memberDao.deleteMember(member);
				if(cnt<1) throw new BizNotEffectedException();
			}		
	}

	@Override
	public void registMember(MemberVO member) throws BizNotEffectedException, BizDuplicateKeyException {
		int cnt=memberDao.insertMember(member);
		if(cnt<1) throw new BizNotEffectedException();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	

