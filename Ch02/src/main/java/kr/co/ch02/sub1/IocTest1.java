package kr.co.ch02.sub1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜 : 2021/02/08
 * 이름 : 김철학
 * 내용 : 스프링 Ioc 실습하기
 */
public class IocTest1 {

	public static void main(String[] args) {
		
		// Ioc 적용하지 않은 객체생성
		Tv ltv = new LgTv();
		ltv.power();
		ltv.chUp();
		ltv.chDown();
		
		Tv stv = new SamsungTv();
		stv.power();
		stv.chUp();
		stv.chDown();
		
		// Ioc를 적용한 객체 주입		
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		Tv lgTv = (Tv) ctx.getBean("lgTv");
		Tv smTv = (Tv) ctx.getBean("smTv");
		
		lgTv.power();
		lgTv.chUp();
		lgTv.chDown();
		
		smTv.power();
		smTv.chUp();
		smTv.chDown();
		
	}	
}





