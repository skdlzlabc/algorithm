package bakjoon;

import java.util.Scanner;

/*
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 
 * 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 */
public class B1157_알파벳공부 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		String str = sc.next();
		
		str = str.toUpperCase();
		int[] alpha = new int[26];
		int max =0;
		int resultIndex= 0;
		//알파벳 배열을 만들어서 나올떄마다 값 1씩 더하기
		for (int i = 0; i < str.length(); i++) {
			int tmp=(int)str.charAt(i)-65;
			alpha[tmp]++;
			if(max <= alpha[tmp]) {
				max = alpha[tmp];
				resultIndex = tmp;
			}
		}
		
		//같은거 찾기
		int cnt =0;
		for (int i = 0; i < alpha.length; i++) {
			if(alpha[i] == max && cnt !=2) {
				cnt++;
			}
		}
		
		if(cnt==2) {
			System.out.println("?");
		}
		else {
			//숫자 -> 문자
			System.out.println((char)(65+resultIndex));
		}
		
		sc.close();
	}	//end of main
}	//end of class
