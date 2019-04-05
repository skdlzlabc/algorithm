import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4613_러시아국기같은깃발 {
	private static int[][] memo;
	private static int N;
	private static int M;
	private static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int z = 1; z <= tc; z++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			for (int i = 0; i < map.length; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = tmp.charAt(j);
				}
			}
			/*
			 * W 최소 1줄 B 최소 1줄 R 최소 1줄 ~까지 하겠다. 그 줄을 해당 색깔로 칠했을때 변경되는거 최소 출력
			 */
			int min = Integer.MAX_VALUE;
			/*
			 * 그 행을 그 색깔로 했을때 결과를 미리 저장해두자
			 */
			memo = new int[3][N];
			for (int i = 1; i <= N-2; i++) {
				int a= f(0,i,'W',0);
				for (int j = 1; i+j <= N-1; j++) {
					int b= f(i,i+j,'B',1);
					int c= f(i+j,N,'R',2);
					if(a+b+c < min) min = a+b+c;
				}
			}
			System.out.println("#" + z + " " + min);
			
		} // end of for tc
	}// end of main

	public static int f(int i, int j, char who, int whon) {
		int cnt=0;
		for (int k = i; k < j; k++) { // i<=  <j 
			if (memo[whon][k] != 0) {
				cnt += memo[whon][k];
			} else {
				for (int m = 0; m < M; m++) {
					if (map[k][m] != who) {
						cnt++;
						memo[whon][k]++;
					}
				}
			}
		}
		return cnt;
	}//end of f()
}// end of class
