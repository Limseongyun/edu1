package com.example.demo.cmm.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.cmm.code.Cd;
import com.example.demo.cmm.code.Code;
import com.example.demo.mvc.model.entity.CmmnCodeDetail;
import com.example.demo.mvc.repos.CmmnCodeDetailRepo;
@Component
public class EntityUtil {
	@Autowired private CmmnCodeDetailRepo ccdRepo;
	
	public CmmnCodeDetail getMemberTyCmm(String codeValue) {
		return ccdRepo.findByCodeIdAndCodeValue(Cd.CODE_ID_MEMBER_TY, codeValue);
	}
	
	public CmmnCodeDetail getMemberSttusCmm(String codeValue) {
		return ccdRepo.findByCodeIdAndCodeValue(Cd.CODE_ID_MEMBER_STTUS, codeValue);
	}
	
	public CmmnCodeDetail getMoneyTransferCmm(String codeValue) {
		return ccdRepo.findByCodeIdAndCodeValue(Cd.CODE_ID_MONEY_TSF_TY_CODE, codeValue);
	}
	
	public CmmnCodeDetail getMoneyMeanCmm(String codeValue) {
		return ccdRepo.findByCodeIdAndCodeValue(Cd.CODE_ID_MONEY_MEAN_CODE, codeValue);
	}
	
	
	@Deprecated
	public CmmnCodeDetail getUserTyCmm(String codeValue) {
		return ccdRepo.findByCodeIdAndCodeValue(Code.CID_USER_TY, codeValue);
	}
	
	@Deprecated
	public CmmnCodeDetail getUserSttusCmm(String codeValue) {
		return ccdRepo.findByCodeIdAndCodeValue(Code.CID_USER_STTUS, codeValue);
	}
	
	@Deprecated
	public CmmnCodeDetail getRoleTyCmm(String codeValue) {
		return ccdRepo.findByCodeIdAndCodeValue(Code.CID_ROLE_TY, codeValue);
	}

}
