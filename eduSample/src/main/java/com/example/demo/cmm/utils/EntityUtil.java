package com.example.demo.cmm.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.cmm.code.Code;
import com.example.demo.mvc.model.entity.CmmnCodeDetail;
import com.example.demo.mvc.repos.CmmnCodeDetailRepo;
@Component
public class EntityUtil {
	@Autowired private CmmnCodeDetailRepo ccdRepo;
	
	public CmmnCodeDetail getUserTyCmm(String codeValue) {
		return ccdRepo.findByCodeIdAndCodeValue(Code.CID_USER_TY, codeValue);
	}
	
	public CmmnCodeDetail getUserSttusCmm(String codeValue) {
		return ccdRepo.findByCodeIdAndCodeValue(Code.CID_USER_STTUS, codeValue);
	}
	
	public CmmnCodeDetail getRoleTyCmm(String codeValue) {
		return ccdRepo.findByCodeIdAndCodeValue(Code.CID_ROLE_TY, codeValue);
	}

}
