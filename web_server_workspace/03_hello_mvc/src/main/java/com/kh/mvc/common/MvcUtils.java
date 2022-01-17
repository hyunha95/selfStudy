package com.kh.mvc.common;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;

import com.kh.mvc.board.model.vo.Attachment;
import com.oreilly.servlet.MultipartRequest;

public class MvcUtils {

	/**
	 * 비밀번호 암호화 처리 메소드
	 * 
	 * 1. 암호화 처리 : MessageDigest
	 * 
	 * 2. 암호화된 이진배열을 문자열로 인코딩처리 : Base64Encoder
	 * 
	 */
	public static String getEncryptedPassword(String password) { // 매개변수에 사용자가 입력한 원본문자열이 담긴다.
		
		// 1. 암호화처리
		byte[] encrypted = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] plain = password.getBytes("utf-8"); // 잘못된 문자열이 들어오지 않았는지 검사해준다. 암호화 처리를 위해 이진 배열로 바꾼다.
			md.update(plain); // md객체에 원본문자열 설정
			encrypted = md.digest(); // 암호화
			
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(new String(encrypted));
		
		// 2. 인코딩처리
		// 영문자, 숫자, +, / 64개의 문자를 사용(= 패딩문자도 사용)
		Encoder encoder = Base64.getEncoder();
		String encryptedPassword = encoder.encodeToString(encrypted); // 암호화된 이진 배열을 문자열로 돌려준다.
		
		System.out.println(encryptedPassword);
		
		return encryptedPassword;
	}

	/**
	 * cPage
	 * numPerPage
	 * totalContent
	 * url
	 * 
	 * totalPage 전체페이지
	 * pagebarSize 페이지바 크기 5
	 * pageNo
	 * pageStart - pageEnd
	 */
	public static String getPagebar(int cPage, int numPerPage, int totalContent, String url) {
		
		StringBuilder pagebar = new StringBuilder();
		url = url + "?cPage="; // pageNo 추가전 상태
		
		final int pagebarSize = 5;
		final int totalPage = (int) Math.ceil((double) totalContent / numPerPage);
		final int pageStart = (cPage - 1) / pagebarSize * pagebarSize + 1; // 1 ~ 5 까지는 1, 6 ~ 10 까지는 6
		int pageEnd = pageStart + pagebarSize - 1;
		pageEnd = totalPage < pageEnd ? totalPage : pageEnd;
		int pageNo = pageStart;
		
		// [이전]
		if(pageNo == 1) { // pageNo == 1이라면 이전 버튼 없음
			// cPage = 1, 2, 3, 4, 5
		}
		else {
			pagebar.append("<a href='" + url + (pageNo - 1) + "'>prev</a>\n");
		}
		
		// pageNo
		while(pageNo <= pageEnd) {
			if(pageNo == cPage) {
				pagebar.append("<span class='cPage'>" + cPage + "</span>\n"); // pageNo가 cPage라면 링크 없음 
			}
			else {
				pagebar.append("<a href='" + url + pageNo + "'>" + pageNo + "</a>\n");
			}
			
			pageNo++;
		}
		// [다음]
		if(pageNo > totalPage) {
			// 마지막 페이지보다도 크면 넘어간다.
		}
		else {
			pagebar.append("<a href='" + url + pageNo + "'>next</a>\n");
		}
		
		return pagebar.toString();
	}

	public static Attachment makeAttachment(MultipartRequest multipartRequest, String name) {
		Attachment attach = new Attachment();
		String orginalFilename = multipartRequest.getOriginalFileName(name);
		String renamedFilename = multipartRequest.getFilesystemName(name);
		attach.setOriginalFilename(orginalFilename);
		attach.setRenamedFilename(renamedFilename);
		return attach;
	}
	
}






