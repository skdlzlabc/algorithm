import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정올1462_보물섬 {

	private static boolean[][] visited;
	private static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	private static int[][] map;
	private static int N;
	private static int M;
	private static boolean[][] visited2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map	= new int[N][M];
		visited	= new boolean[N][M];
		visited2= new boolean[N][M];	//L인 모든 자리에서 함수를 돌리기 위해 초기맵 보존용
		for (int i = 0; i < N; i++) {
			String str= br.readLine();
			for (int j = 0; j < M; j++) {
				int tmp = str.charAt(j);
				map[i][j]=tmp;
				if(tmp=='L') {
					visited[i][j]=true;
					visited2[i][j]=true;
				}
			}
		}
		
		
		int max= 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//모든 곳에서 다 시작 해야함!!!
				for (int k = 0; k < N; k++) {	//초기맵 복사
					visited2[k]=visited[k].clone();
				}
				if(visited[i][j]) {
					int tmp = bfs(i,j);
					if(max < tmp) max = tmp;
					//visited초기화
				}
			}
		}
		
		System.out.println(max);
		
	}//end of main
	
	public static int bfs(int i, int j) {
		node3[] q = new node3[50*50+1];
		int front=-1,rear=-1;
		
		++rear;
		q[rear] = new node3(i,j,0);
		while(front!=rear) {
			front++;
			int cx = q[front].i;
			int cy = q[front].j;
			int cdep = q[front].depth;
			
			for (int k = 0; k < 4; k++) {
				int nx = cx+dir[k][0];
				int ny = cy+dir[k][1];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue; //범위 벗어남
				
				if(visited2[nx][ny] && map[nx][ny]=='L') {
					rear++;
					q[rear] = new node3(nx,ny,cdep+1);
					visited2[nx][ny]=false;
				}
			}
		}
		return q[rear].depth;
	}//end of bfs()
	
}//end of class

class node3{
	int i;
	int j;
	int depth;
	node3(int i, int j, int depth) {
		this.i = i;
		this.j = j;
		this.depth = depth;
	}
}





