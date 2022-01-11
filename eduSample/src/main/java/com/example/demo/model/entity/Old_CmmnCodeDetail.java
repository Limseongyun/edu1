package com.example.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
//@Entity
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Table(name = "tb_cmmn_code_detail")
@EntityListeners(AuditingEntityListener.class)
@Deprecated
public class Old_CmmnCodeDetail extends BaseTime{
	@EmbeddedId
	private Old_CmmnCodeDetailPk cmmnCodeDetailPk;
	
	@Column(name = "code_value_nm")
	private String codeValueNm;
}
