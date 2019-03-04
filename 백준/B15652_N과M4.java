import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15652_N과M4 {
	private static StringBuilder sb;
	private static int N;
	private static int M;
	private static int[] tmp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tmp = new int[M];
		f(0,0);
		System.out.println(sb);
	}//end of main

	public static void f(int i, int start) {
		if(i==M) {
			for (int j = 0; j < i-1; j++) {
				sb.append(tmp[j]).append(" ");
			}
			sb.append(tmp[i-1]).append("\n");
			return;
		}
		for (int j = start; j < N; j++) {
			tmp[i]=j+1;
			f(i+1,j);
		}
	}//end of f()
}//end of class
