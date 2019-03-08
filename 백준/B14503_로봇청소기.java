import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14503_로봇청소기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 초기 로봇 위치
		st = new StringTokenizer(br.readLine().trim(), " ");
		int initx = Integer.parseInt(st.nextToken());
		int inity = Integer.parseInt(st.nextToken());
		int initdir = Integer.parseInt(st.nextToken());

		// 맵 입력
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// #구현
		// 청소한 칸 출력
		// 북 동 남 서
		int mCnt=1;
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(initx,inity,initdir));
		while(!q.isEmpty()) {
			int cx = q.peek().x;
			int cy = q.peek().y;
			int cdir = q.peek().dir;
			map[cx][cy]=2;	//현재 위치 청소
			q.poll();
			int tmpCnt =0;
			for (int i = 0; i < 4; i++) {
				//현재 방향기준으로 왼쪽부터 !!!! 탐색
				int ndir = cdir-1;
				if(ndir==-1) ndir=3;
				
				int nx = cx + dir[ndir][0];
				int ny = cy + dir[ndir][1];
				
				cdir=ndir;
				if(map[nx][ny]==0) {	//아직 청소 안한곳!!
					mCnt++;
					q.add(new Node(nx,ny,ndir));
					break;
				}
				tmpCnt++;
			}
			//네 방향 모두 청소 or 벽인 경우
			if(tmpCnt==4) {
				int backdir = (cdir+2)%4;
				int nx = cx + dir[backdir][0];
				int ny = cy + dir[backdir][1];
				//뒤에 벽인 경우
				if(map[nx][ny]==1) {
					break;	//게임 오버~
				}
				//뒤에 벽 아닌 경우
				else {
					q.add(new Node(nx,ny,cdir));
				}
			}
		}
		
		System.out.println(mCnt);

	}// end of main
	static class Node{
		int x;
		int y;
		int dir;
		Node(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}//end of Node{}
	
	private static int N;
	private static int M;
	private static int[][] map;
	private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1},};


}// end of class
