import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1257_K번째문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		for (int z = 1; z <= testCase; z++) {
			int N = Integer.parseInt(br.readLine());//0번째 부터
			String s = br.readLine();
			
			//#구현
			//suffixArray이용 : 텍스트의 접미어들을 사전식으로 나열한 배열
			int[] stail = new int[s.length()];
			for (int i = 0; i < stail.length; i++) {
				stail[i]=i;	//i == s의 인덱스, stail[0]=0; s의 0번째 인덱스부터 시작
			}
			
			//선택정렬
			for (int i = 0; i < stail.length; i++) {
				int minIndex = i;
				for (int j = i; j < stail.length; j++) {
					if(s.substring(stail[minIndex]).compareTo(s.substring(stail[j]))>0) {
						minIndex=j;
					}
				}
				int tmp = stail[minIndex];
				stail[minIndex] = stail[i] ;
				stail[i] = tmp;
			}

			//LCP구하기
			int[] LCP = new int[s.length()];	//최장 공통 접두어 저장할 배열, 위에랑 내꺼랑 몇개가 겹치냐!
			for (int i = 1; i < LCP.length; i++) {
				String sPre = s.substring(stail[i-1]);
				String sCur = s.substring(stail[i]);
				
				while(sPre.length()> LCP[i] && sCur.length()> LCP[i]
						&& sPre.charAt(LCP[i]) == sCur.charAt(LCP[i])) {
					LCP[i]++;		
				}
			}
			
			//#출력
			sb.append("#").append(z).append(" ");
			boolean flag = false;
			for (int i = 0; i < stail.length; i++) {
				String str = s.substring(stail[i]);	//i번째 시작하는 접미사 구하기
				
				if(N - (str.length()-LCP[i]) > 0) {		//0이상이여야해
					N = N - (str.length()-LCP[i]);	//유효한갯수를 계속 뺄셈 한다.
				}
				else { 			//0이 되거나 음수가 되는경우에 답이 있는거야!!
					sb.append(str.substring(0,LCP[i]+N));
					flag=true;
					break;
				}
			}
			if(!flag) sb.append("none");
			sb.append("\n");
		}
		System.out.print(sb);
		
		
	}//end of main

}//end of class
