package com.hanbit.gms.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constant.Database;
import com.hanbit.gms.constant.SQL;
import com.hanbit.gms.constant.Vendor;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.factory.DatabaseFactory;
public class MemberDaoImpl implements MemberDao{
	List<MemberBean> members;
	MemberBean member;
	public static MemberDaoImpl getInstance() {
		return new MemberDaoImpl();
	}
	private MemberDaoImpl() {
	}
	
	@Override
	public String insert(MemberBean member) {
		String result="0";
		try{
		PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERID, Database.PASSWORD).getConnection()
				.prepareStatement(SQL.MEMBER_INSERT);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getName());
		pstmt.setString(3, member.getPw());
		pstmt.setString(4, member.getSsn());
		result=String.valueOf(pstmt.executeUpdate());
		}catch (Exception e) {
		}
		return result;
	}
	@Override
	public List<MemberBean> selectAll() {
		members=new ArrayList<>();
		
		try{
			ResultSet rs=DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERID, Database.PASSWORD).getConnection()
					.prepareStatement(SQL.MEMBER_LIST).executeQuery();
			while(rs.next()){
				member=new MemberBean();
				member.setId(rs.getString(Database.MEMBER_ID));
				member.setName(rs.getString(Database.MEMBER_NAME));
				member.setPw(rs.getString(Database.MEMBER_PASSWORD));
				member.setSsn(rs.getString(Database.MEMBER_SSN));
				member.setRegdate(rs.getString(Database.MEMBER_REGDATE));
				members.add(member);
			}
			
		}catch (Exception e) {
		}
		return members;
	}

	@Override
	public String count() {
		String count="0";
		try{
			count=String.valueOf(DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERID, Database.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_COUNT).executeUpdate());
		}catch (Exception e) {
		}
		return count;
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean member=new MemberBean();
		try {
			PreparedStatement pstmt=DriverManager.getConnection(Database.ORACLE_URL,Database.USERID,Database.PASSWORD)
					.prepareStatement(SQL.MEMBER_FINDBYID);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
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
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERID, Database.PASSWORD).getConnection()
					.prepareStatement(SQL.MEMBER_FINDBYNAME);
			pstmt.setString(1, name);
			ResultSet rs=pstmt.executeQuery();
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
	public String update(MemberBean member) {
		String rs="0";
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERID, Database.PASSWORD).getConnection()
					.prepareStatement(SQL.MEMBER_UPDATE);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getId());
			rs=String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String delete(String id) {
		String rs="0";
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERID, Database.PASSWORD).getConnection()
					.prepareStatement(SQL.MEMBER_DELETE);
			pstmt.setString(1, id);
			rs=String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

}
