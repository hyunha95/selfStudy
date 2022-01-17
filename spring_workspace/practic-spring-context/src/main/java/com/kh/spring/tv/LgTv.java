package com.kh.spring.tv;

public class LgTv implements Tv {

	private RemoteControl remocon;
	
	public LgTv() {
		System.out.println("LgTv의 객체를 생성합니다.");		
	}

	public LgTv(RemoteControl remocon) {
		super();
		this.remocon = remocon;
	}
	
	public void setRemocon(RemoteControl remocon) {
		this.remocon = remocon;
	}

	@Override
	public void powerOn() {
		System.out.println("LgTv의 전원을 켰습니다.");
	}

	@Override
	public void changeChannel(int no) {
		remocon.changeChannel(no);
		
	}
	
	


	
}
