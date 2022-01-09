package com.example.demo.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.UserRole;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long>{

}
