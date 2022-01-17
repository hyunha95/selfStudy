package company;

public class Company {
	
	private double salary;
	private double annualIncome;
	private double bonus;
	private double afterTaxBonus;

	public Company() {
		
	};
	
	public Company(double salary) {
		this.salary = salary;
	}
	
	public double getIncome() {
		return salary * 12;
	}
	public double getAfterTaxIncome() {
		return salary * 12 * 0.9;
	}
	public double getBonus() {
		return salary * 0.2 * 4;
	}
	public double getAfterTaxBonus() {
		return salary * 0.2 * 4 * 0.945;
	}
}
