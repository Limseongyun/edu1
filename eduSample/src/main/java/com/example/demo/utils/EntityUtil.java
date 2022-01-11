package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.config.code.Code;
import com.example.demo.model.entity.CmmnCodeDetail;
import com.example.demo.model.repo.CmmnCodeDetailRepo;
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
