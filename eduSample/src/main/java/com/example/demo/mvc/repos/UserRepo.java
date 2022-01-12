package com.example.demo.mvc.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.mvc.model.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	User findByUserId(String userId);
}
