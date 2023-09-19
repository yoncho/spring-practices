package com.poscodx.guestbook.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.poscodx.guestbook.repository.GuestbookRepository;
import com.poscodx.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@RequestMapping({"/", "/main"})
	public String main(Model model) {
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute("list", list);
		return "main";
	}

	public String add(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String delete(GuestbookVo vo) {
		guestbookRepository.delete(vo.getNo(), vo.getPassword());
		return "redirect:/";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
	}
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(int no, Model model) {
		model.addAttribute("no", no);
		return "delete";
	}
}
