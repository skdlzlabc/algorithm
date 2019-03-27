import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정올_1077_배낭채우기1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		Node[] list = new Node[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			list[i]=new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(list);

		int[][] d = new int[N+1][W+1];
		for (int i = 0; i < N; i++) {
			int curw = list[i].w;
			int curp = list[i].p;
			
			for (int j = 1; j <= W; j++) {
				d[i+1][j]=d[i][j];
				if(j-curw>=0)
				d[i+1][j]= Math.max(d[i][j],d[i+1][j-curw]+curp);
			}
		}
		
//		System.out.print("  ");
//		for (int i = 0; i < d[0].length; i++) {
//			System.out.print(String.format("%4d", i));
//		}
//		System.out.println();
//		for (int i = 0; i < d.length; i++) {
//			System.out.print(i+1+":");
//			for (int j = 0; j < d[i].length; j++) {
//				System.out.print(String.format("%4d", d[i][j]));
//			}
//			System.out.println();
//		}

		System.out.println(d[N][W]);
		
	}//end of main
	static class Node implements Comparable<Node>{
		int w;
		int p;
		Node(int w, int p) {
			this.w = w;
			this.p = p;
		}
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
	}//end or Node{}
}//end of class
