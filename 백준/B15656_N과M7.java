import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15656_N과M7 {
	private static int[] arr;
	private static int N;
	private static int M;
	private static StringBuilder sb;
	private static int[] tmp;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		tmp = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		sb = new StringBuilder();
		//#구현
		//일단 정렬
		Arrays.sort(arr);
		
		perm(0);
		System.out.println(sb);
		
	}//end of main

	public static void perm(int i) {
		if(i==M) {
			for (int j = 0; j < tmp.length-1; j++) {
				sb.append(tmp[j]).append(" ");
			}
			sb.append(tmp[M-1]).append("\n");
			return;
		}
		for (int j = 0; j < N; j++) {
			tmp[i]=arr[j];
			perm(i+1);
		}
	}//end of perm()
}//end of class


