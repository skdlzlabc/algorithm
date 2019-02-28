import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1256_K번째접미어 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		for (int z = 1; z <= testCase; z++) {
			int N = Integer.parseInt(br.readLine())-1;//0번째 부터
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

			//#출력
			sb.append("#").append(z).append(" ");
			//N번째 
			for (int i = stail[N]; i < stail.length; i++) {
				sb.append(s.charAt(i));
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
		
	}//end of main

}//end of class
