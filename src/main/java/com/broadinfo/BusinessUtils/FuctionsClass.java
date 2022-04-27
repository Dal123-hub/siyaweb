package com.broadinfo.BusinessUtils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.broadinfo.usermodel.NewsDescription;

@Component
public class FuctionsClass {

	public List<NewsDescription> reverseList(List<NewsDescription> nList) {
		List<NewsDescription> newlist = new ArrayList<NewsDescription>();

		for(int i = nList.size()-1; i>=0; i--) {
			newlist.add(nList.get(i));
		}


		return newlist;
	}

	 public String setMessage() {

			return "Uesr already exists";
		}
}