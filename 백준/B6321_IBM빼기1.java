import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B6321_IBM빼기1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		//미리 
		char[] arr = new char [27];
		for (int i = 0; i < arr.length-1; i++) {
			arr[i] = (char)('A'+i);
		}
		arr[26]='A';
				
		
		for (int i = 1; i <= testCase; i++) {
			String input = br.readLine();
			int len = input.length();

			sb.append("String #").append(i).append("\n");
			
			for (int j = 0; j < len; j++) {
				if(input.charAt(j)==' ') continue;
				sb.append(arr[input.charAt(j)+1-65]);
			}
			
			sb.append("\n");
			if(i==testCase) continue;
			sb.append("\n");
		}
		System.out.println(sb);
		
	}//end of main
}//end of class

