import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2007_패턴마디의길이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		// MMMMMMMMMOMMMMMMMMMOMMMMMMMMMO : 10
		// abcdefabcdabcdefabcdabcdefabcd : 10
		
		for (int z = 1; z <= testCase; z++) {
			String originStr = br.readLine();
			
			for (int i = 1;; i++) {
				String iter = originStr.substring(0, i);
				String spanIter = "";
				int len = iter.length();
				int mul = (30 / len) + 1;
				
				for (int j = 0; j < mul; j++) {	//여러개 이어 붙이기
					spanIter += iter;
				}

				spanIter = spanIter.substring(0, 30);	//30글자만 잘라서 비교
				if (spanIter.equals(originStr)) {
					sb.append("#");
					sb.append(z);
					sb.append(" ");
					sb.append(len);
					sb.append("\n");
					break;
				}
			}
		}
		System.out.println(sb);

	}// end of main

}// end of class
