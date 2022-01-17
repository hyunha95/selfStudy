package kh.java.nested.loop;

import java.util.Arrays;

public class LottoStudy {

	/**
	 * 1 ~ 45 사이의 중복없는 난수 6개 뽑기
	 * @param args
	 */
	public static void main(String[] args) {
		int[] lotto = new int[6];
		
		abc:
		for(int i = 0; i < lotto.length; i++) {
			int n = (int)(Math.random() * 45) + 1;
			// 중복검사 : 이전 입력값 중에 중복값이 있는지 검사
			for(int j = 0; j < i; j++) {
				if(n == lotto[j]) {
					i--; // continue 이후에 증감식에서 현재 인덱스를 다시 처리
					continue abc;
				}
			}
			System.out.println();
			
			lotto[i] = n;
			System.out.println(Arrays.toString(lotto));
			/*
			 int[] lotto = new int[6];
		int index = 0;
		abc:
		while(true) {
			int n = (int)(Math.random() * 45) + 1;
			for(int j = 0; j < index; j++) {
				if(n == lotto[j]) {
					continue abc;
				}
			}
			lotto[index++] = n; 
			if(index == lotto.length) 
				break;
		}
		System.out.println(Arrays.toString(lotto));
			 */
		}
	}
}
