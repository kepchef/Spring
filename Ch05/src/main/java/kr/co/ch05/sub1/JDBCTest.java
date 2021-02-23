package kr.co.ch05.sub1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜 : 2021/02/10
 * 이름 : 김철학
 * 내용 : 스프링 JDBC 실습하기
 */
public class JDBCTest {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		UserDao dao = (UserDao) ctx.getBean("userDao");
		
		dao.insertUser();
		dao.updateUser();
		dao.deleteUser();
		List<UserVo> users = dao.selectUser();
		
		for(UserVo user : users) {
			System.out.println("---------------------");
			System.out.println("아이디 : "+user.getUid());
			System.out.println("이 름 : "+user.getName());
			System.out.println("휴대폰 : "+user.getHp());
			System.out.println("나 이 : "+user.getAge());
		}
		
		
		System.out.println("프로그램 종료...");
	}
}
















