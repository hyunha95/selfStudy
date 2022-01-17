package com.oop.device;
/**
 * @실습문제

		
@Device

	public class Device {

		private String brand;
		private String name;
		private int price;
		
		public Device() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Device(String brand, String name, int price) {
			super();
			this.brand = brand;
			this.name = name;
			this.price = price;
		}

		public String getBrand() {
			return brand;
		}

		public String getName() {
			return name;
		}

		public int getPrice() {
			return price;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "brand=" + brand + ", name=" + name + ", price=" + price;
		}
		
		
		
	}



다음과 같은 상속관계를 가질때, 다음 main메소드 실행코드를 정상 수행하기 위한 코드를 완성하세요.
* 기본생성자/파라미터생성자/getter/setter
* 모든 필드 정보를 확인할 수 있는 메소드 toString
* Laptop은 capacity(용량 GB) 필드와 getter/setter 추가
* TV는 channel필드, getter/setter, channelUp, channelDown메소드 추가

	Device
		Laptop
		TV


		Device[] arr = new Device[10];
		arr[0] = new TV("삼성", "평면TV", 3_000_000, 10);
		arr[1] = new TV("LG", "울트라평면TV", 2_500_000, 20);
		arr[2] = new Laptop("LG", "그램17", 2_000_000, 512);
		arr[3] = new Laptop("apple", "맥북16", 3_000_000, 1024);
		
		//1. arr을 순회하면서, 
		// tv객체라면 channelUp메소드 호출
		// laptop객체 용량 정보를 출력
		
		//2. arr을 순회하면서 
		//toString을 통해 모든 필드정보를 조회(동적바인딩)
 * @author hyunha
 *
 */
public class DeviceMain {

	public static void main(String[] args) {
		
		Device[] arr = new Device[10];
		arr[0] = new TV("삼성", "평면TV", 3_000_000, 10);
		arr[1] = new TV("LG", "울트라평면TV", 2_500_000, 20);
		arr[2] = new Laptop("LG", "그램17", 2_000_000, 512);
		arr[3] = new Laptop("apple", "맥북16", 3_000_000, 1024);

		//1. arr을 순회하면서,
		//tv객체라면 channelUp메소드 호출
		//laptop객체 용량 정보를 출력
		//선생님 풀이
		for(Device d : arr) {
			if(d instanceof TV) {
				((TV)d).channelUp();
			}
			else if(d instanceof Laptop)
				System.out.println(((Laptop)d).getCapacity());
		}
		
//		for(int i = 0; i < arr.length; i++) {
//			if(arr[i] == null) {
//				break;
//			}
//			if(arr[i] instanceof TV) {
//				((TV) arr[i]).channelUp();
//			}
//			else if(arr[i] instanceof Laptop) {
//				System.out.println(((Laptop) arr[i]).getCapacity());
//			}
//		}
		
		//2. arr을 순회하면서
		//toString을 통해 모든 필드정보를 조회(동적바인딩)
		for(Device d : arr) {
			if(d == null) break;
			System.out.println(d.toString());
		}
		
//		for(int i = 0; i < arr.length; i++) {
//			if(arr[i] == null) {
//				break;
//			}
//				Device device = arr[i];
//				System.out.println(device.toString());				
//		}
		
		//3. arr을 순회
		//getAd()호출해서 제품별 광고문구를 출력! (기능구현 강제화)
		//tv객체인 경우, 화면뒤의 진짜세계를 경험하세요. 삼성 - 평면TV
		//laptop객체인 경우, 비대면 시대의 유일한 경쟁력. Apple - macbook pro 16
		for(Device d : arr) {
			if(d == null) break;
		System.out.println(d.getAd());
			
		}
		
		
	}

}
