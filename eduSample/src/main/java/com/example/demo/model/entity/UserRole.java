package com.example.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import groovy.transform.builder.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_user_role")
@EntityListeners(AuditingEntityListener.class)
public class UserRole{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "user_role_sn")
	private Long userRoleSn;
	
	@Column(name = "role_nm")//TODO cmmn에서 가져오게
	private String roleNm;
	
	@Column(name = "user_sn")//TODO foreign
	private Long userSn;
}
