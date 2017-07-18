package com.hanbit.gms.domain;

import java.io.Serializable;

public class ArticleBean implements Serializable{
	private static final long serialVersionUID=1L;
	private int articleSeq,hitcount;
	private String id,title,content,regdate;

	public int getArticleSeq() {
		return articleSeq;
	}


	public void setArticleSeq(int articleSeq) {
		this.articleSeq = articleSeq;
	}


	public int getHitcount() {
		return hitcount;
	}


	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getRegdate() {
		return regdate;
	}


	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String toString(){
		return String.format("글번호 : %d / 아이디 : %s / 제목 : %s / 내용 : %s / 조회수 : %d / 날짜 : %s\n", 
				articleSeq,id,title,content,hitcount,regdate);
	}
}
