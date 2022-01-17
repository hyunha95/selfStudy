package com.kh.mini.stock.model.io;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kh.mini.stock.model.vo.Stock;

public class StockIO {	
	
	
	public static void main(String[] args) {
		StockIO stockIO = new StockIO();
		List<Stock> list = new ArrayList<>();
		Stock stock = new Stock();
		stock = stockIO.FileRead();
//		stock.setBeans(5555);
//		System.out.println(list.get(0));
		stockIO.FileWrite(stock);
	}
	public Stock FileRead() {
		Stock stock = new Stock();
		File f = new File("files/Coffee_Stock.txt");
		FileReader fr;
		BufferedReader br = null;

		ArrayList<Stock> stocklist = new ArrayList<Stock>();
		try {
			// ���� ������ �а�, �Ȱ��� ���Ͽ� ���ο� ������ �����ϱ� ���� �а� ���� ���μ��� �и�
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			// ���Ͽ��� �а�, ������ ��ü ����

			String data = null;
			List<Integer> list = new ArrayList<>();

			while ((data = br.readLine()) != null) {
//				System.out.println(data);
				String[] temp = data.split(",");
				
				list.add(Integer.valueOf(temp[1]));

			}
//			System.out.println(list);
			stock.setBeans(list.get(0));
			stock.setDecafBeans(list.get(1));
			stock.setIce(list.get(2));
			stock.setWater(list.get(3));
			stock.setSyrup(list.get(4));
			stock.setChoco(list.get(5));
			stock.setSmallCup(list.get(6));
			stock.setLargeCup(list.get(7));
			stock.setStraw(list.get(8));
			stock.setMilk(list.get(9));
			stock.setVanillaSyrup(list.get(10));
			
//			System.out.println(stock);
//			stocklist.add(new Stock(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5),
//					list.get(6), list.get(7), list.get(8), list.get(9), list.get(10)));
//			System.out.println(stocklist);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// ���� ���� ��Ʈ�� ����
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return stock;
	}  

	public void FileWrite(Stock stock) {
		File f = new File("files/Coffee_Stock.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {

			// �ش� ���Ͽ� ���ο� ������ ����
			fw = new FileWriter(f, false); // ���������͸� �����ϰ�, �߰�(����� ������� �ٲٱ�)
			bw = new BufferedWriter(fw);
//			String data = "";
//			data = "beans" + "," + list.get(0).getBeans() + "\n" 
//				 + "decafBeans" + "," + list.get(0).getDecafBeans() + "\n" 
//				 + "ice" + "," + list.get(0).getIce() + "\n"				 
//				 + "water" + "," + list.get(0).getWater() + "\n"				 
//				 + "syrup" + "," + list.get(0).getSyrup() + "\n"				 
//				 + "choco" + "," + list.get(0).getChoco() + "\n"				 
//				 + "smallCup" + "," + list.get(0).getSmallCup() + "\n"				 
//				 + "largeCup" + "," + list.get(0).getLargeCup() + "\n"				 
//				 + "straw" + "," + list.get(0).getStraw() + "\n"				 
//				 + "milk" + "," + list.get(0).getMilk() + "\n"				 
//				 + "vanillaSyrup" + "," + list.get(0).getVanillaSyrup();
			
			String data = "";
			data = "beans" + "," + stock.getBeans() + "\n" 
				 + "decafBeans" + "," + stock.getDecafBeans() + "\n" 
				 + "ice" + "," + stock.getIce() + "\n"				 
				 + "water" + "," + stock.getWater() + "\n"				 
				 + "syrup" + "," + stock.getSyrup() + "\n"				 
				 + "choco" + "," + stock.getChoco() + "\n"				 
				 + "smallCup" + "," + stock.getSmallCup() + "\n"				 
				 + "largeCup" + "," + stock.getLargeCup() + "\n"				 
				 + "straw" + "," + stock.getStraw() + "\n"				 
				 + "milk" + "," + stock.getMilk() + "\n"				 
				 + "vanillaSyrup" + "," + stock.getVanillaSyrup();
			bw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// ���� ������ ��Ʈ�� ����
				bw.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} 
}


