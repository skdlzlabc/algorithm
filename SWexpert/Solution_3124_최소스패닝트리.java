import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리 {
	private static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int z = 1; z <= T; z++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken()); // 정점의 개수
			int E = Integer.parseInt(st.nextToken()); // 간선의 개수

			p = new int[V+1];
			Edge[] G = new Edge[E]; // 간선의 정보를 저장할 배열 = 간선 배열
			long minWeight =0;
			for (int i = 0; i < E; i++) {	
				st = new StringTokenizer(br.readLine(), " ");
				int node1 = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());
				int weight =  Integer.parseInt(st.nextToken());
				Edge e = new Edge(node1, node2, weight);
				G[i] = e;
			}
			
			
			//#구현
			//크루스칼, disjoint 이용
			
			
			//1  크루스칼은 정렬된 가중치를 선택함.
			Arrays.sort(G); //가중치를 기준으로 정렬 , 재정의 필요
			
			//2 disjoint // p : 부모 저장. 초기에는 자기 자신
			for (int i = 1; i < V+1; i++) {
				p[i]=i;
			}
			
			//3 disjoint + 크루스칼 // 간선이 V-1개 선택 될때 까지 반복 
 			for (int i = 0,cnt = 0; i < E && cnt < V; i++) {	//크루스칼의 최대 간선수는 V-1개이므로 cnt이용해서 조건 만족시 빠져나오자!
				Edge curEdge = G[i];
				int pa = findSetParent(curEdge.node1); //각 노드의 부모
				int pb = findSetParent(curEdge.node2);
				
				if(pa != pb) {	//부모가 다르다. == 다른 집합에 속해있다. 즉, 사이클이 생기지 않는다.
					cnt++;
					
					//둘이 합치기
					p[pb] = pa;	
					
					//최소 가중치 출력 위해
					minWeight+=curEdge.weight;
				}
 			}
			
 			
 			//@부모를 찾기위새 쩌~~ 아래에서 제일 위까지 올라가야되는 문제점 있음! 
 			//=>path Compression으로 해결. findset을 하는 과정에서 만나는 모든 노드들을 저장
 			
			
			
			sb.append("#").append(z).append(" ").append(minWeight).append("\n");
		}
		System.out.println(sb);

	}// end of main

	
	public static int findSetParent(int index) {
		if(p[index]==index) {
			return index;
		}
		p[index] = findSetParent(p[index]);	//문제점 해결1 : path Compression 대표자를 찾으면 저장 하자 ******
		return p[index];
	}//end of findSetParent()

	public static class Edge implements Comparable<Edge> {
		
		int node1; // 정점 1
		int node2; // 정점 2
		int weight;// 가중치

		public Edge(int a, int b, int val) {
			this.node1 = a;
			this.node2 = b;
			this.weight = val;
		}

		public int compareTo(Edge o) { // 간선의 가중치를 기준으로 정렬한다.
			return this.weight - o.weight; // 내께 크면 양수(오름차순)
		}

	}// end of Edge{}

}// end of class
