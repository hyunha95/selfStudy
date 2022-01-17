package member.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import member.model.vo.Member;

public class MemberManager {

	public static final String DEST_FILE_NAME = "member.ser";
	
	/**
	 * member.ser로부터 Member[]을 읽어서 리턴
	 * 
	 */
	public Member[] selectAllMember() {
		
		File src = new File(DEST_FILE_NAME);
		try(
			ObjectInputStream ois = 
				new ObjectInputStream(new BufferedInputStream(new FileInputStream(src)));
		) {
			return (Member[]) ois.readObject();
			
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * member.ser의 Member[]에 새 회원을 추가하고, 다시 객체출력하는 메소드
	 * 1. member.ser에서 Member[] 가져오기
	 * 2. member를 Member[]에 추가하기
	 * 3. Member[]을 member.ser에 다시 쓰기
	 * 
	 */
	public boolean insertMember(Member member) {
		//1. member.ser에서 Member[] 가져오기
		Member[] members = selectAllMember();
		
		//2. member를 Member[]에 추가하기
		boolean result = false; // 추가실패라고 가정!
		for(int i = 0; i < members.length; i++) {
			if(members[i] == null) {
				members[i] = member;
				result = true;
				break;
			}
		}
		
		//3. Member[]을 member.ser에 다시 쓰기
		if(result) {
			try(
				ObjectOutputStream oos
					= new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(DEST_FILE_NAME)));
			){
				oos.writeObject(members);
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
