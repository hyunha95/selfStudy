package mobile;

public class MobileTest {
	
	// 각각의 Mobile 객체 생성
	Mobile lTab = new Ltab("Ltab", 500, "AP-01");
	Mobile oTab = new Otab("Otab", 1000, "AND-20");

	public static void main(String[] args) {
		MobileTest mt = new MobileTest();
		
		//생성된 객체의 정보 출력
		mt.content();
		
		// 각각의 mobile 객체에 10분씩 충전
		System.out.println("10분 충전");
		mt.lTab.charge(10);
		mt.oTab.charge(10);
		
		// 10분 충전 후 객체 정보 출력
		mt.content();
		
		// 각각의 Mobile 객체에 5분씩 통화
		System.out.println("5분 통화");
		mt.lTab.operate(5);
		mt.oTab.operate(5);
		// 5분 통화 후 객체 정보 출력
		mt.content();
	}
	
	
	public void content() {
		System.out.printf("%-15s%-15s%-15s%n", "Mobile", "Battery", "OS");
		System.out.println("---------------------------------------");
		System.out.printf("%-15s%-15s%-15s%n", lTab.mobileName, lTab.batterySize, lTab.osType);
		System.out.printf("%-15s%-15s%-15s%n%n", oTab.mobileName, oTab.batterySize, oTab.osType);
		
	}

}
