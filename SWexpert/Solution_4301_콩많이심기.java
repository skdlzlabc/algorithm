import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4301_콩많이심기 {
	static int[][] map = new int[1001][1001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		boolean check=true;
		//일단 채우고 돌자
//		int[][] map = new int[1001][1001];
		for (int i = 1,j=1; i < map.length-1; i+=2) {//행
			if(!check) {
				j=3;
			}else {
				j=1;
			}
			check=!check;
			for (; j < map.length-1; j++) {//열
				map[i][j]=1;
				map[i][j+1]=1;
				map[i+1][j]=1;
				map[i+1][j+1]=1;
				j+=3;
			}
		}
		for (int z = 1; z <= tc; z++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int cnt=0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if(map[i][j]==1)cnt ++;
				}
			}
			System.out.println("#"+z+" "+cnt);
		}//end of for()
	}//end of main
}//end of class
