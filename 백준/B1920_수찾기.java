import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		
		int[] arr = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] target = new int[N];
		for (int i = 0; i < N; i++) {
			target[i]= Integer.parseInt(st.nextToken());
		}
		
		
		//#구현
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = arr.length-1;
			boolean flag = false;
			
			while(left<=right) {
				int mid = (left+right)/2;
				if(arr[mid]==target[i]) {		
					flag = true;
					break;
				}
				
				if(arr[mid]<target[i]) 
					left=mid+1;
				else 
					right=mid-1;
			}
			if(flag)
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
				
		}
		System.out.println(sb);
		
	}//end of main
}//end of class
