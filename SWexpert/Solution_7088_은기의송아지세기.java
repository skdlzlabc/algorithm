import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7088_은기의송아지세기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		for (int z = 1; z <= testCase; z++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	//N개의 줄의 i번째 줄에는 고유번호 i번 소의 품종 번호
			int Q = Integer.parseInt(st.nextToken());	//Q개의 줄의 i번째 줄에는 i번째 질문에 해당하는 Li , Ri
			//N Q 1~100000
			
			// 1번부터 3번까지의 품종 번호
			int[][] arrCnt = new int[N+1][4];	//1 2 3 카운트 1~N
			for (int j = 1; j <= N; j++) {//현재 그 줄에 있는거 체크
				int kind = Integer.parseInt(br.readLine());// N개줄에 입력받을꺼
				switch (kind) {
				case 1:
					arrCnt[j][1]+=arrCnt[j-1][1]+1;
					arrCnt[j][2]+=arrCnt[j-1][2];
					arrCnt[j][3]+=arrCnt[j-1][3];
					break;
				case 2:
					arrCnt[j][2]+=arrCnt[j-1][2]+1;
					arrCnt[j][1]+=arrCnt[j-1][1];
					arrCnt[j][3]+=arrCnt[j-1][3];
					break;
				case 3:
					arrCnt[j][3]+=arrCnt[j-1][3]+1;
					arrCnt[j][1]+=arrCnt[j-1][1];
					arrCnt[j][2]+=arrCnt[j-1][2];
					break;
				default:
					break;
				}
			}
			
			sb.append("#").append(z).append(" ").append("\n");
			for (int i = 0; i < Q; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cnt_1 = arrCnt[end][1]-arrCnt[start-1][1];
				int cnt_2 = arrCnt[end][2]-arrCnt[start-1][2];
				int cnt_3 = arrCnt[end][3]-arrCnt[start-1][3];
				sb.append(cnt_1).append(" ").append(cnt_2).append(" ").append(cnt_3).append("\n");
			}
		}
		System.out.print(sb);
		
		
	}//end of main
}//end of class

