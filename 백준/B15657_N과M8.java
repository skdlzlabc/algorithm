import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15657_N과M8 {

	private static int[] arr;
	private static int N;
	private static int M;
	private static int[] tmp;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		tmp = new int[M];
		f(0,0);
		System.out.println(sb);
		
	}//end of main

	public static void f(int start, int cnt) {
		if(cnt==M) {
			for (int i = 0; i < M-1; i++) {
				sb.append(tmp[i]).append(" ");
			}
			sb.append(tmp[M-1]).append("\n");
			return;
		}
		for (int j = start; j < N; j++) {
			tmp[cnt]= arr[j];
			f(j,cnt+1);
		}
		
	}
}//end of class
