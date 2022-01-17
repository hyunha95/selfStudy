package com.exception.number;

import java.util.InputMismatchException;

public class NumberProcess {

	public NumberProcess() {
	
	}
	
	public boolean checkDouble(int a, int b) {
		boolean flag = false; //배수가 아니라고 가정
		
		if(a >= 1 && a <=100) {
			if(a % b == 0) {
				flag = true;
			}
		} else if(a < 1 || a > 100) {
			throw new NumberRangeException();
		} else {
			throw new InputMismatchException();
		}
		
		return flag;
	}
}
