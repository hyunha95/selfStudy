package kh.java.two.dimentional.array;

public class TwoDimentionalArrayStudy {

	public static void main(String[] args) {
		TwoDimentionalArrayStudy study = new TwoDimentionalArrayStudy();
//		study.test1();
//		study.test2();
		study.test3();
//		study.test4();
//		study.test5();
	}
	
	/**
	 * 2차원배열 초기화 : 배열선언 + 할당 + 값대입
	 */
	public void test5() {
		int[][] intArr = { 
				{1,2,3}, 
				{4,5,6} 
				};
	
		for(int i = 0; i< intArr.length; i++) {
			for(int j = 0; j < intArr[i].length; j++) {
				System.out.print(intArr[i][j] + " ");
			}
			System.out.println();
		}
	
	// (요소를 담을 변수 : 반복접근할 객체)
		for(int[] arr : intArr) {
			for(int n : arr) {
				System.out.println(n + " ");
			}
			System.out.println();
		}
	}
	
	
	/**
	 * 알파뱃배열 - 2행 26열
	 * 0 : A B C D ... X Y Z
	 * 1 : a b c d ... x y z
	 */
	public void test4() {
		char[][] arr = new char[2][26];
		char A = 'A';
		char a = 'a';
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(i == 0) {
					arr[i][j] = A++;
				}
				else {
					arr[i][j] = a++;
				}
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 중첩 반복문을 통해서 값 대입 : 값이 규칙적인 경우.
	 */
	public void test3() {
		int[][] arr = new int[5][6];
		int k = 1;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++){
				arr[i][j] = k++;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 우리반 2차원배열
	 */
	public void test2() {
		String[][] friends = new String[5][6];
		friends[0][0] = "김재경";
		friends[0][1] = "김찬호";
		friends[0][2] = "구본욱";
		friends[0][3] = "한태우";
		friends[0][4] = "서진교";
		friends[0][5] = "김형진";
		
		friends[1][0] = "서원영";
		friends[1][1] = "최종인";
		friends[1][2] = "박세환";
		friends[1][3] = "김미림";
		friends[1][4] = "안대범";
		friends[1][5] = "고정현";
		
		friends[2][0] = "이호연";
		friends[2][1] = "정한별";
		friends[2][2] = "백시윤";
		friends[2][3] = "노현하";
		friends[2][4] = "김미래";
		friends[2][5] = "이혜미";
		
		friends[3][0] = "조정우";
		friends[3][1] = "전예성";
		friends[3][2] = "장희연";
		friends[3][3] = "유법용";
		friends[3][4] = "김혜원";
		friends[3][5] = "신중규";
		
		friends[4][0] = "이조은";
		friends[4][1] = "김유정";
		friends[4][2] = "김호연";
		friends[4][3] = "이송이";
		friends[4][4] = "양소영";
		friends[4][5] = "전혜린";
		
		printFriends(friends);
	}
	
	/**
	 * 우리반 2차원 배열 출력 메소드
	 */
	public void printFriends(String[][] friends) {
		for(int i = 0; i < friends.length; i++) {
			for(int j = 0; j < friends[i].length; j++) {
				System.out.print(friends[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
	/**
	 * 2차원배열 : 배열안의 배열, 행열의 정보를 표현할 수 있다.
	 * 
	 * 1. 배열선언
	 * 2. 배열할당
	 * 3. 각번지수별로 값대입
	 */
	public void test1() {
		int[][] arr;
		arr = new int[2][3];

		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[0][2] = 30;
		arr[1][0] = 40;
		arr[1][1] = 50;
		arr[1][2] = 60;
		
//		System.out.println(arr[0][0]);
//		System.out.println(arr[0][1]);
//		System.out.println(arr[0][2]);
//		System.out.println(arr[1][0]);
//		System.out.println(arr[1][1]);
//		System.out.println(arr[1][2]);
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}












