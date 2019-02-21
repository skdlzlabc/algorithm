
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {
	private static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int z = 1; z <= T; z++) {
			int V = Integer.parseInt(br.readLine()); // 정점의 개수
			
			int[][] arr = new int[V][2];
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < V; i++) {
				arr[i][0] = Integer.parseInt(st1.nextToken());	//x좌표
				arr[i][1] = Integer.parseInt(st2.nextToken());	//y좌표
			}
			double E = Double.parseDouble(br.readLine()); // 환경 부담 세율 실수
			
			//#구현
			//정점들간의 가중치 미리 구해두기
			//0-1이랑 1-0이랑 같네.
			int edgeCnt=(V*(V-1))/2;
			double[][] weight = new double[V][V];	//(V*(V-1))/2: 정점 V개 일떄 최대 간선 수
			for (int i = 0; i < V; i++) {
				for (int j = i+1; j < V; j++) {	//L(터널길이)^2
					weight[i][j] = Math.pow(Math.abs((arr[i][0]-arr[j][0])),2)+
											+Math.pow(Math.abs((arr[i][1]-arr[j][1])), 2);
				}
			}
			Edge[] G = new Edge[edgeCnt]; // 간선의 정보를 저장할 배열 = 간선 배열
			int tmpCnt=0;
			for (int i = 0; i < V; i++) {
				for (int j = i+1; j < V; j++) {	//L(터널길이)^2
					Edge e = new Edge(i, j, weight[i][j]);
					G[tmpCnt++] = e;
				}
			}
			
			//#구현
			//크루스칼, disjoint 이용
			p = new int[V];
			double minWeight =0;
			
			//1  크루스칼은 정렬된 가중치를 선택함.
			Arrays.sort(G); //가중치를 기준으로 정렬 , 재정의 필요
			
			//2 disjoint // p : 부모 저장. 초기에는 자기 자신
			for (int i = 0; i < V; i++) {
				p[i]=i;
			}
			
			//3 disjoint + 크루스칼 // 간선이 V-1개 선택 될때 까지 반복 
 			for (int i = 0,cnt = 0; i < edgeCnt && cnt < V; i++) {	//크루스칼의 최대 간선수는 V-1개이므로 cnt이용해서 조건 만족시 빠져나오자!
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
			sb.append("#").append(z).append(" ").append(String.format("%.0f", minWeight*E)).append("\n");
		}//end of for testCase
		System.out.println(sb);

	}// end of main

	
	public static int findSetParent(int index) {
		if(p[index]==index) {
			return index;
		}
		p[index] = findSetParent(p[index]);	//문제점 해결1 : path Compression : 대표자를 찾으면 저장 하자 ******
		return p[index];
	}//end of findSetParent()

	public static class Edge implements Comparable<Edge> {
		
		int node1; // 정점 1
		int node2; // 정점 2
		double weight;// 가중치

		public Edge(int a, int b, double val) {
			this.node1 = a;
			this.node2 = b;
			this.weight = val;
		}

		public int compareTo(Edge o) { // 간선의 가중치를 기준으로 정렬한다.
			return (int) (this.weight - o.weight); // 내께 크면 양수(오름차순)
		}

	}// end of Edge{}

}// end of class
