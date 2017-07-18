package com.hanbit.gms.constroller;

import javax.swing.JOptionPane;

import com.hanbit.gms.constant.Butt;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.service.ArticleService;
import com.hanbit.gms.service.ArticleServiceImpl;

public class BoardController {
public static void main(String[] args) {
	ArticleBean article=null;
	Butt[] buttons={Butt.EXIT,Butt.ADD,Butt.LIST,Butt.FIND_ID,Butt.COUNT,Butt.UPDATE,Butt.DEL,Butt.FIND_SEQ};
	do{
		flag:
			switch ((Butt)JOptionPane.showInputDialog(
					null,//frame
					"BOARD ADMIN",//frame title
					"SELECT MENU",//order
					JOptionPane.QUESTION_MESSAGE,//type
					null,//icon
					buttons,//Array of choices
					buttons[1]//default
					)) {
			case EXIT:
				return;
			case ADD:
				article=new ArticleBean();
				article.setId(JOptionPane.showInputDialog("아이디를 입력해주세요"));
				article.setTitle(JOptionPane.showInputDialog("글제목을 입력해주세요"));
				article.setContent(JOptionPane.showInputDialog("글내용을 입력해주세요"));
				article.setArticleSeq(0);
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().write(article));
				break flag;
			case UPDATE:
				article=new ArticleBean();
				article.setArticleSeq(Integer.parseInt(JOptionPane.showInputDialog("수정하고자하는 글번호를 입력해주세요")));
				article.setTitle(JOptionPane.showInputDialog("수정하고자 하는 글제목을 입력해주세요"));
				article.setContent(JOptionPane.showInputDialog("수정하고자 하는 글내용을 입력해주세요"));
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().modify(article));
				break flag;
			case DEL:
				JOptionPane.showMessageDialog(null,ArticleServiceImpl.getInstance().remove(JOptionPane.showInputDialog("삭제하고자 하는 글번호를 입력해주세요")));
				break flag;
			case LIST:
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().getArticles());
				break flag;
			case COUNT:
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().count());
				break flag;
			case FIND_ID:
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().findById(JOptionPane.showInputDialog("찾고자 하는 글의 아이디를 입력해주세요")));
				break flag;
			case FIND_SEQ:
				article=new ArticleBean();
				String message="";
				article=ArticleServiceImpl.getInstance().findBySeq(JOptionPane.showInputDialog("찾고자 하는 글 번호를 입력해주세요"));
				if(article.getArticleSeq()==0){
					message+="조회하신 글번호가 없습니다";
				}else{
					message+=article.toString();
				}
				
				JOptionPane.showMessageDialog(null,message);
				break flag;
			}
		}while(true);
	}
}
