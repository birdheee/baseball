package baseball_game;

import java.util.Random;
import java.util.Scanner;

public class Baseball {
	public static void main(String[] args) {
		
		Random rd = new Random();
		rd.setSeed(System.currentTimeMillis());
		Scanner sc = new Scanner(System.in);
		
		int arAnswer[] = new int[3]; //정답 배열
		int arUser[] = new int[3]; //유저가 입력한 숫자의 배열
		int ansNum1 = 0;
		int ansNum2 = 0;
		int ansNum3 = 0;
		int strike = 0;
		int ball = 0;
		
		while(ansNum1==ansNum2 || ansNum1==ansNum3 || ansNum2==ansNum3) { //중복되지 않는 세자리 수
			//세자리 난수 생성
			ansNum1 = rd.nextInt(10);
			ansNum2 = rd.nextInt(10);
			ansNum3 = rd.nextInt(10);
			
			//각 자리수를 정답 배열에 넣기
			arAnswer[0]=ansNum1;
			arAnswer[1]=ansNum2;
			arAnswer[2]=ansNum3;
		}
		
		while(true) {
			System.out.println("중복되지 않는 세자리 수를 입력하세요 : ");
			int userNum = sc.nextInt(); //세자리 수 입력받기
			
			//각 자리수를 분리하기
			int userNum1 = userNum/100;
			int userNum2 = (userNum/10)%10;
			int userNum3 = userNum%10;
			
			//유저 입력 배열에 넣기
			arUser[0]=userNum1;
			arUser[1]=userNum2;
			arUser[2]=userNum3;
			
			for(int i=0; i<3; i++) {
				if(arAnswer[i] == arUser[i]) strike+=1; //스트라이크 구하기
				else {
					for(int j=0; j<3; j++) {
						if(arAnswer[i] == arUser[j]) ball+=1; //볼 구하기
					}
				}
			}
			if(strike==3) { //정답인경우
				System.out.println(strike + "S" + ball + "B 정답입니다.");
				break;
			}
			if(strike==0 && ball==0) { //모두 틀린 경우
				System.out.println("아웃입니다.");
				continue;
			}
			System.out.println(strike + "S" + ball + "B");
		}
	}
}