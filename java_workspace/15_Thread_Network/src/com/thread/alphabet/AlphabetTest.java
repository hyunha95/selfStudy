package com.thread.alphabet;

public class AlphabetTest {

	public static void main(String[] args) {
		Thread th1 = new Thread(new LowwerAlphabetThread());
		Thread th2 = new Thread(new UpperAlphabetThread());
		
		th1.start();
		th2.start();

	}

}
