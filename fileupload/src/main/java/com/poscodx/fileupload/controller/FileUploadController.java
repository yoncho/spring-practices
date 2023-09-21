package com.poscodx.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poscodx.fileupload.service.FileUploadService;

@Controller
public class FileUploadController {
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(
			@RequestParam("email") String email,
			@RequestParam("file") MultipartFile multipartFile,
			Model model) {
		System.out.println("email : " + email);
		System.out.println(multipartFile.getOriginalFilename());
		
		/* 이미지 파일 업로드 처리 */
		String url = fileUploadService.restore(multipartFile);
		System.out.println(url);
		model.addAttribute("url", url);
		return "result";
	}
}
