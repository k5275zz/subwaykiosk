package VarlableExam.src.Subway;

import java.util.Scanner;

public class kiosk extends Subway{
	static boolean st = false;
	sub su = new sub();
	static String checkName;
	
	
	static String[] member = {"김철수", "홍길동", "이유진"};
	int[] memberAccount = {1,2,3};
	static int[] memberAccountMoney = {500, 300, 200};
	
	public static void reset() {
		burger.AllPrice =0;
		burger.BurgerPrice = 0;
		burger.SubPrice=0;
	}
	/*회원정보 확인 메소드*/
	public static String CheckName() {
		System.out.println("회원님의 이름을 입력해 주세요");
		String Name = burger.sc.next();
		checkName= Name;
		for(int i =0;i<member.length;i++) {
			if(checkName.equals(member[i])) {
				return checkName;
			} 
		}
		for(int i =0;i<member.length;i++) {
			if(member[i]!=checkName) {
				i= 3;
				System.out.println("존재하지 않는 회원정보");
				burger.AllPrice=0;
			} 
		}
		//
		return checkName;
	}
	/*계산 메소드*/
	public static void Cal() {
		System.out.println("총 금액은 "+burger.AllPrice+"입니다.\n회원님의 계좌에 포인트를 적립하시겠습니까? Y N");
		String ch = burger.sc.next();
		
		
		if(ch.equals("Y") ||ch.equals("y")) {
			CheckName();
			for(int i=0;i<member.length;i++) {
				if(checkName.equals(member[i])) {
					System.out.println(member[i]+"님의 카드에"+(burger.AllPrice*0.01)+"점이 적립됐습니다.");
					memberAccountMoney[i] += (burger.AllPrice*0.01);
					System.out.println(member[i]+"님 계좌의 포인트="+memberAccountMoney[i]);
					burger.AllPrice = 0;
					
					/* 등급정하기 */
					Customer.grade(i); //Customer에 있는 grade()함수
 
				}
			} 
			
		}else if(ch.equals("N") ||ch.equals("n")) {
			System.out.println("이용해 주셔서 감사합니다.");
			burger.AllPrice = 0;
		}else {
			System.out.println("------------");
			System.out.println("잘못된 입력입니다.\n이전 페이지로 돌아갑니다.");
			System.out.println("------------");
			kiosk.Cal(); //잘못된 번호 입력시 이전으로 이동			
		}
		
	}
	
	public static void Cal2() {

		System.out.println("-회원정보확인-");
		CheckName();
		for(int i=0;i<member.length;i++) {
			if(checkName.equals(member[i])) {
				memberAccountMoney[i] += (burger.AllPrice*0.01);
				System.out.println(member[i]+"님 계좌의 포인트="+memberAccountMoney[i]);
				burger.AllPrice = 0;
				
				/* 등급정하기 */
				Customer.grade(i); //Customer에 있는 grade()함수
				System.out.println("처음 화면으로 돌아갑니다.");
				System.out.println("▶");
				kiosk.kio();//처음 실행화면으로 이동
			}
		} 

		
	}
	
	/*키오스크 메인메뉴 메소드*/
	public static void kio() {
		while(!st) {
			System.out.println("SubWay에 오신 것을 환영합니다! \n-----------------------");
			System.out.println("1.샌드위치주문  2.회원정보확인");
			int check = burger.sc.nextInt();
			if(check == 1) {
				burger.BurgerMain(); //햄버거 class로 이동
			}else if(check == 2) {
				kiosk.Cal2();
				//customer class로 이동
			}else {
				System.out.println("------------");
				System.out.println("잘못된 입력입니다.\n이전 페이지로 돌아갑니다.");
				System.out.println("------------");
				kiosk.kio(); //잘못된 번호 입력시 이전으로 이동				
			}
			Cal();
			reset();
		}
	}	
}