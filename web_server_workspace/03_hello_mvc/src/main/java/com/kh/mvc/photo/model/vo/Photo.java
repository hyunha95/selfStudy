package com.kh.mvc.photo.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Photo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int no;
	private String writer;
	private String content;
	private String originalFilename;
	private String renamedFilename;
	private Date regDate;
	private int readCount;
	
	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Photo(int no, String writer, String content, String originalFilename, String renamedFilename, Date regDate,
			int readCount) {
		super();
		this.no = no;
		this.writer = writer;
		this.content = content;
		this.originalFilename = originalFilename;
		this.renamedFilename = renamedFilename;
		this.regDate = regDate;
		this.readCount = readCount;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOriginalFilename() {
		return originalFilename;
	}
	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}
	public String getRenamedFilename() {
		return renamedFilename;
	}
	public void setRenamedFilename(String renamedFilename) {
		this.renamedFilename = renamedFilename;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
	@Override
	public String toString() {
		return "Photo [no=" + no + ", writer=" + writer + ", content=" + content + ", originalFilename="
				+ originalFilename + ", renamedFilename=" + renamedFilename + ", regDate=" + regDate + ", readCount="
				+ readCount + "]";
	}

}
