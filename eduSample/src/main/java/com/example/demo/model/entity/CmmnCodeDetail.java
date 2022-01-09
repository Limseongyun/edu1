package com.example.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import groovy.transform.builder.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity
@DynamicInsert
@Table(name = "tb_cmmn_code_detail")
@EntityListeners(AuditingEntityListener.class)
public class CmmnCodeDetail extends BaseTime{
	@Id
	@Column(name = "cmmn_code_detail_sn")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long cmmnCodeDetailSn;
	
	@Column(name = "code_id")
	private String codeId;
	
	@Column(name = "code_value")
	private String codeValue;
	
	@Column(name = "code_value_nm")
	private String codeValueNm;
}
