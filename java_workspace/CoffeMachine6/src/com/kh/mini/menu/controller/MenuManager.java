package com.kh.mini.menu.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.mini.menu.model.vo.Menu;

public class MenuManager {

	private List<Menu> menuList = new ArrayList<>();
	private int menuCount = 0;
	
	// 음료 추가하기
	public void addMenu(Menu m){
		menuList.add(m);
		menuCount++;
	}
	
	//샷추가
	public void extraShot(boolean b) {
		menuList.get(menuCount - 1).setExtraShot(b);
	}
	
	//사이즈업
	public void sizeUp(boolean b) {
		menuList.get(menuCount - 1).setSizeUp(b);
	}
	
	//ICE 선택했을 때 optionIce = true;
	public void addIce(boolean b) {
		menuList.get(menuCount - 1).setOptionIce(b);
	}
	
	public List<Menu> orderList(){
		return menuList;
	}
	public int getMenucount() {
		return this.menuCount-1;
	}
}