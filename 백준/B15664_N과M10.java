import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B15664_N과M10 {

	private static int N;
	private static int M;
	private static int[] tmp;
	private static int[] arr;
	private static StringBuilder sb;
	private static HashSet<String> set;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		arr = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		tmp = new int[M];
		sb = new StringBuilder();
		set = new HashSet<String>();
		f(0);
		System.out.print(sb);
	}

	public static void f(int i) {
		if (i == M) {
			String str = "";
			for (int j = 0; j < tmp.length-1; j++) {
				str += tmp[j]+" ";
			}
			str+=tmp[tmp.length-1];
			if (!set.contains(str)) {
				set.add(str);
				for (int j = 0; j < tmp.length; j++) {
					sb.append(tmp[j]).append(" ");
				}
				sb.append("\n");
			}
			return;
		}
		for (int j = 0; j < N; j++) {
			if(!visited[j]) {
				tmp[i] = arr[j];
				visited[j]=true;
				f(i + 1);
				visited[j]=false;
			}
		}
	}

}
