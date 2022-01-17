package com.thread.sleep;

public class SleepTest implements Runnable{

	public static void main(String[] args) {
		SleepTest t = new SleepTest();
		t.run();
	

	}
	@Override
	public void run() {
		for(int i = 0; i<10; i++) {
			sendAphorism();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	
	public void sendAphorism() {
		String[] arr = new String[] {
				"가는 날이 장날이다.", 
				"가재는 게 편",
				"개같이 벌어서 정승같이 산다",
				"개똥도 약에 쓰려면 없다.",
				"개천에서 용난다.",
				"고래 싸움에 새우 등 터진다.",
				"금강산도 식후경",
				"낫 놓고 기역자도 모른다.",
				"내 코가 석자",
				"될성부른 나무는 떡잎부터 알아본다."
		};
			int rndNum = (int)(Math.random() * 10) + 1;
			System.out.println(arr[rndNum]);				
	}
}
