package com.broadinfo.service;

import com.broadinfo.controller.dto.UserInfoDto;
import com.broadinfo.usermodel.UserInfo;

public interface UserService {

	UserInfo save(UserInfoDto userInfo);

	UserInfo searchUser(String name , String pass);

}
