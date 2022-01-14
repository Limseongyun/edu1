package com.example.demo.mvc.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.mvc.model.entity3.Member;
@Repository
public interface MemberRepo extends JpaRepository<Member, Long>{
	Member findByMembId(String membId);
}
