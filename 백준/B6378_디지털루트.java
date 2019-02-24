import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B6378_디지털루트 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String str= br.readLine();
			if(str.equals("0"))break;
			
			//#구현
			//각 숫자별 몇번 나오는지
			int[] arr = new int[10]; //1~9
			
			int len = str.length();
			for (int i = 0; i < len; i++) {
				arr[str.charAt(i)-'0']++;
			}
			
			//각 숫자별 계산
			int sum =0;
			for (int i = 1; i < 10; i++) {
				sum+= i*arr[i];		//ex 3 * 33번 나옴.
				while(true) {
					sum = (sum/10) + (sum%10); 
					if(sum<10) break;
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
		
	}//end of main
}//end of class
