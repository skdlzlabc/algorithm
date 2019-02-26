import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_N과M2 {
	private static int N;
	private static int M;
	private static StringBuilder sb;
	private static int[] tmp;
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=i+1;
		}
		//중복없이 뽑기
		tmp = new int[M];
		comb(0,0);
		System.out.println(sb);
	}//end of main

	public static void comb(int start, int cnt) {
		if(cnt==M) {
			for(int t:tmp) {
				sb.append(t).append(" ");
			}
			sb.append("\n");
			return;
		}
		if(start>=N) return;
		
		for (int i = start; i < N; i++) {
			tmp[cnt]=arr[i];
			comb(i+1,cnt+1);
		}
		
		
	}//end of comb()
}//end of class

