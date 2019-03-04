import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15655_N과M6 {

	private static int N;
	private static int M;
	private static StringBuilder sb;
	private static int[] tmp;
	private static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		tmp = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		//#구현
		//순열!
		//오름 차순!
		//미리 정렬 해두자		
		Arrays.sort(arr);
		perm(0,0);
		System.out.println(sb);
	}//end of main

	public static void perm(int start, int cnt) {
		if(cnt==M) {
			for (int i = 0; i < M-1; i++) {
				sb.append(tmp[i]).append(" ");
			}
			sb.append(tmp[M-1]).append("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			tmp[cnt]=arr[i];
			perm(i+1,cnt+1);
		}
	}//end of perm()
}//end of class
