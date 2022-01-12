package com.example.demo.mvc.model.dto;

import lombok.Data;
import lombok.NonNull;

@Data
@NonNull
public class UserJoinDto{
	private String userNm;
	private String userId;
	private String userPw;
}
