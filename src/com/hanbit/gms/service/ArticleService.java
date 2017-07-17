package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.domain.ArticleBean;

public interface ArticleService {
	public String write(ArticleBean article);
	public List<ArticleBean> getArticles();
	public List<ArticleBean> findById(String id);
	public ArticleBean findBySeq(String seq);
	public String modify(ArticleBean article);
	public String remove(String seq);
	public int count();
}
