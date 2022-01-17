package school;

public class StudentTest {

	public static void main(String[] args) {
		Student[] studentArray = new Student[3];
		// Student 객체를 3개 생성하여 배열에 넣는다.
		studentArray[0] = new Student("홍길동", 15, 171, 81);
		studentArray[1] = new Student("한사람", 13, 183, 72);
		studentArray[2] = new Student("임걱정", 16, 175, 65);
		
		// 배열에 있는 객체 정보를 모두 출력 한다.
		System.out.printf("%-10s%-10s%-10s%-10s%n","이름", "나이","신장","몸무게");
		for(int i = 0; i < studentArray.length; i++) {
			System.out.printf("%-10s%-10s%-10s%-10s%n",
							studentArray[i].getName(),
							studentArray[i].getAge(),
							studentArray[i].getHeight(),
							studentArray[i].getWeight());
		}
		double ageSum = 0;
		double heightSum = 0;
		double weightSum = 0;
		// 나이의 평균 출력
		for(int i = 0; i < studentArray.length; i++) {
			ageSum += studentArray[i].getAge();
		}
		System.out.println("나이의 평균: " + Math.round(ageSum / studentArray.length * 100) / 100.0);
		// 신장의 평균 출력
		for(int i = 0; i < studentArray.length; i++) {
			heightSum += studentArray[i].getHeight();
		}
		System.out.println("신장의 평균: " + Math.round(heightSum/ studentArray.length * 100) / 100.0);
		// 몸무게의 평균 출력
		for(int i = 0; i < studentArray.length; i++) {
			weightSum += studentArray[i].getWeight();
		}
		System.out.println("몸무게의 평균: " + Math.round(weightSum / studentArray.length * 100) / 100.0);
	}

}
