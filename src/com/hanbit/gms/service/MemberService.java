package com.hanbit.gms.service;
import java.util.List;

import com.hanbit.gms.domain.MemberBean;

public interface MemberService {
	public String addMember(MemberBean member);
	public List<MemberBean> getMembers();
	public int countMembers();
	public MemberBean memberById(String id);
	public List<MemberBean> getMemberByName(String name);
	public String modify(MemberBean member);
	public String remove(String id);
}
