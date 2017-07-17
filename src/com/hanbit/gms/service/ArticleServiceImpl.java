package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.dao.ArticleDao;
import com.hanbit.gms.dao.ArticleDaoImpl;
import com.hanbit.gms.domain.ArticleBean;

public class ArticleServiceImpl implements ArticleService{
	ArticleDao dao=new ArticleDaoImpl();
	@Override
	public String write(ArticleBean article) {
		return dao.insert(article)==0?"등록실패":"등록성공";
	}

	@Override
	public List<ArticleBean> getArticles() {
		return dao.selectAll();
	}

	@Override
	public List<ArticleBean> findById(String id) {
		return dao.selectById(id);
	}

	@Override
	public ArticleBean findBySeq(String seq) {
		return dao.selectBySeq(seq);
	}

	@Override
	public String modify(ArticleBean article) {
		if(article.getTitle().equals("")){
			article.setTitle(findBySeq(String.valueOf(article.getArticleSeq())).getTitle());
		}
		if(article.getContent().equals("")){
			article.setContent(findBySeq(String.valueOf(article.getArticleSeq())).getContent());
		}
		return dao.update(article)==0?"글수정실패":"글수정성공";
	}

	@Override
	public String remove(String seq) {
		return dao.delete(seq)==0?"삭제실패":"삭제성공";
	}

	@Override
	public int count() {
		return dao.count();
	}

}
