package com.poscodx.container.user;

import org.springframework.stereotype.Component;

@Component
public class Friend {
	private String name;
	
	public Friend(String name) {
		this.name=name;
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + "]";
	}
}
