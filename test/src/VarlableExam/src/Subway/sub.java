package VarlableExam.src.Subway;

import java.util.Scanner;

public class sub extends Subway {
	String[] submenu= {"아메리카노","소프트콘","치즈스틱"};//메뉴이름
	int[] price = {1500,1200,1000};
	Scanner sc = new Scanner(System.in);
	int result;
	
	@Override
	public void Info() {
		Scanner sc = new Scanner(System.in);
		System.out.println("원하시는 메뉴를 선택해 주세요 \n1.아메리카노 2.소프트콘 3.치즈스틱");
		int i = sc.nextInt();
		System.out.println("원하시는 수량을 선택해주세요.");
		int count = sc.nextInt();//수량
		
		result = count*price[i-1];
		System.out.println(submenu[i-1]+" "+count+"개의 가격은:"+result+"입니다.");
	}
}