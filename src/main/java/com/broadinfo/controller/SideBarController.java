package com.broadinfo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.broadinfo.usermodel.NewsDescription;
import com.broadinfo.userrepo.NewsRepo;

@Controller
public class SideBarController {

	@Autowired
	private NewsRepo newsRepo;

	List<NewsDescription> newsData = new ArrayList<NewsDescription>();

	@PostConstruct
	public void init() {
		newsData = newsRepo.findAll();
	}

	@GetMapping("/studentvisa")
	public String getStudentvisa(Model model) {

		model.addAttribute("newsslide", newsData.get(newsData.size()-1));
		return "studentvisa";
	}

	@GetMapping("/classes")
	public String getClasses( Model model) {

		model.addAttribute("newsslide", newsData.get(newsData.size()-1));

		return "classes";
	}

	@GetMapping("/courses")
	public String getCourses(Model model) {

		model.addAttribute("newsslide", newsData.get(newsData.size()-1));
		return "courses";
	}

	@GetMapping("/visaprocess")
	public String getVisaprocess(Model model) {
		model.addAttribute("newsslide", newsData.get(newsData.size()-1));
		return "visaprocess";
	}

	@GetMapping("/depature")
	public String getDepature(Model model) {
		model.addAttribute("newsslide", newsData.get(newsData.size()-1));
		return "depature";
	}
}
