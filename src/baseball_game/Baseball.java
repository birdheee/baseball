package baseball_game;

import java.util.Random;
import java.util.Scanner;

public class Baseball {
	public static void main(String[] args) {
		
		Random rd = new Random();
		rd.setSeed(System.currentTimeMillis());
		Scanner sc = new Scanner(System.in);
		
		int arAnswer[] = new int[3]; //���� �迭
		int arUser[] = new int[3]; //������ �Է��� ������ �迭
		int ansNum1 = 0;
		int ansNum2 = 0;
		int ansNum3 = 0;
		int strike = 0;
		int ball = 0;
		
		while(ansNum1==ansNum2 || ansNum1==ansNum3 || ansNum2==ansNum3) { //�ߺ����� �ʴ� ���ڸ� ��
			//���ڸ� ���� ����
			ansNum1 = rd.nextInt(10);
			ansNum2 = rd.nextInt(10);
			ansNum3 = rd.nextInt(10);
			
			//�� �ڸ����� ���� �迭�� �ֱ�
			arAnswer[0]=ansNum1;
			arAnswer[1]=ansNum2;
			arAnswer[2]=ansNum3;
		}
		
		while(true) {
			System.out.println("�ߺ����� �ʴ� ���ڸ� ���� �Է��ϼ��� : ");
			int userNum = sc.nextInt(); //���ڸ� �� �Է¹ޱ�
			
			//�� �ڸ����� �и��ϱ�
			int userNum1 = userNum/100;
			int userNum2 = (userNum/10)%10;
			int userNum3 = userNum%10;
			
			//���� �Է� �迭�� �ֱ�
			arUser[0]=userNum1;
			arUser[1]=userNum2;
			arUser[2]=userNum3;
			
			for(int i=0; i<3; i++) {
				if(arAnswer[i] == arUser[i]) strike+=1; //��Ʈ����ũ ���ϱ�
				else {
					for(int j=0; j<3; j++) {
						if(arAnswer[i] == arUser[j]) ball+=1; //�� ���ϱ�
					}
				}
			}
			if(strike==3) { //�����ΰ��
				System.out.println(strike + "S" + ball + "B �����Դϴ�.");
				break;
			}
			if(strike==0 && ball==0) { //��� Ʋ�� ���
				System.out.println("�ƿ��Դϴ�.");
				continue;
			}
			System.out.println(strike + "S" + ball + "B");
		}
	}
}