package com.poscodx.ztest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poscodx.ztest.vo.SiteVo;

@Controller
public class HelloController {
	@Autowired
	private ApplicationContext applicationContext;
	
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		SiteVo site = (SiteVo)applicationContext.getBean("site");
		model.addAttribute("value", site.getTitle());
		return "/WEB-INF/views/hello.jsp";
	}
	
	//강사님 추천 방식
	@RequestMapping("/hello4")
	public String hello4(String n, Model model) {
		model.addAttribute("name", n);
		
		return "/WEB-INF/views/hello3.jsp";
	}

}
