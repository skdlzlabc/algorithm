import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 정올_2613_토마토 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int M = Integer.parseInt(st.nextToken());	//이게 열!
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 2][M + 2];

		boolean[][] visited = new boolean[N+2][M+2];
		Queue<Node>	q = new LinkedList<Node>();
		int cntZero =0;
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					q.add(new Node(i,j,0));	
					visited[i][j]=true;	//처음토마토 방문처리 ************
				}
				else if(map[i][j]==0) {
					cntZero++;
				}
			}
		}
		//초기에 토마토가 하나도 없다!!!!!!!!! => 바로 종료
		if(q.isEmpty()) {
			System.out.println(-1);
			return;
		}
		//전부 익어있다!!!
		else if(q.size()==N*M) {
			System.out.println(0);
			return;
		}
		//맵 테두리 -1 넣기			==> 정사각형이 아닌경우 조심!!!!!*******
		for (int i = 0; i < N+2; i++) {
			if(i==0 || i==N+1) {	//젤위랑 젤 아래만 체크
				for (int j = 0; j < M+2; j++) {
					map[i][j]=-1;
				}
			}
			else {//중간부분은 끝점만!!!
				map[i][0]=-1;
				map[i][M+1]=-1;
			}
		}
		/*
		 * -보관 하루가 지나면, 익은 토마토 인접한 안익은 애들 익어
		 * -며칠이 지나면 다 익는 지, 최소 일수!!!
		 * - 0 : 안익은 , 1: 익은, -1: 공란
		 */
		//#구현
		//큐에 하나씩 넣고서 확장하자!!
		//방문 체크해서 같은공간을 두번 탐색하지 않게 하자!!!!	=>성능!
		//0의 개수를 따라가서 마지막에 0이 남아있으면 -1 출력
		int minDay=0;
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		while(!q.isEmpty()) {
			int cQueSize = q.size();
			//현재 큐에 들어 있는애들 전 방향으로 다 퍼져야돼
			for (int i = 0; i < cQueSize; i++) {
				int cx = q.peek().x;
				int cy = q.peek().y;
				int cday = q.peek().day;
				q.poll();
				for (int j = 0; j < 4; j++) {
					int nx = cx + dir[j][0];
					int ny = cy + dir[j][1];
					
					if(visited[nx][ny]) continue;	//방문했으면 또 안해
					
					if(map[nx][ny]==0) {	//토마토 안익었으면
						cntZero--;	//0인 부분개수 빼주자. 나중에 불능경우 체크위해
						map[nx][ny]=1;
						visited[nx][ny]=true;
						if(cday+1>minDay) minDay = cday+1;	//최소 일수 알기 위해
						q.add(new Node(nx,ny,cday+1));
					}
				}
				
			}//end of cQueSize
			
		}//end of while (q)
		
		if(cntZero!=0) {	//토마토가 익지 못하는 상황!!
			System.out.println(-1);
		}
		else {	//전부 익은경우!
			System.out.println(minDay);
		}

	}// end of main
	static class Node{
		int x;
		int y;
		int day;
		Node(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
		
	}//end of Node{}
}// end of class
