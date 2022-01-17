package com.kh.spring.tv;

public class BalmudaRemocon implements RemoteControl {

	@Override
	public void changeChannel(int no) {
		System.out.println("채널을 " + no + "번으로 바꿉니다.");

	}

}
