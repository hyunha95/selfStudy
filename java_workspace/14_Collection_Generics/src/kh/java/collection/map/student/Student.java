package kh.java.collection.map.student;

public class Student {

	private int sno;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private double avg;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sno, String name, int kor, int eng, int math) {
		super();
		this.sno = sno;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor + eng + math;
		this.avg = Math.round((double) sum / 3 * 10) / 10.0; // 둘째자리 반올림해서 첫째자리까지 표현
	}
	
	

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", sum=" + sum + ", avg=" + avg + "]";
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
}
