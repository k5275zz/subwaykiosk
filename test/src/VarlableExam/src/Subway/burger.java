package VarlableExam.src.Subway;

import java.util.Scanner;
public class burger extends Subway{
	
	static sub sb = new sub();
	static Scanner sc = new Scanner(System.in);
	// ������ �� �ִ� �޴��� �޴��� ���� ����
	static String[] �� = {"ȭ��Ʈ","�÷�","��Ʈ","��� ��Ʈ(1000�� �߰�)","�ĸ���(1000�� �߰�)"};
	static int[] breadPrice = {2100,2200,2300,3000,3100,};
	static String[] ��� = {"��","BLT","������ũ","��ũ","�ν��͸� ġŲ"};
	static int[] meatPrice = {3000,3100,3200,3300,3400};
	static String[] �ҽ�={"�������","����ĥ��","��ϸӽ�Ÿ��","��ĥ��","��ġ"};
	static String[] ��ä = {"����","��Ŭ","�Ҷ��Ǵ�","����","�Ǹ�"};
	//���� ����, ����+����޴� �ʵ�
	static int AllPrice =0;
	static int BurgerPrice = 0;
	static int SubPrice=0;
	
	
	
	//15cm, 30cm ���� ���� �޼ҵ� 30cm ���ý� 15cm ����(��+���)�� 2���� ������ ����
	public static void SmallOrBig() {
		System.out.println("1.15cm�� �Ͻðڽ��ϱ�? 2.30cm�� �Ͻðڽ��ϱ�?");
		int ch = sc.nextInt();
		int x = burger.chooseMenu(��, "��");
		int y = burger.chooseMenu(���, "���");
		if(ch == 1) {
			BurgerPrice = (x+y);
		} else if(ch == 2) {
			BurgerPrice = (x+y)*2;
		}
	}
	
	// �޴� ���ð� ���õ� �޼ҵ� �ŰԺ����� �ٸ��� ������ �� å���Ǵ� ���ݰ� ������ �޴�����Ʈ�� �����
	public static int chooseMenu(String[] name,String name2) {
		System.out.println("���Ͻô� "+name2+"(��)�� ������ �ּ���:");
		ShowMaterial(name);
		int chooseNum = sc.nextInt();
		if(name.equals(��)) {
			BurgerPrice += breadPrice[chooseNum-1];
			return breadPrice[chooseNum-1];
		} else if(name.equals(���)) {
				BurgerPrice += meatPrice[chooseNum-1];
				return meatPrice[chooseNum-1];
		}
		return BurgerPrice;
	}
	// ��ä, �ҽ��� �߰� ���� ���� ����ϴ� �޼ҵ�
	public static void AddOrPlusSauce(String [] name) {
		if(name.equals(�ҽ�)) {
			System.out.println("�� ���� �ҽ��� ���� ������ �������ּ���");
			int ChooseSauce = sc.nextInt();
			String[] chooseWhatSauce = new String[ChooseSauce];
			ShowMaterial(�ҽ�);
			System.out.println("���Ͻô� �ҽ��� ����ּ���:");
			for(int i = 0; i<ChooseSauce;i++) {
				int ch = sc.nextInt();
				if(chooseWhatSauce[i] == null) {
					chooseWhatSauce[i] = �ҽ�[ch-1];
				}
			}
			ShowMaterial2(chooseWhatSauce);
		} else if(name.equals(��ä)) {
			System.out.println("������ ��ä�� ���� �����ּ���");
			int ChooseVage = sc.nextInt();
			String[] chooseWhatVage = new String[ChooseVage];
			ShowMaterial(��ä);
			System.out.println("���� ���� ��ä�� ����ּ���:");
			for(int i = 0; i<ChooseVage;i++) {
				int ch = sc.nextInt();
				if(chooseWhatVage[i] == null) {
					chooseWhatVage[i] = ��ä[ch-1];
				}
			}
			ShowMaterial2(chooseWhatVage);
		} 
	}
		//����޴� Ŭ������ �������� �޼ҵ�.
		public static void ChooseSubMenu() {
			System.out.println("���� �޴��� �߰��� ��Ű�ڽ��ϱ�?\nY N");
			String ChooseNum = sc.next();
			if(ChooseNum.equals("Y") ||ChooseNum.equals("y")) {
				sb.Info();
				SubPrice = sb.result;
			} else if(ChooseNum.equals("N") ||ChooseNum.equals("n")) {
				System.out.println("");
			}else 
			{
				System.out.println("------------");
				System.out.println("�߸��� �Է��Դϴ�.\n���� �������� ���ư��ϴ�.");
				System.out.println("------------");
				burger.ChooseSubMenu();
			}
		}
		//�޴��� ��� �����Ǵ����� �����ִ� �޼ҵ�
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
			AddOrPlusSauce(�ҽ�);
			AddOrPlusSauce(��ä);
			ChooseSubMenu();
			AllPrice += (BurgerPrice+SubPrice);
		}
}