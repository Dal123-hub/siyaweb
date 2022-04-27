package com.broadinfo.userrepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.broadinfo.usermodel.UserInfo;

@SpringBootTest
public class userRepoTest {

	@Autowired
	private UserRepo repo;

	@Test
	void find() {

		UserInfo result = repo.findByUnameAndUpass("admin","admin123");

		//assertThat(result).isNotNull();

	}
}
