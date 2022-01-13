package com.example.demo.mvc.model.entity3;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.mvc.model.entity.Base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_memb_money", indexes = @Index(columnList = "login_no"))
//@SequenceGenerator(name = "memLoginHst_seq", allocationSize = 1, initialValue = 1, sequenceName = "memLoginHst_seq")
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
//@Entity
public class MemberMoney extends Base{
	@Id@Column(name = "memb_no")
	private Member membNo;
	
	@Column(name = "money_blce", length = 15)
	@ColumnDefault("0")
	private Long moneyBlce;
}
