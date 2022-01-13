package com.example.demo.mvc.model.entity2;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Deprecated
public class BuylistPK implements Serializable{
	private static final long serialVersionUID = 1L;
	private Member buyer;
	private Goods gdsNo;
}
