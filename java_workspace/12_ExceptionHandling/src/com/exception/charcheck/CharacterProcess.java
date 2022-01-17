package com.exception.charcheck;


public class CharacterProcess {
	
	

	public CharacterProcess() {

	}

	public int countAlpha(String s) {
		char[] chArr = new char[s.length()];
		//char배열 생성해서 전달받은 매개인자 대입
		for(int i = 0; i < s.length(); i++) {
			if(
			   (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
			   (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
			   ) {
				chArr[i] = s.charAt(i);			
			}
			else if(s.charAt(i) == ' ') {
				throw new CharCheckException();
			} 

		}
		
		return chArr.length;
	}
}
