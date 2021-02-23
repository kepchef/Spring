package kr.co.ch02.sub3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


/*
 * ��¥ : 2021/02/08
 * �̸� : ��ö��
 * ���� : DI ������̼��� �̿��� Ioc����
 */
public class IocTest3 {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		Tv lgTv3 = (Tv) ctx.getBean("lgTv3");
		Tv smTv3 = (Tv) ctx.getBean("smTv3");
		
		lgTv3.power();
		lgTv3.chUp();
		lgTv3.soundUp();
		
		smTv3.power();
		smTv3.chUp();
		smTv3.soundUp();
	}	
}
