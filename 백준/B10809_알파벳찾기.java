	package bakjoon;
	
	import java.util.Scanner;
	/*
	 * 알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 
	 * 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
	 */
	public class B10809_알파벳찾기 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String str = sc.next();
			int[] alpha = new int[26];
			for (int i = 0; i < alpha.length; i++) {
				alpha[i]=-1;
			}
			
			//알파벳 나오면 alpah배열에 인덱스값 저장
			for (int i = 0; i < str.length(); i++) {
				int tmp = (int)str.charAt(i)-97;
				if(alpha[tmp] ==-1) {//처음 나올떄만 체크
					alpha[tmp]=i;
				}
			}
			
			for (int i = 0; i < alpha.length; i++) {
				if(alpha[i]!=-1)
					System.out.print(alpha[i]+" ");
				else
					System.out.print(-1+" ");
			}
			
			
			sc.close();
		}	//end of main
	}	//end of class
