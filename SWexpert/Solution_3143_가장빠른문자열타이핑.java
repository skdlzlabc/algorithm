import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_3143_가장빠른문자열타이핑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int z = 1; z <= testCase; z++) {
			String[] tmp= br.readLine().split(" ");
			
			String a = tmp[0]+"$";
			String b = tmp[1];
			String[] t = a.split(b);
			
			int result = (a.length()-1) - (t.length-1)*(b.length()-1);
			System.out.println("#"+z+" "+result);
		}
	}

}
