package com.hanbit.gms.dao;

import java.util.List;

import com.hanbit.gms.domain.MemberBean;

public interface MemberDao {
	public int insert(MemberBean member);
	public List<MemberBean> selectAll();
	public int count();
	public MemberBean selectById(String id);
	public List<MemberBean> selectByName(String name);
	public int update(MemberBean member);
	public int delete(String id);
}
