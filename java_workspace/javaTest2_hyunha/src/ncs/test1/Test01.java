package ncs.test1;

public class Test01 {

	public static void main(String[] args) {
		//평가 점수
		double a = 0.0;
		double b = 0.0;
		double c = 0.0;
		double d = 0.0;
		double e = 0.0;
		
		if(args.length != 5) {
			System.out.println("다시 입력 하세요.1");
		}
	
		for(int i = 0; i < args.length; i++) {
			if(Double.parseDouble(args[i]) < 10 || Double.parseDouble(args[i]) > 99) {
				System.out.println("다시 입력하세요");
			}
			switch(i) {
			case 0 :
				a = Double.parseDouble(args[0]); break;
			case 1:
				b = Double.parseDouble(args[1]); break;
			case 2:
				c = Double.parseDouble(args[2]); break;
			case 3:
				d = Double.parseDouble(args[3]); break;
			default:
				e = Double.parseDouble(args[4]); break;
			}
		}
		
		double result = (((a + b) / 2) * 0.6) + (((c + d) / 2) * 0.2) + e * 0.2; 
		String grade = "";
		if(result >= 90) {
			grade = "Gold Class";
		}
		else if(result >= 80) {
			grade = "Silver Class";
		}
		else if(result >= 70) {
			grade = "Bronze Class";
		}
		else {
			grade = "Normal Class";
		}
		
		//실행결과
		System.out.println("평가점수: " + result + "점");
		System.out.println("Class:" + grade);
		
	}
}
