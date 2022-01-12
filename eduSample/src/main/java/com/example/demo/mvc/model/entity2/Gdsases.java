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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_gdsases")
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@IdClass(GdsasesPK.class)
@Entity
public class Gdsases extends Base{
	
	//@Column(name = "usr_no")
	@Id
	@ManyToOne
	@JoinColumn(name = "usr_no")
	private Member asser;
	
	//@Column(name = "gds_no")
	@Id
	@ManyToOne
	@JoinColumn(name = "gds_no")
	private Goods goods;
	
	//상품번호
//	@Id
//	@Column(name = "gds_no")
//	private String gdsNo;
//	
//	//상품평일련번호
//	@Id
//	@Column(name = "gds_eval_sno")
//	private Long gdsEvalSno;
	
	//상품평단계
	@Column(name = "gds_eval_lev", length = 1, nullable = false)
	private Long gdsEvalLev;
	
	//상위 일련번호
	@Column(name = "uppr_sno", length = 5)
	private String upprSno;
	
	//내용
	@Column(name = "eval_cont", length = 100)
	private String evalCont;
}
