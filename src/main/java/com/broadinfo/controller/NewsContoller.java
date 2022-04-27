package com.broadinfo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.broadinfo.controller.dto.NewsDescriptionDto;
import com.broadinfo.service.NewsService;

@Controller
public class NewsContoller {

	@Autowired
	private NewsService newsService;

	@GetMapping("/newspage")
	public String newUpload( HttpSession session) {

//		model.addAttribute("news", new NewsDescription());

		return "newsupload";
	}

	@PostMapping("/nupload")
	public String getNupload(@ModelAttribute NewsDescriptionDto news , Model model , HttpSession session) {

		newsService.save(news);

		model.addAttribute("dispmsg", "news saved");

		return "newsupload";

	}
}
