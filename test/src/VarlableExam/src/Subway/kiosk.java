package VarlableExam.src.Subway;

import java.util.Scanner;

public class kiosk extends Subway{
	static boolean st = false;
	sub su = new sub();
	static String checkName;
	
	
	static String[] member = {"��ö��", "ȫ�浿", "������"};
	int[] memberAccount = {1,2,3};
	static int[] memberAccountMoney = {500, 300, 200};
	
	public static void reset() {
		burger.AllPrice =0;
		burger.BurgerPrice = 0;
		burger.SubPrice=0;
	}
	/*ȸ������ Ȯ�� �޼ҵ�*/
	public static String CheckName() {
		System.out.println("ȸ������ �̸��� �Է��� �ּ���");
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
				System.out.println("�������� �ʴ� ȸ������");
				burger.AllPrice=0;
			} 
		}
		//
		return checkName;
	}
	/*��� �޼ҵ�*/
	public static void Cal() {
		System.out.println("�� �ݾ��� "+burger.AllPrice+"�Դϴ�.\nȸ������ ���¿� ����Ʈ�� �����Ͻðڽ��ϱ�? Y N");
		String ch = burger.sc.next();
		
		
		if(ch.equals("Y") ||ch.equals("y")) {
			CheckName();
			for(int i=0;i<member.length;i++) {
				if(checkName.equals(member[i])) {
					System.out.println(member[i]+"���� ī�忡"+(burger.AllPrice*0.01)+"���� �����ƽ��ϴ�.");
					memberAccountMoney[i] += (burger.AllPrice*0.01);
					System.out.println(member[i]+"�� ������ ����Ʈ="+memberAccountMoney[i]);
					burger.AllPrice = 0;
					
					/* ������ϱ� */
					Customer.grade(i); //Customer�� �ִ� grade()�Լ�
 
				}
			} 
			
		}else if(ch.equals("N") ||ch.equals("n")) {
			System.out.println("�̿��� �ּż� �����մϴ�.");
			burger.AllPrice = 0;
		}else {
			System.out.println("------------");
			System.out.println("�߸��� �Է��Դϴ�.\n���� �������� ���ư��ϴ�.");
			System.out.println("------------");
			kiosk.Cal(); //�߸��� ��ȣ �Է½� �������� �̵�			
		}
		
	}
	
	public static void Cal2() {

		System.out.println("-ȸ������Ȯ��-");
		CheckName();
		for(int i=0;i<member.length;i++) {
			if(checkName.equals(member[i])) {
				memberAccountMoney[i] += (burger.AllPrice*0.01);
				System.out.println(member[i]+"�� ������ ����Ʈ="+memberAccountMoney[i]);
				burger.AllPrice = 0;
				
				/* ������ϱ� */
				Customer.grade(i); //Customer�� �ִ� grade()�Լ�
				System.out.println("ó�� ȭ������ ���ư��ϴ�.");
				System.out.println("��");
				kiosk.kio();//ó�� ����ȭ������ �̵�
			}
		} 

		
	}
	
	/*Ű����ũ ���θ޴� �޼ҵ�*/
	public static void kio() {
		while(!st) {
			System.out.println("SubWay�� ���� ���� ȯ���մϴ�! \n-----------------------");
			System.out.println("1.������ġ�ֹ�  2.ȸ������Ȯ��");
			int check = burger.sc.nextInt();
			if(check == 1) {
				burger.BurgerMain(); //�ܹ��� class�� �̵�
			}else if(check == 2) {
				kiosk.Cal2();
				//customer class�� �̵�
			}else {
				System.out.println("------------");
				System.out.println("�߸��� �Է��Դϴ�.\n���� �������� ���ư��ϴ�.");
				System.out.println("------------");
				kiosk.kio(); //�߸��� ��ȣ �Է½� �������� �̵�				
			}
			Cal();
			reset();
		}
	}	
}