package ncs.test3;

import java.util.Arrays;

public class TvTest {

	public static void main(String[] args) {
		Tv[] tvArray = new Tv[3];
		tvArray[0] = new Tv("INFINIA", 1500000, "LED TV");
		tvArray[1] = new Tv("XCANVAS", 1000000, "LCD TV");
		tvArray[2] = new Tv("CINEMA", 2000000, "3D TV");
		
		for(int i = 0; i < tvArray.length; i++) {
			System.out.println(tvArray[i].toString());
		}
		/* 선생님 풀이
		 	//최대/최소 출력
		Tv maxTv=tvArray[0], minTv=tvArray[0];
		for (int i = 1; i < tvArray.length; i++) {
			//가격이 가장 비싼 제품
			if(maxTv.getPrice()<tvArray[i].getPrice())
				maxTv = tvArray[i];
			//가격이 가장 저렴한 제품			
			if(minTv.getPrice()>tvArray[i].getPrice())
				minTv = tvArray[i];
		}
		System.out.println("가격이 가장 비싼 제품 : "+maxTv.getName());
		System.out.println("가격이 가장 저렴한 제품 : "+minTv.getName());
	
		 */
		// max, min값 찾기
		int[] nums = {tvArray[0].getPrice(), 
				      tvArray[1].getPrice(),
				      tvArray[2].getPrice()};
		Arrays.sort(nums);
		
		for(int i = 0; i < 3; i++) {
			if(nums[nums.length - 1] == tvArray[i].getPrice()) {
				System.out.printf("가격이 가장 비싼 제품 : %s%n", tvArray[i].getName());
			}
		}
		for(int i =0; i< 3; i++) {
			if(nums[0] == tvArray[i].getPrice()) {
				System.out.printf("가격이 가장 저렴한 제품: %s", tvArray[i].getName());
			}
		}
	}

}
