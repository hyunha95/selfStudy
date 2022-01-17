package com.collection.list.music.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.collection.list.music.controller.MusicManager;
import com.collection.list.music.model.vo.Music;

public class MusicMenu {
	
	Scanner sc = new Scanner(System.in);
	MusicManager manager = new MusicManager();
	
	public void mainMenu() {
		String menu = "----- Music Playlist Menu -----\r\n" + 
					"1.목록보기\r\n" + 
					"2.마지막에 음악추가\r\n" + 
					"3.매처음에 음악추가\r\n" + 
					"4.곡삭제\r\n" + 
					"5.곡변경\r\n" + 
					"6.곡명검색\r\n" + 
					"7.가수검색\r\n" + 
					"8.목록정렬(곡명오름차순)\r\n" + 
					"0.종료\r\n" + 
					"--------------------------------\r\n" + 
					">> 메뉴선택 : ";
		
		while(true) {
			System.out.print(menu);
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1: 
				printList(manager.selectList());
				break;
			case 2: 
				manager.addList(inputMusic());
				break;
			case 3: 
				manager.addAtZero(inputMusic());
				break;
			case 4: 
				System.out.print("삭제할 곡을 입력하세요 : ");
				String title = sc.next();
				boolean result = manager.removeMusic(title);
				System.out.println(result ? "삭제 완료!" : "삭제 실패!");
				break;
			case 5: 
				System.out.println("곡을 변경합니다.");
				Music music2 = inputMusic();
				Music music3 = inputMusic();
				
				boolean result1 = manager.replaceMusic(music2, music3);
				System.out.println(result1 ? "변경 성공" : "변경 실패");
				
				break;
			case 6: break;
			case 7: break;
			case 8: break;
			case 9: break;
			case 0: break;
			default :
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
		}
		
	}

	public void orderMenu() {
		String orderMenu = "================== 정렬 메뉴 ===================\r\n" + 
										"1. 가수명 오름차순\r\n" + 
										"2. 가수명 내림차순\r\n" + 
										"3. 곡명 오름차순\r\n" + 
										"4. 곡명 내림차순\r\n" + 
										"5. 메인메뉴 돌아가기\r\n" + 
										"================================================\r\n" + 
										" >> 메뉴 선택 : ";
			
	}
	
	public void printList(List<Music> list) {
		System.out.println("============================");
		if(!list.isEmpty()) {
			System.out.println("곡명\t\t가수");
			System.out.println("----------------------");
			for(Music m : list)
				System.out.println(m);
		} else {
			System.out.println("찾으시는 곡이 없습니다.");
		}
		System.out.println("-----------------------\n");
	}
	
	public Music inputMusic() {
		System.out.println("> 곡 정보를 입력해주세요");
		System.out.print("> title : ");
		String title = inputTitle();
		System.out.print("> singer : ");
		String singer = inputSinger();
		return new Music(title, singer);
	}
	
	public String inputTitle() {
		return sc.next();
	}
	
	public String inputSinger() {
		return sc.next();
	}
}
