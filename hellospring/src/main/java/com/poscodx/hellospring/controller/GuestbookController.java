package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/*
 * @RequestMapping 클래스 단독 매핑
 * Spring MVC 4.x에서만 지원!
 * 
 * */
//@Controller
@RequestMapping("/guestbook/*") // class 하위 method들을 참조할 수 있게 /*를 붙여줌..!! 
public class GuestbookController {

	@ResponseBody
	@RequestMapping //붙여줘야함...! 단 url을 안주고 method 이름으로 대체..
	public String list() {
		return "list";
	}
	
	@ResponseBody
	@RequestMapping
	public String delete() {
		return "delete";
	}
}
