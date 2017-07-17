package com.hanbit.gms.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constant.Database;
import com.hanbit.gms.domain.MemberBean;
public class MemberDaoImpl implements MemberDao{
	public MemberDaoImpl() {
		try {
			Class.forName(Database.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert(MemberBean member) {
		int rs=0;
		try {
			rs=DriverManager
					.getConnection(Database.URL,Database.USERID,Database.PASSWORD)
					.createStatement()
					.executeUpdate(
					String.format("INSERT INTO Member VALUES('%s','%s','%s','%s',SYSDATE)",member.getId(),member.getName(),member.getPw(),member.getSsn()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean> list=new ArrayList<>();
		MemberBean member=null;
		try {
			ResultSet rs=DriverManager
					.getConnection(Database.URL,Database.USERID,Database.PASSWORD)
					.createStatement()
					.executeQuery(
					String.format("SELECT * FROM %s", Database.TABLE_MEMBER));
			while(rs.next()){
				member=new MemberBean();
				member.setId(rs.getString(Database.MEMBER_ID));
				member.setName(rs.getString(Database.MEMBER_NAME));
				member.setPw(rs.getString(Database.MEMBER_PASSWORD));
				member.setRegdate(rs.getString(Database.MEMBER_REGDATE));
				member.setSsn(rs.getString(Database.MEMBER_SSN));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int count() {
		int count=0;
		try {
			ResultSet rs=DriverManager
					.getConnection(Database.URL,Database.USERID,Database.PASSWORD)
					.createStatement()
					.executeQuery(
					String.format("SELECT COUNT(*) AS COUNT FROM %s",Database.TABLE_MEMBER ));
			if(rs.next()){
				count=rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean member=new MemberBean();
		try {
			ResultSet rs=DriverManager.getConnection(Database.URL,Database.USERID,Database.PASSWORD)
					.createStatement()
					.executeQuery(
					String.format("SELECT * FROM %s WHERE %s='%s'",Database.TABLE_MEMBER,Database.MEMBER_ID,id));
			if(rs.next()){
				member.setName(rs.getString(Database.MEMBER_NAME));
				member.setId(rs.getString(Database.MEMBER_ID));
				member.setPw(rs.getString(Database.MEMBER_PASSWORD));
				member.setSsn(rs.getString(Database.MEMBER_SSN));
				member.setRegdate(rs.getString(Database.MEMBER_REGDATE));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		List<MemberBean> list=new ArrayList<>();
		MemberBean member=new MemberBean();
		try {
			ResultSet rs=DriverManager
					.getConnection(Database.URL,Database.USERID,Database.PASSWORD)
					.createStatement()
					.executeQuery(
					String.format("SELECT * FROM %s WHERE %s='%s'", Database.TABLE_MEMBER,Database.MEMBER_NAME,name));
			while(rs.next()){
				member.setId(rs.getString(Database.MEMBER_ID));
				member.setName(rs.getString(Database.MEMBER_NAME));
				member.setPw(rs.getString(Database.MEMBER_PASSWORD));
				member.setSsn(rs.getString(Database.MEMBER_SSN));
				member.setRegdate(rs.getString(Database.MEMBER_REGDATE));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update(MemberBean member) {
		int rs=0;
		try {
			rs=DriverManager
					.getConnection(Database.URL,Database.USERID,Database.PASSWORD)
					.createStatement()
					.executeUpdate(
	String.format("UPDATE %s SET %s='%s',%s='%s',%s='%s' WHERE %s='%s'",
			Database.TABLE_MEMBER,Database.MEMBER_NAME,member.getName(),Database.MEMBER_PASSWORD,member.getPw(),Database.MEMBER_SSN,member.getSsn(),Database.MEMBER_ID,member.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int delete(String id) {
		int rs=0;
		try {
			rs=DriverManager
					.getConnection(Database.URL,Database.USERID,Database.PASSWORD)
					.createStatement()
					.executeUpdate(
					String.format("DELETE %s WHERE %s='%s'",Database.TABLE_MEMBER,Database.MEMBER_ID,id ));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

}
