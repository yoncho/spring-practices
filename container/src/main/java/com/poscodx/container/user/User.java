package com.poscodx.container.user;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class User {
	private Long no = 1L;
	private String name = "dooly";
	private Friend friend = null;
	private List<String> friends; 
	
	public User() {
	 //applicationContext02에서 기본 생성자로 bean을 생성했기 때문에... 있어야함..!!	
	}
	
	public User(String name) {
		this.name=name;
	}
	
	public User(Long no, String name) {
		this.no=no;
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no=no;
	}
	public void setFriend(Friend friend) {
		this.friend=friend;
	}
	public void setFriends(List<String> friends) {
		this.friends=friends;
	}
	
	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", friend=" + friend + ", friends=" + friends + "]";
	}
}
