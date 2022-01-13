package com.example.demo.mvc.model.entity3;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.mvc.model.entity.CmmnCodeDetail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_memb_login_hst", indexes = @Index(columnList = "login_no"))
@SequenceGenerator(name = "memLoginHst_seq", allocationSize = 1, initialValue = 1, sequenceName = "memLoginHst_seq")
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
//@Entity
public class MemberLoginHst {
	@Id@GeneratedValue(generator = "memLoginHst_seq", strategy = GenerationType.SEQUENCE)@Column(name = "login_no")
	private Long loginNo;
	
	@ManyToOne@JoinColumn(name = "member_no")
	private Member memberNo;
	
	@Column(name = "connect_ip")
	private String connectIp;
}
