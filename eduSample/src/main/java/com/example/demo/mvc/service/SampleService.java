package com.example.demo.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.CommonMap;
import com.example.demo.mvc.mapper.SampleMapper;

@Service
public class SampleService {
	@Autowired private SampleMapper mapper;
	
	public List<CommonMap> sample(){
		return mapper.sample();
	}
}
