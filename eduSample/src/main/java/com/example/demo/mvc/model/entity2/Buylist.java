package com.example.demo.mvc.model.entity2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.mvc.model.entity.Base;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_buylist")
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@IdClass(BuylistPK.class)
@Entity
public class Buylist extends Base{
	//회원고유번호
	@Id
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "usr_no")
	private Member buyer;
	
	//상품번호
	@Id
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "gds_no")
	private Goods gdsNo;
	
	//구매일자
	@Column(name = "buy_dt", length = 8)
	private String buyDt;
	
	//구매시간
	@Column(name = "buy_tm", length = 6)
	private String buyTm;
	
	//구매수량
	@Column(name = "buy_qtt", length = 5)
	private String buyQtt;
	
	//구매금액 
	@Column(name = "buy_amt", length = 15)
	private String buyAmt;
	
	//구매상태
	@Column(name = "buy_stat", length = 1)
	private String buyStat;
	
	//처리일시
	@Column(name = "proc_dtm", length = 14)
	private String procStat;
}
