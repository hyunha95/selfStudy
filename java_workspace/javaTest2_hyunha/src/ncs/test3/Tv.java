package ncs.test3;

public class Tv {

	private String name;
	private int price;
	private String description;
	
	public Tv() {
		
	}

	public Tv(String name, int price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return name + "\t" + price + "\t" + description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
