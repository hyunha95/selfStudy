package company;

public class Test02 {

	public static void main(String[] args) {
		Company c = new Company(Integer.parseInt(args[0]));
		System.out.println("연 기본급 합: " + c.getIncome() + " 세후: " 
						  + c.getAfterTaxIncome());
		System.out.println("연 보너스 합 : " + c.getBonus() + " 세후 :"
						  + c.getAfterTaxBonus());
		System.out.println("연 지급액 합: " + (c.getAfterTaxIncome() + c.getAfterTaxBonus()));
	}

}
