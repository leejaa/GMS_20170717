package com.hanbit.gms.service;

import java.util.List;
import com.hanbit.gms.dao.ArticleDaoImpl;
import com.hanbit.gms.domain.ArticleBean;

public class ArticleServiceImpl implements ArticleService{
	public static ArticleServiceImpl getInstance(){
		return new ArticleServiceImpl();
	}
	public String write(ArticleBean article) {
		return ArticleDaoImpl.getInstance().insert(article)==0?"존재하지 않는 아이디입니다":"등록성공";
	}

	@Override
	public List<ArticleBean> getArticles() {
		return ArticleDaoImpl.getInstance().selectAll();
	}

	@Override
	public List<ArticleBean> findById(String id) {
		return ArticleDaoImpl.getInstance().selectById(id);
	}

	@Override
	public ArticleBean findBySeq(String seq) {
		return ArticleDaoImpl.getInstance().selectBySeq(seq);
	}

	@Override
	public String modify(ArticleBean article) {
		return ArticleDaoImpl.getInstance().update(article)==0?"수정하고자하는 글번호가 존재하지 않습니다":"글수정성공";
	}

	@Override
	public String remove(String seq) {
		return ArticleDaoImpl.getInstance().delete(seq)==0?"글번호가 존재하지 않습니다":"삭제성공";
	}

	@Override
	public int count() {
		return ArticleDaoImpl.getInstance().count();
	}

}
