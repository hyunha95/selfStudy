package ncs.test7;

public class BookTest {

	public static void main(String[] args) {
		Book[] bookArray = new Book[5];
		double sum = 0;
		
		bookArray[0] = new Book("IT", "SQL Plus", 50000.0, 0.05);
		bookArray[1] = new Book("IT", "Java 2.0", 40000.0, 0.03);
		bookArray[2] = new Book("IT", "JSP Servlet", 60000.0, 0.06);
		bookArray[3] = new Book("Nobel", "davincicode", 30000.0, 0.1);
		bookArray[4] = new Book("Nobel", "cloven hoof", 50000.0, 0.15);
		
		for(int i = 0; i < bookArray.length; i++) {
			System.out.printf("%-5s %-10s %.1f원 %.1f%%%n", bookArray[i].getCategory(),
														  bookArray[i].getBookName(),
														  bookArray[i].getBookPrice(),
														  bookArray[i].getBookDiscountRate() * 100);
			sum += (bookArray[i].getBookPrice() - (bookArray[i].getBookPrice() * bookArray[i].getBookDiscountRate()));
		}
		System.out.println("책 가격의 합 : " + sum + "원");

	}

}
