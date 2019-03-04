import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15652_N과M5 {
	private static StringBuilder sb;
	private static int N;
	private static int M;
	private static int[] tmp;
	private static int[] arr;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		tmp = new int[M];
		visited = new boolean[N];
		f(0);
		System.out.println(sb);
	}//end of main

	public static void f(int i) {
		if(i==M) {
			for (int j = 0; j < i-1; j++) {
				sb.append(tmp[j]).append(" ");
			}
			sb.append(tmp[i-1]).append("\n");
			return;
		}
		for (int j = 0; j < N; j++) {
			if(!visited[j]) {
				tmp[i]=arr[j];
				visited[j]=true;
				f(i+1);
				visited[j]=false;
			}
		}
	}//end of f()
}//end of class
