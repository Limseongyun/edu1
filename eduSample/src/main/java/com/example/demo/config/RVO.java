package com.example.demo.config;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class RVO<T> {
	private String msg;
	private String code;
	private T data;
}
