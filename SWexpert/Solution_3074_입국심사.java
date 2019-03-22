import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_3074_입국심사 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int z = 1; z <= testCase; z++) {
			String[] str = br.readLine().split(" ");
			int N =Integer.parseInt(str[0]);
			int M =Integer.parseInt(str[1]);
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i]=Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);

			long start 	= 0;
			long end	= 1000000000L * M;
			long minTime= Long.MAX_VALUE; 
			while(start <= end) {
				long mid = (start + end) / 2;
				
				long cnt=0;
				for (int i = 0; i < N; i++) {
					cnt+= mid / arr[i];
				}
			
				if(cnt>=M) {
					minTime=Math.min(minTime, mid);
					end = mid - 1;	
				}
				else {
					start = mid +1;
				}
			}
			sb.append("#").append(z).append(" ").append(minTime).append("\n");
		}//end of for testCase;
		System.out.println(sb);
	}//end of main
}//end of class
