package com.broadinfo.userrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.broadinfo.usermodel.UserInfo;

@Repository
public interface UserRepo extends JpaRepository<UserInfo, Integer> {

	UserInfo findByUnameAndUpass(String name, String pass);
}
