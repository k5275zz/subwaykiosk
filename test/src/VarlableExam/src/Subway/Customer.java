package VarlableExam.src.Subway;

import java.util.Scanner;

public class Customer extends kiosk{
		

			Scanner sc = new Scanner(System.in);	
			
			public static void grade(int i) {
				String level = null;
				System.out.println("★");
				if(memberAccountMoney[i]<600) {
					level = "CLASSIC";
				}else if(memberAccountMoney[i]>600&&memberAccountMoney[i]<700) {
					level = "LIGHT";
				}else if(memberAccountMoney[i]>700&&memberAccountMoney[i]<800) {
					level = "PREMIUM";
				}else if(memberAccountMoney[i]>800) {
					level = "VIP";
				}
				System.out.println(member[i]+"님의 현재등급은 "+level+"입니다.");
				System.out.println("★"); 
		}
			
			
}
		
		
