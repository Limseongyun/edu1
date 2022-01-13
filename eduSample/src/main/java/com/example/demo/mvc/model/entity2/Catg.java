package com.example.demo.mvc.model.entity2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.mvc.model.entity.Base;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_catg", indexes = @Index(columnList = "catg_no"))
@SequenceGenerator(name = "catg_seq", allocationSize = 1, initialValue = 1, sequenceName = "catg_seq")
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
//@Entity
@Deprecated
public class Catg extends Base{
	//카테고리 번호
	@Id
	@GeneratedValue(generator = "catg_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "catg_no")
	private Long catgNo;
	
	//카테고리명
	@Column(name = "catg_nm", length = 100, nullable = false)
	private String catgNm;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "catgNo", cascade = CascadeType.ALL)
	private List<Goods> goods = new ArrayList<>();
	
	public void addGoods(Goods g) {
		this.goods.add(g);
		g.setCatgNo(this);
	}
}
