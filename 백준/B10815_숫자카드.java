import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10815_숫자카드 {

	public static void main(String[] args) throws Exception {
		/*
		 * 숫자 : N개
		 * 정수 : M개
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];//상근이가 가지고 있는거
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		//#구현
		//이진탐색
		//얘네들을 상근이가 가지고 있냐
		StringBuilder sb = new StringBuilder();
xx:		for (int i = 0; i < M; i++) {
			int cur = Integer.parseInt(st.nextToken());
			int left=0;
			int right = arr.length-1;
			while(left<=right) {
				int mid = (left+right)/2;
				
				//1 3 5 7 9
				//7
				if(arr[mid]<cur) {
					left=mid+1;
				}
				else if(arr[mid]>cur) {
					right=mid-1;
				}
				else {
					sb.append(1).append(" ");
					continue xx;
				}
			}
			sb.append(0).append(" ");
		}
		System.out.println(sb);
	}//end of main
}//end of class
