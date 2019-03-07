import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1258_행렬찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		for (int z = 1; z <= testCase; z++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			//#구현
			//각각의 행과 열을 알아야해
			//bfs로 탐색해야겠다 0이 아닐때까지 visited 체크 하고!
			//시작점하고 제일 끝점간의 거리로 크기 알아 내자!!!
			List<Node8> listForComp = new ArrayList<Node8>();
			int boxCnt=0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j]!=0) {
						q = new LinkedList<Node7>();
						q.add(new Node7(i,j));
						visited[i][j]=true;
						f(i,j);
						boxCnt++;

						//부분 행렬들을 개수와 그 뒤를 이어 행렬들의 행과 열의 크기를 출력
						//크기는 행과 열을 곱한 값으로, 크기가 작은 순서대로 출력한다.
						//예를 들어 3x4 행렬의 크기는 3*4 = 12 이다.
						//크기가 같을 경우 행이 작은 순으로 출력
						int tmpx =terx-i+1;
						int tmpy =tery-j+1;
						listForComp.add(new Node8(tmpx,tmpy,tmpx*tmpy));
					}
				}
			}
			
			Collections.sort(listForComp);
			sb.append("#").append(z).append(" ").append(boxCnt).append(" ");
			int listSize =listForComp.size();
			for (int i = 0; i <listSize; i++) {
				sb.append(listForComp.get(i).x).append(" ").append(listForComp.get(i).y).append(" ");
			}
			sb.append("\n");
		}//end of for
		System.out.print(sb);
		
		
	}// end of main
	
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	private static Queue<Node7> q;
	private static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	private static int terx;	//끝점 추출
	private static int tery;	//끝점 추출
	public static void f(int i, int j) {
		int cx=0;
		int cy=0;
		while(!q.isEmpty()) {
			cx = q.peek().x;
			cy = q.peek().y;
			q.poll();
			
			for (int k = 0; k < dir.length; k++) {
				int nx = cx + dir[k][0];
				int ny = cy + dir[k][1];
			
				if(nx<0 || nx >=N || ny<0 || ny>=N) continue;	//맵 벗어나면 패스
				
				if(map[nx][ny]==0) continue;	//0이면 패스 
				
				if(visited[nx][ny]) continue;	//방문이미 했으면 패스
				
				visited[nx][ny]=true;
				q.add(new Node7(nx,ny));
			}
		}
		
		terx = cx;	//마지막에 큐에 들어 있던애가 마지막에 방문하는애 !!
		tery = cy;
	}

	static class Node7{
		int x;
		int y;
		Node7(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}//end of Node7{}

	static class Node8 implements Comparable<Node8>{
		int x;
		int y;
		int size;
		Node8(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
		
		@Override
		public int compareTo(Node8 o) {
			if(this.size == o.size) {
				return this.x-o.x;	//크기같으면 행이 작은순
			}
			else
			return this.size-o.size;	//크기는 작은순, 오름차순
		}
	}//end of Node8{}
}// end of class



/*
 * #Queue<Node7> q = new LinkedList<Node7>();
 * 이렇게 안하고
 * LinkedList<Node7> q = ""
 * 이렇게 하니까 원하는 대로 안됨
 * 
 * #static 클래스를 쓰자!!!
 * 같은 프로젝트내 다른 자바파일 클래스 자꾸 사용
 */ 
 
	