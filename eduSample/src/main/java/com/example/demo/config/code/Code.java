package com.example.demo.config.code;

public interface Code {
	String ANNONYMOUSE_USER = "anonymousUser";
	
	//공통코드 codeid명
	String CID_USER_STTUS = "user_sttus_code";
	String CID_USER_TY = "user_ty_code";
	String CID_ROLE_TY = "role_ty_code";
	
	//유저 타입
	String USER_TY_MNG = "01";
	String USER_TY_MNG_NM = "관리자";
	String USER_TY_USR = "02";
	String USER_TY_USR_NM = "사용자";
	
	//유저상태
	String USER_STTUS_OK = "01";
	String USER_STTUS_OK_NM = "정상";
	String USER_STTUS_RESIGN = "99";
	String USER_STTUS_RESIGN_NM = "탈퇴";
	
	//권한 종류
	String ROLE_TY_ADM = "01";
	String ROLE_TY_ADM_NM = "어드민";
	String ROLE_TY_MNG = "02";
	String ROLE_TY_MNG_NM = "관리자";
	String ROLE_TY_USR = "03";
	String ROLE_TY_USR_NM = "사용자";
}
