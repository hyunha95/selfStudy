package com.kh.spring.tv;

public class SamsungTv implements Tv {

	private RemoteControl remocon;
	
	public SamsungTv() {
		System.out.println("SamsungTv객체를 생성합니다.");
	}
	
	public SamsungTv(RemoteControl remocon) {
		super();
		this.remocon = remocon;
	}
	
	public void setRemocon(RemoteControl remocon) {
		this.remocon = remocon;
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTv의 전원을 켰습니다.");

	}

	@Override
	public void changeChannel(int no) {
		remocon.changeChannel(no);
		
	}

}