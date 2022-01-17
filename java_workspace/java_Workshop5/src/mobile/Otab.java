package mobile;

public class Otab extends Mobile{

	public Otab() {
		super();
	}

	public Otab(String mobileName, int batteySize, String osType) {
		super(mobileName, batteySize, osType);
	}

	@Override
	public int operate(int time) {
		batterySize -= time * 12;
		return batterySize;
	}

	@Override
	public int charge(int time) {
		batterySize += time * 8;
		return batterySize;
	}

	

	
}
