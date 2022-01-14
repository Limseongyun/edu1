//package com.example.demo.config;
//
//import javax.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.example.demo.cmm.code.Code;
//import com.example.demo.cmm.utils.EntityUtil;
//import com.example.demo.mvc.model.entity.CmmnCodeDetail;
//import com.example.demo.mvc.model.entity.User;
//import com.example.demo.mvc.model.entity.UserRole;
//import com.example.demo.mvc.repos.CmmnCodeDetailRepo;
//import com.example.demo.mvc.repos.UserRepo;
//import com.example.demo.mvc.repos.UserRoleRepo;
//
//import lombok.extern.slf4j.Slf4j;
//
////@Configuration
//@Slf4j
//@Deprecated
//public class InitializerConfig {
//	@Autowired private PasswordEncoder pe;
//	@Autowired private UserRepo userRepo;
//	@Autowired private UserRoleRepo userRoleRepo;
//	@Autowired private CmmnCodeDetailRepo ccdRepo;
//	@Autowired private EntityUtil eu;
//	
//	@PostConstruct
//	public void postCon() {
//		log.debug("[start]");
//		//ADMIN 이 없으면 초기상태라고 본다.
//		User admin = userRepo.findByUserId("admin");
//		if(admin == null) {
//			log.debug("초기 데이터 인서트");
//			//공통-권한종류
//			ccdRepo.save(genCmmnCode(Code.CID_ROLE_TY, Code.ROLE_TY_ADM, Code.ROLE_TY_ADM_NM));
//			ccdRepo.save(genCmmnCode(Code.CID_ROLE_TY, Code.ROLE_TY_MNG, Code.ROLE_TY_MNG_NM));
//			ccdRepo.save(genCmmnCode(Code.CID_ROLE_TY, Code.ROLE_TY_USR, Code.ROLE_TY_USR_NM));
//			
//			//공통-유저상태코드
//			ccdRepo.save(genCmmnCode(Code.CID_USER_STTUS, Code.USER_STTUS_OK, Code.USER_STTUS_OK_NM));
//			ccdRepo.save(genCmmnCode(Code.CID_USER_STTUS, Code.USER_STTUS_RESIGN, Code.USER_STTUS_RESIGN_NM));
//			
//			//공통-유저타입
//			ccdRepo.save(genCmmnCode(Code.CID_USER_TY, Code.USER_TY_MNG, Code.USER_TY_MNG_NM));
//			ccdRepo.save(genCmmnCode(Code.CID_USER_TY, Code.USER_TY_USR, Code.USER_TY_USR_NM));
//			
//			
//			User adm = new User();
//			adm.setUserId("admin");
//			adm.setUserNm("어드민");
//			adm.setUserPw(pe.encode("admin"));
//			adm.setUserTyCode(eu.getUserTyCmm(Code.USER_TY_MNG));
//			adm.setUserSttusCode(eu.getUserSttusCmm(Code.USER_STTUS_OK));
//			User admInfo = userRepo.save(adm);
//			log.debug("saved is {}", admInfo);
//			
//			UserRole admRole = new UserRole();
//			admRole.setRoleTyCode(eu.getRoleTyCmm(Code.ROLE_TY_ADM));
//			admRole.setUserSn(admInfo);
//			userRoleRepo.save(admRole);
//			
//			UserRole mngRole = new UserRole();
//			mngRole.setRoleTyCode(eu.getRoleTyCmm(Code.ROLE_TY_USR));
//			mngRole.setUserSn(admInfo);
//			userRoleRepo.save(mngRole);
//			
//			UserRole uerRole = new UserRole();
//			uerRole.setRoleTyCode(eu.getRoleTyCmm(Code.ROLE_TY_MNG));
//			uerRole.setUserSn(admInfo);
//			userRoleRepo.save(uerRole);
//		}
//	}
//	
//	private CmmnCodeDetail genCmmnCode(String codeId, String codeVal, String codeValNm) {
//		CmmnCodeDetail ccd = new CmmnCodeDetail();
//		ccd.setCodeId(codeId);
//		ccd.setCodeValue(codeVal);
//		ccd.setCodeValueNm(codeValNm);
//		return ccd;
//	}
//}
