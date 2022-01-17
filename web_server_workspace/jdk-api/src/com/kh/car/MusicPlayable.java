package com.kh.car;

import java.io.Serializable;

public interface MusicPlayable extends Serializable{

	void playMusic();
	
	/**
	 * default method
	 * - 인터페이스의 상속가능한 일반메소드
	 */
	public default void next() {
		System.out.println("다음곡 재생합니다.");
	}
	
	public static void horn() {
		System.out.println("빵~~~~~~~~~~~~~~~");
	}
	
}
