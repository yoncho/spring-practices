package com.poscodx.hellospring.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}

	@RequestMapping("/hello2")
	public String hello2(String name, int no) {
		System.out.println(name);
		System.out.println(no);
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello3(String n) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		mav.addObject("name", n);
		
		return mav;
	}
	
	//강사님 추천 방식
	@RequestMapping("/hello4")
	public String hello4(String n, Model model) {
		model.addAttribute("name", n);
		return "/WEB-INF/views/hello3.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/hello5")
	public String hello5() {
		//기본 message Converter : stringhttpmessageconverter (utf-8 x.)
		return "<h5> hell5o spri5ng</h5>";
	}

	@RequestMapping("/hello6")
	public String hello6() {
		//기본 message Converter : stringhttpmessageconverter (utf-8 x.)
		return "redirect:/hello";
	}
	
	@RequestMapping("/hello7")
	public void hello7(HttpServletRequest request, HttpServletRequest response, Writer out) 
		throws IOException{
		//다 줌..... servlet에서 다준다....
		// 하지만 이렇게 작성하는건 바보짓이고... 의미가 없다.. spring과 servlet 자체를 쓰는 의미가 없어진다...!!
		
		out.write("name:" + request.getParameter("n")) ;
	}
}
