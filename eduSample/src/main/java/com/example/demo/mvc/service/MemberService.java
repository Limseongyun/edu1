package com.example.demo.mvc.service;

import org.springframework.stereotype.Service;

import com.example.demo.mvc.model.dto2.MemJoinDto;
import com.example.demo.mvc.model.entity3.Member;

/*
 * 사용자 구분에 상관없이 Id는 유일해야 한다.
 */
@Service
public class MemberService implements MemberSvc{

	@Override
	public String token(String id, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member userjoin(MemJoinDto joinDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member sellerjoin(MemJoinDto joinDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member resign(String sn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member dormancy(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

}
