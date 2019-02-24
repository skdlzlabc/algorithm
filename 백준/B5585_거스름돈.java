import java.util.Scanner;

public class B5585_거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pay = sc.nextInt();
		
		//#구현
		//500 100 50 10 5 1
		//방법1: 그리디로 큰돈으로 먼저 거슬러 주자
		int cur=1000-pay;
		int cnt= 0;
		while(true) {
			if(cur-500>=0) {
				cur-=500;
				cnt++;
			}
			else if(cur-100>=0) {
				cur-=100;
				cnt++;
			}
			else if(cur-50>=0) {
				cur-=50;
				cnt++;
			}
			else if(cur-10>=0) {
				cur-=10;
				cnt++;
			}
			else if(cur-5>=0) {
				cur-=5;
				cnt++;
			}
			else if(cur-1>=0) {
				cur-=1;
				cnt++;
			}
			
			if(cur==0) break;
		}

		System.out.println(cnt);
	}//end of main
}//end of class
