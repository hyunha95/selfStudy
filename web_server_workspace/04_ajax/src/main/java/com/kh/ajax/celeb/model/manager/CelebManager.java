package com.kh.ajax.celeb.model.manager;

import java.util.ArrayList;
import java.util.List;

import com.kh.ajax.celeb.model.vo.Celeb;

public class CelebManager {

	public static List<Celeb> celebList = new ArrayList<>();
	
	static {
		celebList.add(new Celeb("박보검", "01012341234", 33, "parkBogum.jpg", false));
		celebList.add(new Celeb("쥴리아로버츠", "01077778888", 48, "juliaRoberts.jpg", true));
		celebList.add(new Celeb("맷 데이먼", "01023232323", 50, "mattDamon.jpg", true));
		celebList.add(new Celeb("양세찬", "01066664444", 38, "yang_se_chan.jpg", false));
		celebList.add(new Celeb("김고은", "01056567777", 33, "김고은.jpg", false));
	}
}
