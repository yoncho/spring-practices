package com.poscodx.ztest.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.poscodx.ztest.service.HelloService;
import com.poscodx.ztest.vo.SiteVo;

@Component
public class ZServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// ServletContext가 초기화될 때 실행되는 메서드
		// 원하는 작업을 수행합니다.
		System.out.println("ZServletContextListener가 생성되었습니다.");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		// ServletContext가 소멸될 때 실행되는 메서드
		// 원하는 정리 작업을 수행합니다.
		System.out.println("ZServletContextListener가 소멸되었습니다.");
	}

}
