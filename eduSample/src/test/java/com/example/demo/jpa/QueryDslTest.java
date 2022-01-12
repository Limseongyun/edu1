package com.example.demo.jpa;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.mvc.model.entity.User;
import com.example.demo.mvc.repos.UserRepo;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class QueryDslTest {
	@Autowired EntityManager em;
	@Autowired UserRepo ur;
	
	
	@Test
	public void test() {
		User u = ur.findByUserId("admin");
		log.debug("tesT{}",u);
		JPAQuery<User> query = new JPAQuery<>(em);
	
	}
}
