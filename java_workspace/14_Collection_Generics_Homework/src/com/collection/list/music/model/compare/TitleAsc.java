package com.collection.list.music.model.compare;

import java.util.Comparator;

import com.collection.list.music.model.vo.Music;

public class TitleAsc implements Comparator<Music> {

	@Override
	public int compare(Music o1, Music o2) {
		return o1.getTitle().compareTo(o2.getTitle());
		//o2.getTitle().compareTo(o1.getTitle()); 처음부터 역순으로 만드는 방법
	}
	
}
