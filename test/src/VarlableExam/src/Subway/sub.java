package VarlableExam.src.Subway;

import java.util.Scanner;

public class sub extends Subway {
	String[] submenu= {"�Ƹ޸�ī��","����Ʈ��","ġ�ƽ"};//�޴��̸�
	int[] price = {1500,1200,1000};
	Scanner sc = new Scanner(System.in);
	int result;
	
	@Override
	public void Info() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���Ͻô� �޴��� ������ �ּ��� \n1.�Ƹ޸�ī�� 2.����Ʈ�� 3.ġ�ƽ");
		int i = sc.nextInt();
		System.out.println("���Ͻô� ������ �������ּ���.");
		int count = sc.nextInt();//����
		
		result = count*price[i-1];
		System.out.println(submenu[i-1]+" "+count+"���� ������:"+result+"�Դϴ�.");
	}
}