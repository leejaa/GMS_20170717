package com.hanbit.gms.dao;

import java.util.List;

import com.hanbit.gms.domain.MemberBean;

public interface MemberDao {
	public String insert(MemberBean member);
	public List<MemberBean> selectAll();
	public String count();
	public MemberBean selectById(String id);
	public List<MemberBean> selectByName(String name);
	public String update(MemberBean member);
	public String delete(String id);
}
