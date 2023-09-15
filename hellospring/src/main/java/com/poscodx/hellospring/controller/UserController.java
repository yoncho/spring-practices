package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping Class & Method Mapping
 * 강사님 강추!! mysite는 이 방식...!!
 * */
@RequestMapping("/user")
@Controller
public class UserController {

	@RequestMapping(value="/join", method=RequestMethod.GET) // value=가 기본이고 생략되어있음.
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST) // value=가 기본이고 생략되어있음.
	public String join(UserVo userVo) { //userVo의 field값과 request의 parameter name을 비교해서 동일한게 있으면 UserVo의 set함수를 자동 호출해서 값을 넣고 객체를 반환해준다.
		System.out.println("UserController.join():UserDao.insert("+ userVo+")");
		return "redirect:/";
	}
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {
		/*
		 * 만약 n이라는 이름의 url parameter가 없을 경우 400 bad request error가 난다.
		 * 
		 * 
		 * */
		return "UserController.update("+ name +")";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required = true,defaultValue="null-name") String name) {
		return "UserController.update("+ name +")";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public String list(@RequestParam(value="p", required = true,defaultValue="1") int pageNo) {
		return "UserController.list("+ pageNo +")";
	}
	
}
