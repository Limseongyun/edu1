package com.example.demo.mvc.model.entity2;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Deprecated
public class GdsasesPK implements Serializable{
	private static final long serialVersionUID = 1L;
	private Member asser;
	private Goods goods;
}
