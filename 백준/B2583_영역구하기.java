import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2583_영역구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer	st =new StringTokenizer(br.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken());	//행
		int N = Integer.parseInt(st.nextToken());	//열
		int K = Integer.parseInt(st.nextToken());	//사각형수
		
		int[][] map	= new int[N+2][M+2];
		//맵 테두리
		for (int i = 0; i < map.length; i++) {
			if(i==0 || i == map.length-1) {
				for (int j = 0; j < M+2; j++) {
					map[i][j]=1;
				}
			}
			else {
				map[i][0]=1;
				map[i][M+1]=1;
			}
		}
		//맵입력
		for (int i = 0; i < K; i++) {
			st =new StringTokenizer(br.readLine(), " ");
			//가운데를 기준으로 하자
			//0 2 4 4	=> 0 2 3 3
			int ax = Integer.parseInt(st.nextToken())+1;
			int ay = Integer.parseInt(st.nextToken())+1;
			int bx = Integer.parseInt(st.nextToken())+1;
			int by = Integer.parseInt(st.nextToken())+1;
			for (int j = ax; j < bx; j++) {
				for (int k = ay; k < by; k++) {
					map[j][k]=1;
				}
			}
		}
		
		//#구현
		//첫째 줄에 분리되어 나누어지는 영역의 개수를 출력한다. 
		//둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬
		//직사각형 부분을 1로 처리하고 
		//0인점에서 bfs를 돌리자
		int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
		Queue<Node> q = new LinkedList<Node>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					q.add(new Node(i,j));
					int cnt = 1;
					while (!q.isEmpty()) {
						Node t = q.poll();
						int cx = t.x;
						int cy = t.y;
						
						for (int k = 0; k < dir.length; k++) {
							int nx =cx + dir[k][0];
							int ny =cy + dir[k][1];
							
							if(map[nx][ny]==0) {
								map[nx][ny]=1;
								cnt++;
								q.add(new Node(nx,ny));
							}
						}
					}
					al.add(cnt);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int alSize = al.size();
		sb.append(alSize).append("\n");
		Collections.sort(al);
		for (int i = 0; i < alSize; i++) {
			sb.append(al.get(i)).append(" ");
		}
		System.out.println(sb);
		
	}//end of main
	static class Node{
		int x;
		int y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}//end of Node
}//end of class
