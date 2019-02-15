import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B4963_섬의개수 {

	private static int[][] map;
	private static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 },
			{ -1, -1 }, };
	private static int cnt;
	private static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		// 입력이 없을때까지 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break; // 종료 조건

			map = new int[w + 2][h + 2];
			for (int i = 0; i < w + 2; i++) {
				for (int j = 0; j < h + 2; j++) {
					map[i][j]=-1;
				}
			}

			for (int i = 1; i < w + 1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j < h + 1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[w+2][h+2];
			cnt=0;
			
			// #구현
			for (int i = 1; i < w + 1; i++) {
				for (int j = 1; j < h + 1; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						visited[i][j]= true;
						cnt++;
						func(i, j);
					}
				}
			}

			System.out.println(cnt);
		}
		
	}// end of main
	
	private static void func(int ci, int cj) {
		for (int move = 0; move < 8; move++) {
			int ni =  ci + dir[move][0];
			int nj =  cj + dir[move][1];
			
			if(visited[ni][nj]) continue;
			if(map[ni][nj] ==1) {
				visited[ni][nj]=true;
				func(ni,nj);
			}
		}
	}

}// end of class
