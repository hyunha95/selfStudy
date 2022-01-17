package mobile;

public class Ltab extends Mobile{

	public Ltab() {
		
	};
	public Ltab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
	}

	@Override
	public int operate(int time) {
		batterySize -= time * 10;
		return batterySize;
	}
	
	@Override
	public int charge(int time) {
		batterySize += time * 10;
		return batterySize;
	}
	
	
	
}
