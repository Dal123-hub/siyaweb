package com.broadinfo.userrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.broadinfo.usermodel.NewsDescription;

@Repository
public interface NewsRepo extends JpaRepository<NewsDescription, Integer> {


}
