package com.collection.list.music.controller;

import java.util.ArrayList;
import java.util.List;

import com.collection.list.music.model.vo.Music;

public class MusicManager {
	
	private List<Music> musicList = new ArrayList<>();
	
	{
	musicList.add(new Music("Save your tears", "The Weekend & Ariana Grande"));
	musicList.add(new Music("Say so", "Doja cat"));
	musicList.add(new Music("Old Town Road", "Lil Nas X"));
	musicList.add(new Music("Leave before you love me", "Marshmello & Jonas Brothers"));
	musicList.add(new Music("Go Away", "Omar Apollo"));
	
	}

	public List<Music> selectList() {
		return musicList;
	}
	
	public void addList(Music music) {
		musicList.add(music);
		System.out.println("맨 뒤에 저장 완료!!!");
	}

	public void addAtZero(Music music) {
		musicList.add(0, music);
		System.out.println("맨 처음에 저장 완료!!!");
	}
	
	public boolean removeMusic(String title) {
		for(int i = 0; i <musicList.size(); i++) {
			Music m = musicList.get(i);
			if(title.equals(m.getTitle())) {
				musicList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean replaceMusic(Music oldMusic, Music newMusic) {
		if(musicList.contains(oldMusic)) {
			musicList.set(musicList.indexOf(oldMusic), newMusic);
			return true;
		}
		
		return false;
	}

	
}






