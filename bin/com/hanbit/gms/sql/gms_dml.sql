-- String id,pw,ssn,name,regdate;
SELECT * from MEMBER;
INSERT INTO MEMBER(id,name,password,ssn,regdate)
VALUES('JOJO','조조','1','570619-1336491',SYSDATE);
SELECT COUNT(*) AS COUNT FROM MEMBER;
SELECT * from BOARD;
INSERT INTO BOARD(article_seq,id,title,content,hitcount,regdate) VALUES(articles_seq.nextval,'DANNY','날씨가 좋다',
'무한한 가슴이 기쁘며, 힘있다. 일월과 피고, 발휘하기 없으면, ? 풀이 얼마나 모래뿐일 천고에 인간에 찾아 석가는 예가 때문이다. 방황하였으며, 이상 곧 만천하의 살 이것이다. 것은 피에 우리 이것이야말로 가장 가치를 이는 과실이 그리하였는가?',57,SYSDATE);