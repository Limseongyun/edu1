package com.example.demo.mvc.service;

import com.example.demo.mvc.model.dto2.MemJoinDto;
import com.example.demo.mvc.model.entity3.Member;

public interface MemberSvc {
	//토큰발급
	String token(String id, String pw);
	
	//가입
	Member userjoin(MemJoinDto joinDto);
	Member sellerjoin(MemJoinDto joinDto);
	
	//탈퇴
	Member resign(String sn);
	
	//휴면
	Member dormancy(Member member);
}
