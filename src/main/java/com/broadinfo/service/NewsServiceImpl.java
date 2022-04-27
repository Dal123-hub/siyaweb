package com.broadinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadinfo.controller.dto.NewsDescriptionDto;
import com.broadinfo.usermodel.NewsDescription;
import com.broadinfo.userrepo.NewsRepo;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsRepo newsRepo;

	@Override
	public NewsDescription save(NewsDescriptionDto news) {

		NewsDescription newsDetails = new NewsDescription(news.getHeading(), news.getDate(), news.getSubject());

		return newsRepo.save(newsDetails);
	}

}
