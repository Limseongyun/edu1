package com.example.demo.utiltest;

import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;

import com.example.demo.cmm.utils.Sha256Util;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Sha256Test {
	@Test
	public void test() {
		Sha256Util t = new Sha256Util();
		String str = "str";
		try {
			log.debug("end : {}", t.encrypt(str));
		} catch (NoSuchAlgorithmException e) {
			log.debug("err: {}", e.getMessage());
		}
	}
}
