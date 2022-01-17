package com.kh.mini.member.model.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.kh.mini.member.model.vo.Member;

public class MemberIO {
	private final static String FILE_PATH = "files/member.json";
	Set<Member> setMember;
	
	public void writeJson(Set<Member> set) {
		FileWriter fw = null;
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			fw = new FileWriter(FILE_PATH);
			gson.toJson(set, fw);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	public Set<Member> readJson() {
		//json파일 읽기
		JsonReader reader = null;
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();//예쁘게 출력
			reader = new JsonReader(new FileReader(FILE_PATH));//경로
			Member[] m = new Gson().fromJson(reader, Member[].class);//멤버배열 형태로 가져옴
			
			List<Member> list = new ArrayList<>();
			list.addAll(Arrays.asList(m));//배열 형태의 member를 list화
			
			setMember = new HashSet<>(list);
//			Set<Member> set = new HashSet<>(list);//member list를 set으로 변경(중복방지를 위해)
//			System.out.println(setMember);//테스트 출력
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return setMember;
	}
}
