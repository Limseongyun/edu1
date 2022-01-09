package com.example.demo.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Base {
	@Column(name = "use_yn")
	@ColumnDefault("'Y'")
	private String useYn;
	
	//@CreatedBy
	@Column(name = "frst_regist_user_sn", nullable = false)
	private Long frstRegistUserSn;
	
	//@LastModifiedBy
	@Column(name = "last_change_user_sn", nullable = false)
	private Long lastChangeUserSn;
	
	@CreatedDate
	@Column(name = "frst_regist_dt", nullable = false)
	private LocalDateTime frstRegistDt;
	
	@LastModifiedDate
	@Column(name = "last_change_dt", nullable = false)
	private LocalDateTime lastChangeDt;
}
