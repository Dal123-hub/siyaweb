package com.broadinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.broadinfo.controller.dto.UserInfoDto;
import com.broadinfo.usermodel.UserInfo;
import com.broadinfo.userrepo.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserInfo save(UserInfoDto userInfo) {

		UserInfo user = new UserInfo(userInfo.getUname(), userInfo.getUpass(), userInfo.getRpass());

		user.setUpass(DigestUtils.md5DigestAsHex(user.getUpass().getBytes()));

		user.setRpass(DigestUtils.md5DigestAsHex(user.getRpass().getBytes()));

		UserInfo u = searchUser(user.getUname(), user.getUpass());

		return userRepo.save(user);
	}


	@Override
	public UserInfo searchUser(String name, String pass) {

	String pass1 = 	DigestUtils.md5DigestAsHex(pass.getBytes());

		return userRepo.findByUnameAndUpass(name,pass1);
	}

}
