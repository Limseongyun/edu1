package com.example.demo.cmm.utils;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class RVO<T> {
	private String msg;
	private String code;
	private T data;
}
