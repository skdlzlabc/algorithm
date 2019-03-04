import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1493_수의새로운연산 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		//미리 맵 만들자
		/* 1
		 * 2 3
		 * 4 5 6
		 * 7 8 9 10
		 */
		int[][] map = new int[500][500];

		int index=1;
		for (int i = 0; i < map.length; i++) {	//행
			for (int j = 0; j < i+1; j++) { //열
				map[i][j]=index++;
			}
		}
		
		for (int z = 1; z <= testCase; z++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			/*
			 * 오르쪽으로 몇칸이냐
			 * 아래로 몇칸이냐
			 */
			int Ni=0;
			int Nj=0;
			int Mi=0;
			int Mj=0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][j]==N) {
						Ni=i;
						Nj=j;
					}
					if(map[i][j]==M) {
						Mi=i;
						Mj=j;
					}
					
				}
			}
			int result = map[Ni+1+Mi+1][Nj+Mj+1];
			
			
			sb.append("#").append(z).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
		
		
	}//end of main
}//end of class
