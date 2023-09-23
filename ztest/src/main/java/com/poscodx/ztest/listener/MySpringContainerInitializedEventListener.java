package com.poscodx.ztest.listener;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.poscodx.ztest.service.HelloService;
import com.poscodx.ztest.vo.SiteVo;

@Component
public class MySpringContainerInitializedEventListener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private HelloService helloSerivce;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() != null) {
			System.out.println("SpringContext Refreshed [sub]");
			ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) event.getApplicationContext();
			
			SiteVo myVo = helloSerivce.getSite();
			applicationContext.getBeanFactory().registerSingleton("site", myVo);
		}else {
			System.out.println("SpringContext Refreshed [root]");
		}
	}

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
