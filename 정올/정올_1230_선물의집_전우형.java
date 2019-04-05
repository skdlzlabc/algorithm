import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정올_1230_선물의집 {
	private static int N;
	private static int max;
	private static int[][] map;
	private static int[][] memo;
	private static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+2][N+2];
		memo = new int[N+2][N+2];
		visited = new boolean[N+2][N+2];
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < N+1; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N+2; i++) {
			map[0][i]=1;
			map[i][0]=1;
			map[N+1][i]=1;
			map[i][N+1]=1;
		}
		
//		메모이제이션하자
		visited[1][1]=true;
		if(map[1][1]==2) max=1;
		f(1,1,max);
		System.out.println(max);
	}//end of main
	static int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};
	public static void f(int i, int j,int cnt) {
		if(i==N && j==N) {
			max= cnt > max? cnt :max;
			return;
		}
			//0 길, 1벽, 2선물위치
		for (int k = 0; k < dir.length; k++) {
			int nx = i + dir[k][0];
			int ny = j + dir[k][1];
			if(map[nx][ny]==1) continue;
			if(visited[nx][ny]) continue;
			int ncnt = cnt;
			if(map[nx][ny]==2) ncnt++;
			visited[nx][ny]= true;
			f(nx,ny,ncnt);
			visited[nx][ny]= false;
		}
	}
}//end of class
