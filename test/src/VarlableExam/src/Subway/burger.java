package VarlableExam.src.Subway;

import java.util.Scanner;
public class burger extends Subway{
	
	static sub sb = new sub();
	static Scanner sc = new Scanner(System.in);
	// 선택할 수 있는 메뉴와 메뉴에 따른 가격
	static String[] 빵 = {"화이트","플랫","위트","허니 오트(1000원 추가)","파마산(1000원 추가)"};
	static int[] breadPrice = {2100,2200,2300,3000,3100,};
	static String[] 고기 = {"햄","BLT","스테이크","포크","로스터리 치킨"};
	static int[] meatPrice = {3000,3100,3200,3300,3400};
	static String[] 소스={"마요네즈","스윗칠리","허니머스타드","핫칠리","랜치"};
	static String[] 야채 = {"오이","피클","할라피뇨","양파","피망"};
	//버거 가격, 버거+서브메뉴 필드
	static int AllPrice =0;
	static int BurgerPrice = 0;
	static int SubPrice=0;
	
	
	
	//15cm, 30cm 선택 관련 메소드 30cm 선택시 15cm 버거(빵+고기)의 2배의 가격을 받음
	public static void SmallOrBig() {
		System.out.println("1.15cm로 하시겠습니까? 2.30cm로 하시겠습니까?");
		int ch = sc.nextInt();
		int x = burger.chooseMenu(빵, "빵");
		int y = burger.chooseMenu(고기, "고기");
		if(ch == 1) {
			BurgerPrice = (x+y);
		} else if(ch == 2) {
			BurgerPrice = (x+y)*2;
		}
	}
	
	// 메뉴 선택과 관련된 메소드 매게변수를 다르게 설정할 시 책정되는 가격과 나오는 메뉴리스트가 변경됨
	public static int chooseMenu(String[] name,String name2) {
		System.out.println("원하시는 "+name2+"(을)를 선택해 주세요:");
		ShowMaterial(name);
		int chooseNum = sc.nextInt();
		if(name.equals(빵)) {
			BurgerPrice += breadPrice[chooseNum-1];
			return breadPrice[chooseNum-1];
		} else if(name.equals(고기)) {
				BurgerPrice += meatPrice[chooseNum-1];
				return meatPrice[chooseNum-1];
		}
		return BurgerPrice;
	}
	// 야채, 소스를 추가 빼는 것을 담당하는 메소드
	public static void AddOrPlusSauce(String [] name) {
		if(name.equals(소스)) {
			System.out.println("몇 개의 소스를 넣을 것인지 선택해주세요");
			int ChooseSauce = sc.nextInt();
			String[] chooseWhatSauce = new String[ChooseSauce];
			ShowMaterial(소스);
			System.out.println("원하시는 소스를 골라주세요:");
			for(int i = 0; i<ChooseSauce;i++) {
				int ch = sc.nextInt();
				if(chooseWhatSauce[i] == null) {
					chooseWhatSauce[i] = 소스[ch-1];
				}
			}
			ShowMaterial2(chooseWhatSauce);
		} else if(name.equals(야채)) {
			System.out.println("제외할 야채의 수를 적어주세요");
			int ChooseVage = sc.nextInt();
			String[] chooseWhatVage = new String[ChooseVage];
			ShowMaterial(야채);
			System.out.println("빼고 싶은 야채를 골라주세요:");
			for(int i = 0; i<ChooseVage;i++) {
				int ch = sc.nextInt();
				if(chooseWhatVage[i] == null) {
					chooseWhatVage[i] = 야채[ch-1];
				}
			}
			ShowMaterial2(chooseWhatVage);
		} 
	}
		//서브메뉴 클래스를 가져오는 메소드.
		public static void ChooseSubMenu() {
			System.out.println("서브 메뉴도 추가로 시키겠습니까?\nY N");
			String ChooseNum = sc.next();
			if(ChooseNum.equals("Y") ||ChooseNum.equals("y")) {
				sb.Info();
				SubPrice = sb.result;
			} else if(ChooseNum.equals("N") ||ChooseNum.equals("n")) {
				System.out.println("");
			}else 
			{
				System.out.println("------------");
				System.out.println("잘못된 입력입니다.\n이전 페이지로 돌아갑니다.");
				System.out.println("------------");
				burger.ChooseSubMenu();
			}
		}
		//메뉴는 어떻게 구성되는지를 보여주는 메소드
		public static void ShowMaterial(String[] name) {
			System.out.println("------------");
			for(int i=0;i<name.length;i++) {
				System.out.print((i+1)+". ");
				System.out.print(name[i]);
				System.out.println("");
			}
			System.out.println("------------");
		}
		public static void ShowMaterial2(String[] name) {
			System.out.println("------------");
			for(String mono : name) {
				System.out.print(mono);
				System.out.print(" ");
			}
			System.out.println("\n------------");
		}
		
		public static void BurgerMain() {
			burger bg = new burger();
			SmallOrBig();
			AddOrPlusSauce(소스);
			AddOrPlusSauce(야채);
			ChooseSubMenu();
			AllPrice += (BurgerPrice+SubPrice);
		}
}