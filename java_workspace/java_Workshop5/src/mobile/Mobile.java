package mobile;

public abstract class Mobile {
	String mobileName;
	int batterySize;
	String osType;
	
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mobile(String mobileName, int batterySize, String osType) {
		super();
		this.mobileName = mobileName;
		this.batterySize = batterySize;
		this.osType = osType;
	}
	
	public abstract int operate(int time);
	public abstract int charge(int time);
}
