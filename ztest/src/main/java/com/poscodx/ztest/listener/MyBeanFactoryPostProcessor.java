package com.poscodx.ztest.listener;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import com.poscodx.ztest.service.HelloService;
import com.poscodx.ztest.vo.SiteVo;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// 등록
		System.out.println("동적 빈 생성 중..");
		beanFactory.registerSingleton("site", new HelloService().getSite());

		// 등록 확인
		SiteVo site = (SiteVo) beanFactory.getBean("site");
		if (site != null) {
			System.out.println(site.getTitle());
		}
	}

}
