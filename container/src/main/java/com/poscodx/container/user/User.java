package com.poscodx.container.user;

import org.springframework.stereotype.Component;

@Component
public class User {
	private Long no;
	private String name = "dooly";
	
	public String getName() {
		return name;
	}
}
