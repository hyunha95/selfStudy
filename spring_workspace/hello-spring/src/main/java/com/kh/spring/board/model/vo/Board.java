package com.kh.spring.board.model.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.kh.spring.member.model.vo.Member;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper=true)
@NoArgsConstructor
public class Board extends BoardEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int attachCount; // 게시물별 첨부파일 수
	private List<Attachment> attachments;
	private Member member;
	
	public Board(int no, String title, String memberId, String content, Date regDate, int readCount, int attachCount,
			List<Attachment> attachments, Member member) {
		super(no, title, memberId, content, regDate, readCount);
		this.attachCount = attachCount;
		this.attachments = attachments;
		this.member = member;
	}

	
	
}