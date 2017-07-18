package com.hanbit.gms.constant;

public class SQL {
	public static final String MEMBER_INSERT=String.format("INSERT INTO %s VALUES(?,?,?,?,SYSDATE)",Database.TABLE_MEMBER);
	public static final String MEMBER_LIST=String.format("SELECT * FROM %s", Database.TABLE_MEMBER);
	public static final String MEMBER_FINDBYNAME=String.format("SELECT * FROM %s WHERE %s=?", Database.TABLE_MEMBER,Database.MEMBER_NAME);
	public static final String MEMBER_FINDBYID=String.format("SELECT * FROM %s WHERE %s=?", Database.TABLE_MEMBER,Database.MEMBER_ID);
	public static final String MEMBER_COUNT=String.format("SELECT COUNT(*) AS COUNT FROM %s",Database.TABLE_MEMBER);
	public static final String MEMBER_UPDATE=String.format("UPDATE %s SET %s=?,%s=? WHERE %s=?",Database.TABLE_MEMBER,Database.MEMBER_NAME,Database.MEMBER_PASSWORD,Database.MEMBER_ID);
	public static final String MEMBER_DELETE=String.format("DELETE %s WHERE %s=?",Database.TABLE_MEMBER,Database.MEMBER_ID);
	
	public static final String ARTICLE_INSERT=String.format("INSERT INTO %s VALUES(articles_seq.nextval,?,?,?,?,SYSDATE)",Database.TABLE_ARTICLE);
	public static final String ARTICLE_LIST=String.format("SELECT * FROM %s", Database.TABLE_ARTICLE);
	public static final String ARTICLE_FINDBYID=String.format("SELECT * FROM %s WHERE %s=?", Database.TABLE_ARTICLE,Database.ARTICLE_ID);
	public static final String ARTICLE_FINDBYSEQ=String.format("SELECT * FROM %s WHERE %s=?", Database.TABLE_ARTICLE,Database.ARTICLE_SEQ);
	public static final String ARTICLE_COUNT=String.format("SELECT COUNT(*) AS COUNT FROM %s",Database.TABLE_ARTICLE);
	public static final String ARTICLE_UPDATE=String.format(
	"UPDATE %s SET %s=?,%s=? WHERE %s=?",Database.TABLE_ARTICLE,Database.ARTICLE_TITLE,Database.ARTICLE_CONTENT,Database.ARTICLE_SEQ);
	public static final String ARTICLE_DELETE=String.format("DELETE %s WHERE %s=?",Database.TABLE_ARTICLE,Database.ARTICLE_SEQ);

}
