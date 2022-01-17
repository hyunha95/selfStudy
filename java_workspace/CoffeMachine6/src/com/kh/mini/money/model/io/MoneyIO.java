package com.kh.mini.money.model.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import com.kh.mini.money.model.vo.Money;

public class MoneyIO {
	BufferedReader br;
	
//	public static void main(String[]args) {
//		MoneyIO io = new MoneyIO();
//		io.readFile();
//		io.writerFile();
//	}

	public Money readFile() {
		int fileValue = 0;
		Money money = new Money();
		try {
			File file = new File("files/money.txt");
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);

			String line = null;
			while ((line = br.readLine()) != null) {
				fileValue = Integer.parseInt(line);
				money.setMoney(fileValue);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return money;
	}
	 
	 public void writerFile(Money money) {
		 File file;
		 FileWriter fw = null;
		 
		 try {
			 file = new File("files/money.txt");
			 fw = new FileWriter("files/money.txt",false); //파일 있을 경우 덮어쓰기 
             
			 if (!file.exists()) {
				 file.createNewFile();
				 }
	
 
			 String data = String.valueOf(money.getMoney());
             fw.write(data);
             fw.flush();
             
		 } catch (IOException e) {
			e.printStackTrace();
		 }finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
		    }
	 }
  }
	
}
	 

