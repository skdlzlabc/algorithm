import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1316_그룹단어체커 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		/*
		 * 1.visited 배열 만들어서 체크 하면될거같아 + 바뀔떄 flag체크
		 */
		int cnt=0;
xx:		for (int i = 0; i < N; i++) {
			boolean[] visited = new boolean[26];
			String cur = "a"+br.readLine();
			int curLen = cur.length();
			for (int j = 1; j < curLen; j++) {
				if(cur.charAt(j-1)==cur.charAt(j) || !visited[cur.charAt(j)-'a']) {
					visited[cur.charAt(j)-'a']=true;
				}
				else
				continue xx;
			}
			cnt++;
		}
		System.out.println(cnt);
		
	}//end of main
}//end of class
