package com.example.demo.mvc.model.entity2;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@Table(name = "tb_goods", indexes = @Index(columnList = "gds_no"))
@SequenceGenerator(name = "gds_seq", allocationSize = 1, initialValue = 1, sequenceName = "gds_seq")
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Goods extends Base{
	//상품번호
	@Id
	@GeneratedValue(generator = "gds_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "gds_no")
	private Long gdsNo;
	
	//카테고리번호
	@Column(name = "catg_no", length = 2, nullable = false)
	private String catgNo;
	
	//판매자 고유 번호
	@Column(name = "selr_usr_no", length = 8, nullable = false)
	private String selrUsrNo;
	
	//상품일련번호
	@Column(name = "gds_sno", length = 7, nullable = false)
	private String gdsSno;
	
	//상품명
	@Column(name = "gds_nm", length = 200, nullable = false)
	private String gdsNm;
	
	//판매금액
	@Column(name = "gds_amt", length = 10)
	private String gdsAmt;
	
	//상품수량
	@Column(name = "gds_qtt", length = 8)
	private Long gdsQtt;
	
	//판매수량
	@Column(name = "gds_sell_qtt", length = 8)
	private Long gdsSellQtt;
	
	//판매종료일자
	@Column(name = "gds_cls_dt", length = 8)
	private String gdsClsDt;
	
	//배송비용
	@Column(name = "gds_shpp_cost", length = 6)
	private String gdsShppCost;
	
	//실제파일명
	@Column(name = "real_file_nm", length = 100)
	private String realFileNm;
	
	//상품이미지경로
	@Column(name = "gds_img_path", length = 200)
	private String gdsImgPath;
	
	//상품설명
	@Column(name = "gds_desc", length = 4000)
	private String gdsDesc;
	
	//판매여부
	@Column(name = "buy_yn", length = 1)
	private String buyYn;
	
	//판매중지일자
	@Column(name = "buy_cncl_dt", length = 8)
	private String buyCnclDt;
}
