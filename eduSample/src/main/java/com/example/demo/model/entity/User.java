package com.example.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
@Table(name = "tb_user")
@EntityListeners(AuditingEntityListener.class)
public class User {
	@Id
	@Column(name = "user_sn")
	private Long userSn;
	
	@Column(name = "user_nm")
	private String userNm;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "user_pw")
	private String userPw;
}
