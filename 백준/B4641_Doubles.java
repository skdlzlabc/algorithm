import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B4641_Doubles {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashSet<Integer> set;
		ArrayList<Integer> al;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			if (st.countTokens() == 1)
				break; // -1:종료조건
			set = new HashSet<Integer>();
			al = new ArrayList<Integer>();
			// #입력 및 구현
			while (st.hasMoreTokens()) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 0)
					break;
				al.add(tmp);
				set.add(tmp);
			}

			int cnt = 0;
			int len = al.size();
			for (int i = 0; i < len; i++) {
				if (set.contains(al.get(i)*2)) {
					cnt++;
				}
			}
			System.out.println(cnt);

		}
	}// end of main
}// end of class
