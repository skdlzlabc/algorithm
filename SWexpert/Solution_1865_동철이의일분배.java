import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1865_동철이의일분배 {
	private static int N;
	private static double max;
	private static double[][] map;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int z = 1; z <= testCase; z++) {
			N = Integer.parseInt(br.readLine());
			map = new double[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Double.parseDouble(st.nextToken()) / 100;
				}
			}
			// 순열
			max = 0;
			visited = new boolean[N];
			f(0, 1);
			sb.append("#").append(z).append(" ").append(String.format("%.6f",max*100)).append("\n");
		}
		System.out.println(sb);
	}// end of main

	public static void f(int cnt, double curMulti) {
		if (cnt == N) {
			if (max < curMulti)
				max = curMulti;
			return;
		}
		if (curMulti == 0)
			return;
		if (curMulti < max)
			return;
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			f(cnt + 1, curMulti * map[cnt][i]);
			visited[i] = false;
		}
	}// end of f()
}// end of class
