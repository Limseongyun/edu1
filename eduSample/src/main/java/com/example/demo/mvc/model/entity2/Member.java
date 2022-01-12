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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.mvc.model.entity.Base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//스키마에는 핸드폰 관련 컬럼이 6개이지만 교육용이므로 하나만 한다.
//private String hpDddNo;
//private String hpZno;
//private String hpSno;
//private String telDddNo;
//private String telAno;
//private String telSno;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_member", indexes = @Index(columnList = "usr_no"))
@SequenceGenerator(name = "mem_seq", allocationSize = 1, initialValue = 1, sequenceName = "mem_seq")
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Member extends Base{
	//회원고유번호
	@Id
	@GeneratedValue(generator = "mem_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "usr_no")
	private Long usrNo;
	
	//회원 구분 (01: 판매자, 02:일반회원) TODO: CmmnCodeDetail
	@Column(name = "usr_cls", length = 1, nullable = false)
	private String usrCls;
	
	//회원 아이디
	@Column(name = "usr_id", length = 12, nullable = false)
	private String usrId;
	
	//패스워드
	@Column(name = "usr_pwd", length = 20, nullable = false)
	private String usrPwd;
	
	//한글성명
	@Column(name = "usr_nm", length = 100, nullable = false)
	private String usrNm;
	
	//핸드폰 번호
	@Column(name = "usr_hp_no", length = 20, nullable = false)
	private String usrHpNo;
	
	//이메일 주소
	@Column(name = "usr_email", length = 100)
	private String usrEmail;
	
	//우편번호
	@Column(name = "zip_cd", length = 6, nullable = false)
	private String zipCd;
	
	//주소
	@Column(name = "zip_addr", length = 150, nullable = false)
	private String zipAddr;
	
	//상세주소
	@Column(name = "detail_addr", length = 150)
	private String detailAddr;
	
	//최근 접속 일시
	@Column(name = "visit_dtm")
	@Temporal(TemporalType.TIMESTAMP)
	private Date visitDtm;
	
	//최근접속 호스트
	@Column(name = "visit_host", length = 15)
	private String visitHost;
}
