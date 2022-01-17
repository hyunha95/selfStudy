package ncs.test8;

import ncs.test7.Book;

public class BookUpdater {

	private Book bookData;

	public BookUpdater() {

	}

	public BookUpdater(Book bookData) {
		super();
		this.bookData = bookData;
	}
	
	public void updateBookPrice() {
		double price = bookData.getBookPrice();
		double salePrice = price * (1 - bookData.getBookDiscountRate());
		bookData.setBookPrice(salePrice);
	}

	public Book getBookData() {
		return bookData;
	}

	public void setBookData(Book bookData) {
		this.bookData = bookData;
	}
	
	
}
