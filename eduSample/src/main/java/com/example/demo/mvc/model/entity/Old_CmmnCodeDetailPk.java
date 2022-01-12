package com.example.demo.mvc.model.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Embeddable
@SuppressWarnings("unused")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Deprecated
public class Old_CmmnCodeDetailPk implements Serializable{		
	private static final long serialVersionUID = 1L;
	@Column(name = "code_id")
	private String codeId;
	@Column(name = "code_value")
	private String codeValue;
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Old_CmmnCodeDetailPk pk1 = (Old_CmmnCodeDetailPk)o;
		return Objects.equals(pk1.codeId, codeId) && Objects.equals(pk1.codeValue, codeValue);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codeId, codeValue);
	}
}