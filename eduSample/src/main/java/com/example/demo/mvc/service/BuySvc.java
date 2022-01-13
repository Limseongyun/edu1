package com.example.demo.mvc.service;

public interface BuySvc {
	//상품구매
	/*
	 * 1.재고체크(가맹점도,)
	 * 2.구매가능체크(머니 존재하는지)
	 * 3.회원상태 체크 
	 * 4.결제, 성공시 상품-1,구매이력인서트, 머니거래이력 인서트
	 * 5.결제, 실패시 롤백
	 * 6.판매자 머니 원장금액+
	 * buyhst(m, g)
	 * */
}
