package com.broadinfo.service;

import com.broadinfo.controller.dto.NewsDescriptionDto;
import com.broadinfo.usermodel.NewsDescription;

public interface NewsService {

	NewsDescription save(NewsDescriptionDto news);
}
