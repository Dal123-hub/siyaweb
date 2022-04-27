package com.broadinfo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.broadinfo.BusinessUtils.FuctionsClass;
import com.broadinfo.usermodel.NewsDescription;
import com.broadinfo.userrepo.NewsRepo;

@Controller
public class LinkController {

	@Autowired
	private NewsRepo newsRepo;

	@Autowired
	private FuctionsClass fc;

	List<NewsDescription> newsData = new ArrayList<NewsDescription>();

	@PostConstruct
	public void init() {
		newsData = newsRepo.findAll();
		if(newsData.size() == 0) {
			NewsDescription nd = new NewsDescription("LatestNews","2022-04-24","testTest");
			newsData.add(nd);
		}
	}


	@GetMapping("/")
	public String getIndex(Model model) {

		String[] indexPage = new File("src/main/resources/static/assets/").list();

		model.addAttribute("indexPageImage", indexPage);

		model.addAttribute("newsslide", newsData.get(newsData.size()-1));



		return "index";
	}

	@GetMapping("/about")
	public String getAbout(Model model) {
		model.addAttribute("newsslide", newsData.get(newsData.size()-1));
		return "about";
	}

	@GetMapping("/gallery")
	public String getGallery(Model model) {

		String[] image = new File("src/main/resources/static/assets/").list();

		model.addAttribute("imageList", image);

		return "gallery";
	}

	@GetMapping("/contact")
	public String getContact(Model model) {
		model.addAttribute("newsslide", newsData.get(newsData.size()-1));
		return "contact";
	}

	@GetMapping("/news")
	public String getNews(Model model) {

	List<NewsDescription> newlist =fc.reverseList(newsData);

	model.addAttribute("newsList", newlist);

	model.addAttribute("newsslide", newsData.get(newsData.size()-1));

		return "news";
	}

	@GetMapping("/services")
	public String getServices(Model model) {

		model.addAttribute("newsslide", newsData.get(newsData.size()-1));

		return "services";
	}

}


