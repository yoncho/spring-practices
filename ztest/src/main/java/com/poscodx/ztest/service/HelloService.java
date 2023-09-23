package com.poscodx.ztest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.poscodx.ztest.vo.SiteVo;

@Service
public class HelloService {
	@Autowired
	private ApplicationContext applicationContext;
	
	public SiteVo doSomething() {
        // VO 객체 가져오기
        SiteVo site = new SiteVo();
        site.setTitle("TEST ");
        return site;
    }
	
	public SiteVo getSite() {
		 // VO 객체 가져오기
        SiteVo site = new SiteVo();
        site.setTitle("my dynamic site");
        return site;
	}
}
