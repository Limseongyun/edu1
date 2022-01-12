package com.example.demo.mvc.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.mvc.model.entity.CmmnCodeDetail;

@Repository
public interface CmmnCodeDetailRepo extends JpaRepository<CmmnCodeDetail, Long>{	
	CmmnCodeDetail findByCodeIdAndCodeValue(String codeId, String codeValue);
}
