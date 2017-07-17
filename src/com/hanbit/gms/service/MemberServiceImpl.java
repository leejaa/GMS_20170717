package com.hanbit.gms.service;
import java.util.List;

import com.hanbit.gms.dao.MemberDao;
import com.hanbit.gms.dao.MemberDaoImpl;
import com.hanbit.gms.domain.MemberBean;

public class MemberServiceImpl implements MemberService{
	MemberDao dao;
	public MemberServiceImpl() {
		dao=new MemberDaoImpl();
	}
	@Override
	public String addMember(MemberBean member) {
		return dao.insert(member)==0?"회원가입 실패":"회원가입 성공";
	}
	@Override
	public List<MemberBean> getMembers() {
		return dao.selectAll();
	}
	@Override
	public int countMembers() {
		return dao.count();
	}
	@Override
	public MemberBean memberById(String id) {
		return dao.selectById(id);
	}
	@Override
	public List<MemberBean> getMemberByName(String name) {
		return dao.selectByName(name);
	}
	@Override
	public String modify(MemberBean param) {
		if(param.getName().equals("")){
			param.setName(memberById(param.getId()).getName());
		}
		if(param.getPw().equals("")){
			param.setPw(memberById(param.getId()).getPw());
		}
		if(param.getSsn().equals("")){
			param.setSsn(memberById(param.getId()).getSsn());
		}
		return dao.update(param)==0?"회원정보수정 실패":"회원정보수정 성공";
	}
	@Override
	public String remove(String id) {
		return dao.delete(id)==0?"회원탈퇴실패":"회원탈퇴성공";
	}
}
