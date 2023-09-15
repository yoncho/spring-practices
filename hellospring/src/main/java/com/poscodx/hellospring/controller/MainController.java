package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@ResponseBody // 함수 return 자체가 response가 되는 형태...?
	@RequestMapping({"/", "/main", "/board/write"}) //기본 값, multi url
	public String main() {
		return "MainController.main";
	}
	
}
