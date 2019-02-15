import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B2667_단지번호붙이기 {

	private static ArrayList<Integer> ansList = new ArrayList<Integer>();
	private static boolean[][] visited;
	private static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	private static int[][] map;
	private static int cnt =1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N+2][N+2];
		
		for (int i = 0; i < N+2; i++) {
			for (int j = 0; j < N+2; j++) {
				map[i][j]=-1;
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			String str= br.readLine();
			for (int j = 1; j < N+1; j++) {
				map[i][j]=str.charAt(j-1)-'0';
			}
		}
		
		//#구현
		visited = new boolean[N+2][N+2];
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(map[i][j]==1&&!visited[i][j]) {
					cnt=1;
					visited[i][j]=true;
					func(i,j);
					ansList.add(cnt);
				}
			}
		}
		
		//#출력
		System.out.println(ansList.size());
		Collections.sort(ansList);
		for (int i = 0; i < ansList.size(); i++) {
			System.out.println(ansList.get(i));
		}
		
	}//end of main
	
	private static void func(int ci, int cj) {
		for (int i = 0; i < 4; i++) {
			int ni = ci + dir[i][0];
			int nj = cj + dir[i][1];

			if(visited[ni][nj]) continue;
			if(map[ni][nj] ==1) {
				visited[ni][nj]=true;
				func(ni,nj);
				cnt++;
			}
		}
		
	}//end of func()
}//end of class
