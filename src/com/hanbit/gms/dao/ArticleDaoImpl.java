package com.hanbit.gms.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constant.Database;
import com.hanbit.gms.domain.ArticleBean;

public class ArticleDaoImpl implements ArticleDao{
List<ArticleBean> articles;
ArticleBean article;
	@Override
	public int insert(ArticleBean article) {
		int result=0;
		try {
			Class.forName(Database.DRIVER);
			Connection conn=DriverManager.getConnection(Database.URL,Database.USERID,Database.PASSWORD);
			Statement stmt=conn.createStatement();
			String sql=String.format("INSERT INTO Board VALUES (articles_seq.nextval,'%s','%s','%s',%d,SYSDATE)",
					article.getId(),article.getTitle(),article.getContent(),article.getHitcount()
					);
			result=stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ArticleBean> selectAll() {
		articles=new ArrayList<>();
		
		try {
			Class.forName(Database.DRIVER);
			Connection conn=DriverManager.getConnection(Database.URL,Database.USERID,Database.PASSWORD);
			Statement stmt=conn.createStatement();
			String sql="SELECT * FROM Board";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				article=new ArticleBean();
				article.setArticleSeq(rs.getInt("article_seq"));
				article.setId(rs.getString("id"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				article.setHitcount(rs.getInt("hitcount"));
				article.setRegdate(rs.getString("regdate"));
				articles.add(article);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<ArticleBean> selectById(String id) {
		articles=new ArrayList<>();
		
		try {
			Class.forName(Database.DRIVER);
			Connection conn=DriverManager.getConnection(Database.URL,Database.USERID,Database.PASSWORD);
			Statement stmt=conn.createStatement();
			String sql=String.format("SELECT * FROM Board WHERE ID='%s'",id);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				article=new ArticleBean();
				article.setArticleSeq(rs.getInt("article_seq"));
				article.setId(rs.getString("id"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				article.setHitcount(rs.getInt("hitcount"));
				article.setRegdate(rs.getString("regdate"));
				articles.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public ArticleBean selectBySeq(String seq) {
		article=new ArticleBean();
		try {
			Class.forName(Database.DRIVER);
			Connection conn=DriverManager.getConnection(Database.URL,Database.USERID,Database.PASSWORD);
			Statement stmt=conn.createStatement();
			String sql=String.format("SELECT * FROM Board WHERE article_seq=%d",Integer.parseInt(seq));
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				article.setArticleSeq(rs.getInt("article_seq"));
				article.setId(rs.getString("id"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				article.setHitcount(rs.getInt("hitcount"));
				article.setRegdate(rs.getString("regdate"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public int update(ArticleBean article) {
		int result=0;
		try {
			Class.forName(Database.DRIVER);
			Connection conn=DriverManager.getConnection(Database.URL,Database.USERID,Database.PASSWORD);
			Statement stmt=conn.createStatement();
			String sql=String.format(
				"UPDATE Board SET title='%s', content='%s' WHERE article_seq=%d",article.getTitle(),article.getContent(),article.getArticleSeq());
			result=stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(String seq) {
		int result=0;
		try {
			Class.forName(Database.DRIVER);
			Connection conn=DriverManager.getConnection(Database.URL,Database.USERID,Database.PASSWORD);
			Statement stmt=conn.createStatement();
			String sql=String.format("DELETE Board WHERE article_seq=%d",Integer.parseInt(seq));
			result=stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int count() {
		int result=0;
		try {
			Class.forName(Database.DRIVER);
			Connection conn=DriverManager.getConnection(Database.URL,Database.USERID,Database.PASSWORD);
			Statement stmt=conn.createStatement();
			String sql="SELECT COUNT(*) AS COUNT FROM Board";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				result=rs.getInt("count");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
