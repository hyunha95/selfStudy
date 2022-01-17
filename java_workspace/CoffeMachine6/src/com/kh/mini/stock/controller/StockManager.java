package com.kh.mini.stock.controller;

import java.util.List;

import com.kh.mini.menu.model.vo.Menu;
import com.kh.mini.stock.model.io.StockIO;
import com.kh.mini.stock.model.vo.Stock;

public class StockManager {
	StockIO stockIO = new StockIO();
	public Stock stock = new Stock();
	
	public boolean checkStock(int num) {
		stock = stockIO.FileRead();
		
		if(checkProducts()) {
			if(num <= 3) {
				if(stock.getBeans() < 1) {
					System.out.println("원두가 부족합니다");
					return false;
				}
				switch (num) {
				case 1:
					if(stock.getWater() < 1) {
						System.out.println("물이 부족합니다");
						return false;
					}
					makeAme();
					return true;
				case 2://라떼 
					if(stock.getMilk() < 1) {
						System.out.println("우유가 부족합니다");
						return false;
					}
					makeLatte();
					return true;
				case 3://바닐라라떼
					if(stock.getMilk() < 1) {
						System.out.println("우유가 부족합니다");
						return false;
					}
					if(stock.getVanillaSyrup() < 1) {
						System.out.println("시럽이 부족합니다");
						return false;
					}
					makeVanillaLatte();
					return true;
				case 4:
					if(stock.getMilk() < 1) {
						System.out.println("우유가 부족합니다");
						return false;
					}
					if(stock.getChoco() < 1) {
						System.out.println("초코렛이 부족합니다");
						return false;
					}
					makeChocoLatte();
					return true;
				}
			}
		}else {
			System.out.println("주문을 종료합니다");
			System.exit(0);
		}
		
		return false;
	}
	public boolean checkExraShot() {
		if(stock.getBeans() < 1) {
			System.out.println("원두가 부족합니다");
			return false;
		}
		stock.setBeans(stock.getBeans() - 1);
		return true;
	}
	public boolean checkIce() {
		if(stock.getIce() < 1) {
			System.out.println("얼음이 부족합니다");
			return false;
		}
		useIce();
		return true;
		
	}
	public boolean makeSizeUp(List<Menu> list, int index) {
		if(stock.getBeans() < 1) {
			System.out.println("원두가 부족합니다");
			return false;
		}
		if(list.get(index).isSizeUp()) {
			if(stock.getLargeCup() < 1) {
				System.out.println("큰 컵이 부족합니다");
				return false;
			}
			if(list.get(index).getName().equals("아메리카노")) {
				if(stock.getWater() < 1) {
					System.out.println("물이 부족합니다");
					return false;
				}
				makeAme();
				useCup(list.get(index).isSizeUp());
			}
			if(list.get(index).getName().contains("라떼")) {
				if(stock.getMilk() < 1) {
					System.out.println("우유가 부족합니다");
					return false;
				}
				if(list.get(index).getName().equals("라떼")) {
					makeLatte();
					useCup(list.get(index).isSizeUp());
				}
				if(list.get(index).getName().equals("바닐라라떼")) {
					makeVanillaLatte();
					useCup(list.get(index).isSizeUp());
				}
				if(list.get(index).getName().equals("초코라떼")) {
					makeChocoLatte();
					useCup(list.get(index).isSizeUp());
				}
			}
		}else {
			useCup(false);
		}
		
		
		return true;
	}
	public boolean checkSizeUp() {
		if(stock.getBeans() < 1) {
			System.out.println("원두가 부족합니다");
			return false;
		}if(stock.getLargeCup() < 1) {
			System.out.println("큰 컵이 부족합니다");
			return false;
		}
		return true;
		
	}
	public boolean checkProducts() {
		if(stock.getSmallCup() == 0 || stock.getLargeCup() == 0 || stock.getStraw() == 0) {
			System.out.println("비품이 부족합니다");
			return false;
		}
		return true;
		
	}
	
	public void makeAme() {
		stock.setBeans(stock.getBeans() - 1);
		stock.setWater(stock.getWater() - 1);
	}
	public void makeLatte() {
		stock.setBeans(stock.getBeans() - 1);
		stock.setMilk(stock.getMilk() - 1);
	}
	public void makeVanillaLatte() {
		stock.setBeans(stock.getBeans() - 1);
		stock.setMilk(stock.getMilk() - 1);
		stock.setVanillaSyrup(stock.getVanillaSyrup() - 1);
	}
	public void useCup(boolean sizeUp) {
		if(sizeUp) {
			stock.setLargeCup(stock.getLargeCup() - 1);
		}else {
			stock.setSmallCup(stock.getSmallCup() - 1);
		}
		stock.setStraw(stock.getStraw() - 1);
	}
	public void makeChocoLatte() {
		stock.setChoco(stock.getChoco() - 1);
		stock.setMilk(stock.getMilk() - 1);
	}
	public void useIce() {
		stock.setIce(stock.getIce() - 1);
	}
}
