import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1213_String_전우형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int z = 1; z <= 10; z++) {
			br.readLine();
			String keyword = br.readLine();
			String str = br.readLine();
			int ans = 0;

			int strlen = str.length();
			int keywordLen = keyword.length();
			
			//입력받은 문자열 인덱스 하나씩 증가시키며 contains으로 키워드 유무 파악
			for (int i = 0; i < strlen; i++) {
				String tmp =str.substring(i,strlen);
				if(tmp.contains(keyword)) {	
					ans++;
					i+=tmp.indexOf(keyword);	//찾은 위치로 인덱스 이동
				}
			}

			sb.append("#");
			sb.append(z);
			sb.append(" ");
			sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb);

	}// end of main

}// end of class
