package com.thread.alphabet;

public class LowwerAlphabetThread implements Runnable{

	@Override
	public void run() {
		for(char a = 'a'; a <= 'z'; a++) {
			System.out.print(a);
		}
		
	}
}
