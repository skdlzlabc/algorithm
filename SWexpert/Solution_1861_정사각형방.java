import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {
	private static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	private static int[][] map;
	private static int N;
	private static LinkedList<Node6> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		for (int z = 1; z <= testCase; z++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			//물론 이동하려는 방이 존재해야 하고, 이동하려는 방에 적힌 숫자가 현재 방에 적힌 숫자보다 정확히 1 더 커야 한다.
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			//#구현
			//큐를 이용해서 다 돌자
			List<Node6> findAnswer = new ArrayList<Node6>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					q = new LinkedList<Node6>();
					q.add(new Node6(i,j,1,0));	//처음부터 1칸
					int curMoveCnt = f(i,j);
					//#이동할 수 있는 방의 개수가 최대인 방이 여럿이라면 그 중에서 적힌 수가 가장 작은 것을 출력한다
					//=>일단 리스트로 만들고
					//=>클래스로 정렬하고 젤 앞수 뽑자
					if(curMoveCnt!=1)
					findAnswer.add(new Node6(i,j,curMoveCnt,map[i][j]));
				}
			}
			
			Collections.sort(findAnswer);
			
			//방번호(같은면 작은걸로) 와 최대 몇개방을 이동 할수 있는지!
			sb.append("#").append(z).append(" ").append(findAnswer.get(0).value).append(" ").append(findAnswer.get(0).depth).append("\n");
		}
		System.out.print(sb);
		
		
	}//end of main

	public static int f(int i, int j) {
		
		int maxdepth=1;	//처음에 ㅇ
		
		while(!q.isEmpty()) {
			int cx = q.peek().x;
			int cy = q.peek().y;
			int cdepth = q.peek().depth;
			q.poll();
			for (int k = 0; k < dir.length; k++) {
				int nx = cx + dir[k][0];
				int ny = cy + dir[k][1];
				
				if(nx<0 || nx >=N || ny < 0 || ny >=N) continue;	//맵 벗어나면 안돼!
				
				//현재방보다 1커야돼!
				if(map[nx][ny]-1 == map[cx][cy]) {
					q.push(new Node6(nx,ny,cdepth+1,0));
					if(maxdepth < cdepth+1) maxdepth= cdepth +1;	//가장많이 이동한 방 찾기
				}
			}
		}//end of while q
		
		return maxdepth;
	}//end of f()
}//end of class

class Node6 implements Comparable<Node6>{
	int x;
	int y;
	int depth;
	int value;	//정렬위에서 필요
	
	Node6(int x, int y, int depth, int value) {
		this.x = x;
		this.y = y;
		this.depth = depth;
		this.value = value;
	}

	@Override
	public int compareTo(Node6 o) {
		if(this.depth == o.depth) {
			return this.value-o.value;
		}
		else
		return o.depth-this.depth;
	}
}//end of class node6

/*
 * #
 * 
 * #큐랑 스택은 정렬이 안돼!
	큐안에 클래스를 넣었고
	그거를 정렬 하려해
	
 * 
 */
