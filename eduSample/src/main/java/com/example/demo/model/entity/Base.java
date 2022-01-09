package com.example.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Base extends BaseTime {
	@CreatedBy
	@Column(name = "frst_regist_user_sn")
	private Long frstRegistUserSn;
	
	@LastModifiedBy
	@Column(name = "last_change_user_sn")
	private Long lastChangeUserSn;
}
