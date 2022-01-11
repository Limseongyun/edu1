package com.example.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

import groovy.transform.ToString;
import groovy.transform.builder.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity
@ToString
@DynamicInsert
@Table(name = "tb_user_role")
@EntityListeners(AuditingEntityListener.class)
public class UserRole{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "user_role_sn")
	private Long userRoleSn;
	
	@OneToOne
	@JoinColumn(name = "role_ty_code")
	private CmmnCodeDetail roleTyCode;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_sn")
	private User userSn;
}
