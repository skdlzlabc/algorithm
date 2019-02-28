import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15651_N과M3 {

	private static int N;
	private static int M;
	private static int[] tmp;
	private static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tmp = new int[M];
		sb = new StringBuilder();
		f(0);
		System.out.print(sb);
	}

	public static void f(int i) {
		if(i==M) {
			for (int j = 0; j < tmp.length; j++) {
				sb.append(tmp[j]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int j = 0; j < N; j++) {
			tmp[i]=j+1;
			f(i+1);
		}
	}

}
