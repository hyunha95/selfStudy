package com.thread.alphabet;

public class UpperAlphabetThread implements Runnable{

	@Override
	public void run() {
		for(char A = 'A'; A <= 'Z'; A++) {
			System.out.print(A);
		}
		
	}
}
