package bakjoon;

import java.util.Scanner;

public class B1152_단어의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		/*
		 * 처음 끝 제외하고 공백 찾고 
		 * 나중에 따로
		 * ****공백만 입력하는 경우
		 */
		if(str.length()==1 && str.charAt(0)==' ')
			System.out.println(0);
		else {
			int cnt=1;
			for (int i = 0; i < str.length(); i++) {
				
				if(i==0 || i==str.length()-1) {
					if(str.charAt(i)==' ') continue;	//처음 끝따로
				}
				else {
					if(str.charAt(i)==' ') cnt++;
				}
			}
			System.out.println(cnt);
		}
	}	//end of main
}	//end of class
