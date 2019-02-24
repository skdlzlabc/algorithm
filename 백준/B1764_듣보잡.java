import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B1764_듣보잡 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//#구현
		//겹치는 사람 찾기 
		//해시셋에 넣고 비교하자!!
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		ArrayList<String> al = new ArrayList<String>();
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			if(set.contains(tmp)){
				al.add(tmp);
			}
		}
		
		Collections.sort(al);
		
		int total = al.size();
		StringBuilder sb = new StringBuilder();
		sb.append(al.size()).append("\n");
		for (int i = 0; i < total; i++) {
			sb.append(al.get(i)).append("\n");
		}
		
		System.out.println(sb);
			
	}//end of main
}//end of class

