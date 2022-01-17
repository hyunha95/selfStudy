package com.kh.design.pattern.strategy;

/**
 * context는 실행할 Strategy를 몰라야 한다.
 *
 */
public class Controller {

	private CommonService service;
	
	public Controller(CommonService service) {
		this.service = service;
	}
	
	public void test() {
		service.test();
	}
}
