package com.hanbit.gms.constroller;

import javax.swing.JOptionPane;

import com.hanbit.gms.constant.Butt;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.service.MemberService;
import com.hanbit.gms.service.MemberServiceImpl;

public class MemberController {
	public static void main(String[] args) {
		MemberBean member=null;
		MemberService service=new MemberServiceImpl();
		Butt[] buttons={Butt.EXIT,Butt.ADD,Butt.LIST,Butt.FIND_NAME,Butt.FIND_ID,Butt.COUNT,Butt.UPDATE,Butt.DEL};
		do{
			flag:
			switch ((Butt)JOptionPane.showInputDialog(
					null,//frame
					"MEMBER ADMIN",//frame title
					"SELECT MENU",//order
					JOptionPane.QUESTION_MESSAGE,//type
					null,//icon
					buttons,//Array of choices
					buttons[1]//default
					)) {
			case EXIT :
				return;
			case ADD:
				member=new MemberBean();
				String[] foo=JOptionPane.showInputDialog("ID/PW/SSN/NAME").split("/");
				member.setId(foo[0]);
				member.setPw(foo[1]);
				member.setSsn(foo[2]);
				member.setName(foo[3]);
				service.addMember(member);
					JOptionPane.showMessageDialog(null, "회원가입 성공");
				break flag;
			case COUNT:
				JOptionPane.showMessageDialog(null, service.countMembers()+"명");
				break flag;
			case LIST:
				JOptionPane.showMessageDialog(null, service.getMembers());
				break flag;
			case FIND_ID:
				JOptionPane.showMessageDialog(null, service.memberById(JOptionPane.showInputDialog("검색하고자 하는 id를 입력해주세요")));
				break flag;
			case FIND_NAME:
				JOptionPane.showMessageDialog(null, service.getMemberByName(JOptionPane.showInputDialog("검색하고자 하는 이름을 입력해주세요")));
				break flag;
			case UPDATE:
				member=new MemberBean();
				member.setId(JOptionPane.showInputDialog("비번 바꾸려는 아이디를 입력해주세요"));
				member.setName(JOptionPane.showInputDialog("새로운 이름을 입력해주세요"));
				member.setPw(JOptionPane.showInputDialog("새로운 비밀번호를 입력해주세요"));
				member.setSsn(JOptionPane.showInputDialog("새로운 주민번호를 입력해주세요"));
				service.modify(member);
				JOptionPane.showMessageDialog(null, "업데이트완료");
				break flag;
			case DEL:
				service.remove(JOptionPane.showInputDialog("탈퇴하고자 하는 아이디를 입력해주세요"));
				JOptionPane.showMessageDialog(null, "탈퇴완료");
				break flag;
			}
		}while(true);
	}
}
