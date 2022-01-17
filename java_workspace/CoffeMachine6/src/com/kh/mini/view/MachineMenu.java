package com.kh.mini.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.mini.member.controller.MemberManager;
import com.kh.mini.menu.controller.MenuManager;
import com.kh.mini.menu.model.vo.Menu;
import com.kh.mini.money.controller.MoneyManager;
import com.kh.mini.money.model.io.MoneyIO;
import com.kh.mini.money.model.vo.Money;
import com.kh.mini.stock.controller.StockManager;
import com.kh.mini.stock.model.io.StockIO;
import com.kh.mini.stock.model.vo.Stock;

public class MachineMenu {
	private final static String PASSWORD = "5555";
	private MenuManager menuManager = new MenuManager();
	private Menu menu = new Menu();
	private Scanner sc = new Scanner(System.in);
	private boolean isCoffee = false; // true가 되면 커피임
	private int menuCount = 0; // 주문 횟수
	private MemberManager memberManager = new MemberManager();
	private MoneyManager moneyManager = new MoneyManager();
	private StockManager stockManager = new StockManager();
	private StockIO stockIO = new StockIO();
	private MoneyIO moneyIO = new MoneyIO();
	
	public void mainMenu() {
		String menu = "\n----- 커피 자판기 ------\n"
					+ "1. 주문하기\n"
					+ "2. 관리자 메뉴\n"
					+ "0. 종료\n"
					+ "----------------------\n"
					+ ">> 선택 : ";
		
		while(true) {
			
			try {
				
				System.out.print(menu);
				int selected = sc.nextInt();
				
				switch(selected) {
				case 1 : 
					selectMenu(); 
					break;
				case 2 : 
					adminManage();
					break; //관리자 메뉴 추가해야함
				case 0 : 
					System.out.println("자판기 종료"); return;
				default : 
					System.out.println("잘못 입력하셨습니다.");
					break;
				}
				
			} catch(InputMismatchException e) {
				System.err.println("번호만 입력해주세요.");
				sc.nextLine();
				continue;
			}
		}
		
	}
	
	public void selectMenu() {
		
		String menu = "\n----- 메뉴 선택 -------\n"
				    + "1. 아메리카노 (2000원)\n"
				    + "2. 라떼 (2500원)\n"
				    + "3. 바닐라라떼 (3000원)\n"
				    + "4. 초코라떼 (2500원)\n"
				    + "0. 돌아가기\n"
				    + "---------------------\n"
				    + ">> 선택 : ";
		while(true) {
			
			try {
				
				System.out.print(menu);
				int selected = sc.nextInt();
				
				switch(selected) {
				case 1 : 
					if(stockManager.checkStock(selected)) {
						menuManager.addMenu(new Menu("아메리카노", 2000));
						menuCount++; // selectMenu가 호출 될때마다 주문 횟수 + 1
						isCoffee = true;  //커피인지 아닌지 확인함. 나중에 옵션에서 샷추가를 보일지 말지 결정
						temperatureSelect();
					}else {
						System.out.println("이전으로 돌아갑니다");
						return;
					}
					break;
				case 2 : 
					if(stockManager.checkStock(selected)) {
						menuManager.addMenu(new Menu("라떼", 2500));
						menuCount++; // selectMenu가 호출 될때마다 주문 횟수 + 1
						isCoffee = true;  //커피인지 아닌지 확인함. 나중에 옵션에서 샷추가를 보일지 말지 결정
						temperatureSelect();
					}else {
						System.out.println("이전으로 돌아갑니다");
						return;
					}
					break;
				case 3 : 
					if(stockManager.checkProducts()) {
						menuManager.addMenu(new Menu("바닐라라떼", 3000));		
						menuCount++; // selectMenu가 호출 될때마다 주문 횟수 + 1
						isCoffee = true;  //커피인지 아닌지 확인함. 나중에 옵션에서 샷추가를 보일지 말지 결정
						temperatureSelect();
					}else {
						System.out.println("이전으로 돌아갑니다");
						return;
					}
					break;
				case 4 : 
					if(stockManager.checkProducts()) {
						menuManager.addMenu(new Menu("초코라떼", 2500));	
						menuCount++; // selectMenu가 호출 될때마다 주문 횟수 + 1
						temperatureSelect();
					}else {
						System.out.println("이전으로 돌아갑니다");
						return;
					}
					break;
				case 0 :
					return;
				default : 
					System.out.println("잘못입력하셨습니다.");;
				}
				
			} catch (InputMismatchException e) {
				System.err.println("번호만 입력해주세요.");
				sc.nextLine();
				continue;
			}
		}
	}
	
	public void temperatureSelect() {
		
		String menu = "\n1. Ice\n"
					+ "2. Hot\n"
					+ ">> 선택 : ";
		
		while(true) {
			try {
				System.out.print(menu);
				int selected = sc.nextInt();
				switch(selected) {
				case 1: 
					if(stockManager.checkIce()) {
						menuManager.addIce(true);
						if(isCoffee) {
							coffeeOption();
						} else {
							otherOption();
						}
					}else {
						continue;
					}
					break;
				case 2:
					if(isCoffee) {
						coffeeOption();
					} else {
						otherOption();
					}
					break;
				default :
					System.out.println("잘못입력하셨습니다.");
					break;
				}

			} catch(InputMismatchException e) {
				System.err.println("번호만 입력해주세요.");
				sc.nextLine();
				continue;
			}
		}
	}
	
	//커피일 경우 선택하는 옵션
	public void coffeeOption() {
		String option ="\n----- 옵션 선택 ------\n"
					 + "1. 샷 추가 (500원)\n"
					 + "2. 사이즈 업 (1000원)\n"
					 + "0. 선택완료\n"
					 + "--------------------\n"
					 + ">> 선택 : ";	
		while(true) {
			try {
				System.out.print(option);
				int selected = sc.nextInt();
				
				switch(selected) {
				case 1 : 
					isShotAdded(); // 샷 추가했는지 여부 확인
					if(stockManager.checkExraShot()) {
						menuManager.extraShot(true);
					}else {
						continue;
					}
					break;
				case 2 : 
					isSizeUp(); // 사이즈 업 했는지 여부 확인
					if(stockManager.checkSizeUp()) {
						menuManager.sizeUp(true);
						stockManager.makeSizeUp(menuManager.orderList(), menuManager.getMenucount());
					}else {
						continue;
					}
					break;
				case 0 : 
					stockManager.makeSizeUp(menuManager.orderList(), menuManager.getMenucount());
					finalSelection();
					break;
				default : 
					System.out.println("잘못선택하셨습니다.");
				}
				
			} catch (InputMismatchException e) {
				System.err.println("번호만 입력해주세요.");
				sc.nextLine();
				continue;
			}
		}
	}
	
	//커피가 아닐 경우 선택하는 옵션
	public void otherOption() {
		String option = "\n----- 옵션 선택 ------\n"
				      + "1. 사이즈 업 (1000원)\n"
				      + "0. 선택완료\n"
				      + ">> 선택 : ";	
		while(true) {
			try {
				System.out.print(option);
				int selected = sc.nextInt();
				
				switch(selected) {
				case 1 : 
					isSizeUp(); // 사이즈 업 했는지 여부 확인
					if(stockManager.checkSizeUp()) {
						menuManager.sizeUp(true);
						stockManager.makeSizeUp(menuManager.orderList(), menuManager.getMenucount());
					}else {
						continue;
					}
					break;
				case 0 : 
					stockManager.makeSizeUp(menuManager.orderList(), menuManager.getMenucount());
					finalSelection(); 
				default : 
					System.out.println("잘못선택하셨습니다.");
				}
				
			} catch (InputMismatchException e) {
				System.err.println("번호만 입력해주세요.");
				sc.nextLine();
				continue;
			}
		}
	}
	
	public void finalSelection() {
		
		orderList(); // 여태까지 추가된 메뉴를 보여준다
		
		String selection = "\n1. 장바구니에 담고 추가 주문하기\n"
						 + "2. 다시 주문하기\n"
						 + "3. 결제하기\n"
						 + ">> 선택 : ";
		while(true) {
			try {
				System.out.print(selection);
				int selected = sc.nextInt();
				switch(selected) {
				case 1 : 
					isCoffee = false; // 재 주문시 주문한 메뉴가 커피인지 확인하기 위한 필드 초기화
					selectMenu(); 
					break;
				case 2:
					menuManager.orderList().clear();
					System.out.println("장바구니 삭제 완료");
					selectMenu();
					break;
				case 3 :
					// 결제하기 메소드 호출해야됨
					int price = totalPrice(menuManager.orderList());
					System.out.println("총 금액 " + price + "원 입니다.");
					stockIO.FileWrite(stockManager.stock);
					membership(price);
					break;
				default :
					System.out.println("잘못입력하셨습니다.");
				}
				
			} catch (InputMismatchException e) {
				System.err.println("번호만 입력해주세요.");
				sc.nextLine();
				continue;
			}
		}	
	}
	
	public void membership(int price) {
		System.out.println("멤버쉽 적립/사용 하시겠습니까?");
		String selection = "1. 적립\n"
						 + "2. 적립 안함\n"
						 + "0. 돌아가기\n"
						 + ">> 선택 : ";
		while(true) {
			System.out.println(selection);
			int input = sc.nextInt();
			switch (input) {
			case 1:
				memberManager.checkMember(totalPrice(menuManager.orderList()));
				
				break;
			case 2:
				//바로 결제로 넘어감
				moneyManager.countMoney(price);
				break;
			case 3:
				return;
			default:
				break;
			}
		}
	}
	
	public int totalPrice(List<Menu> list) {//전체금액 계산해주는 메소드
		int total = 0;
		for(int i = 0; i < list.size(); i++) {
			Menu m = list.get(i);
			int shot = m.isExtraShot() ? 1 : 0;
			int size = m.isSizeUp() ? 1 : 0;
			total +=  m.getPrice() + (shot * 500) + (size * 1000);
		}
		return total;
	}
	
	//샷 추가 여부 확인
	public void isShotAdded() {
		for(int i = 0; i < menuManager.orderList().size(); i++) {
			
			if(menuManager.orderList().get(menuCount - 1).isExtraShot()) {
				System.err.println("이미 샷을 추가하셨습니다.");
				break;
			}
			
		}
	}
	
	//사이즈 업 추가 여부 확인
	public void isSizeUp() {
		for(int i = 0; i < menuManager.orderList().size(); i++) {
			
			if(menuManager.orderList().get(menuCount - 1).isSizeUp()) {
				System.err.println("이미 사이즈 업을 하셨습니다.");
				break;
			}
			
		}
	}
	
	//여태까지 추가된 메뉴 출력
	public void orderList() {
		for(int i = 0; i < menuManager.orderList().size(); i++) {
			
			System.out.println(i + 1 + ". 결제 대기 : " + menuManager.orderList().get(i).getName() 
								+ " " + menuManager.orderList().get(i).getPrice());
			System.out.println(menuManager.orderList().get(i).isOptionIce() ? "ICE" : "HOT");
			System.out.println(menuManager.orderList().get(i).isExtraShot() ? "샷 추가 : + 500원" : "샷 추가 : X" );
			System.out.println(menuManager.orderList().get(i).isSizeUp() ? "사이즈 업 : + 1000원" : "사이즈 업 : X");
			System.out.println(); // 개행
		
		}	
	}
	
	public void adminManage() {
		System.out.println("비밀번호를 입력하세요");
		String str = sc.next();
		if(str.equals(PASSWORD)) {
			String menu = "\n----- 관리자 메뉴 ------\n"
					+ "1. 재고 확인\n"
					+ "2. 금고 확인\n"
					+ "3. 재고 추가\n"
					+ "0. 종료\n"
					+ "----------------------\n"
					+ ">> 선택 : ";
			while(true) {
				Stock stock = null;
				
				System.out.println(menu);
				int input = sc.nextInt();
				System.out.println();
				switch (input) {
				case 1:
					stock = stockIO.FileRead();
					System.out.println(stock);
					break;
				case 2: 
					Money money = moneyIO.readFile();
					System.out.println(money);
					break;
				case 3:
					while(true) {
						System.out.println("추가할 재고의 번호를 입력하세요");
						String stockMenu = "\n----- 관리자 메뉴 ------\n"
								+ "1. 원두\n"
								+ "2. 물\n"
								+ "3. 얼음\n"
								+ "4. 컵\n"
								+ "0. 종료\n"
								+ "----------------------\n"
								+ ">> 선택 : ";
						System.out.println(stockMenu);
						stock = stockIO.FileRead();
						input = sc.nextInt();
						switch (input) {
						case 1:
							System.out.println("커피를 추가합니다 갯수를 입력해주세요");
							input = sc.nextInt();
							stock.setBeans(stock.getBeans() + input);
							stockIO.FileWrite(stock);
							break;
						case 2:
							System.out.println("물을 추가합니다 갯수를 입력해주세요");
							input = sc.nextInt();
							stock.setWater(stock.getWater() + input);
							stockIO.FileWrite(stock);
							break;
						case 3:
							System.out.println("얼음을 추가합니다 갯수를 입력해주세요");
							input = sc.nextInt();
							stock.setIce(stock.getIce() + input);
							stockIO.FileWrite(stock);
							break;
						case 4:
							System.out.println("컵을 추가합니다 갯수를 입력해주세요");
							input = sc.nextInt();
							stock.setLargeCup(stock.getLargeCup() + input);
							stock.setSmallCup(stock.getSmallCup() + input);
							stockIO.FileWrite(stock);
							break;
						case 0 : 
							return;
						default:
							System.out.println("잘못된 입력입니다");
							break;
						}
					}
				case 0 :
					return;
				default:
					break;
				}
			}
		}else {
			System.out.println("접근이 불가합니다");
		}
		
	}
}