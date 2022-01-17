package com.io.test4.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.io.test4.vo.Book;

public class BookManager {

	Scanner sc = new Scanner(System.in);

	public BookManager() {
		super();
	}
	
	public void fileSave() {
		Book[] books = new Book[2];
	
		try(
			ObjectOutputStream oos =
				new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("books.dat")));
		) {
			for(int i = 0; i < books.length; i++) {
				Book book = inputBookInfo();
				books[i] = book;
				oos.writeObject(books[i]);
			}
			System.out.println("books.dat에 저장 완료!");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		Book[] books = new Book[4];
		
		try(
			ObjectInputStream ois =
				new ObjectInputStream(new BufferedInputStream(new FileInputStream("books.dat")));
		) {
			for(int i = 0; i < books.length; i++) {
				books[i] = (Book) ois.readObject();
				System.out.println(books[i]);
			}
			System.out.println("books.dat 읽기 완료!");
		} catch(EOFException e) {
			System.out.println("EOFException 이다");
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Book inputBookInfo() {
		System.out.println("> 책 정보를 입력하세요 : ");
		System.out.print("> title : ");
		String title = sc.next();
		System.out.print("> author : ");
		String author = sc.next();
		System.out.print("> price : ");
		int price = sc.nextInt();
		System.out.print("> dates : ");
		String dates = sc.next();
		int yyyy = Integer.parseInt(dates.substring(0, 4));
		int MM = Integer.parseInt(dates.substring(4, 6));
		int dd = Integer.parseInt(dates.substring(6));
		
		return new Book (title, author, price, new GregorianCalendar(yyyy, MM, dd));
	}
	
}
