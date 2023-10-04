package com.poscodx.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.poscodx.container.user.User;

public class XmlConfigTest {

	public static void main(String[] args) {
		// 1. XML Auto Configuration (Annotation Configuration)
		// testApplicationContext01();

		// 2. XML Bean Configuration (Explicity Configuration)
		testApplicationContext02();

		// 3. XML Auto Configuration (Annotation Scanning)
		// testBeanFactory01(); // 자동 설정..

		// 4. XML Bean Configuration (Explicity Configuration)
		// testBeanFactory02();

	}

	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/poscodx/container/user/applicationContext02.xml");
		User user = null;
		// type으로 빈 가져오기
		// 같은 type의 빈이 2개 이상 있으면 Type으로 가져오기는 실패한다...
		user = ac.getBean("user2", User.class); // id, class
		System.out.println(user);

		// 파라미터 2개인 생성자로 생성된 빈 가져오기 1
		user = ac.getBean("user3", User.class); // id, class
		System.out.println(user);

		// 파라미터 2개인 생성자로 생성된 빈 가져오기 2
		user = ac.getBean("user4", User.class); // id, class
		System.out.println(user);

		// setter를 사용한 빈 가져오기 1
		user = ac.getBean("user5", User.class); // id, class
		System.out.println(user);

		// setter를 사용한 빈 가져오기 2 : DI
		user = ac.getBean("user6", User.class); // id, class
		System.out.println(user);

		// setter를 사용한 빈 가져오기 3 : Collection Property
		user = ac.getBean("user7", User.class); // id, class
		System.out.println(user);

		// id로 빈 가져오기...!! 명시적으로 할 때는 bean 등록할때 id도 명시해줘야함...!!
		user = (User) ac.getBean("user");
		System.out.println(user.getName());

		// name으로 빈 가져오기
		user = (User) ac.getBean("usr");
		System.out.println(user.getName());
	}

	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/poscodx/container/user/applicationContext01.xml");
		User user = null;
		user = ac.getBean(User.class);
		System.out.println(user.getName());

		// Annotation Scan(auto configuration) 에서는 Bean id가 자동으로 부여된다...!!
		user = (User) ac.getBean("user");
		System.out.println(user.getName());
	}

	private static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(
				new ClassPathResource("com/poscodx/container/user/applicationContext02.xml"));
		User user = (User) bf.getBean(User.class);
		System.out.println(user.getName());
	}

	private static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(
				new ClassPathResource("com/poscodx/container/user/applicationContext01.xml"));
		User user = (User) bf.getBean(User.class);
		System.out.println(user.getName());
	}
}
