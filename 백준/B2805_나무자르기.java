import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2805_나무자르기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	//나무수
		int M = Integer.parseInt(st.nextToken());	//나무길이
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int left = 0;	//left , right : 나무길이
		int right = arr[arr.length-1];
		int max=0;
		while(left<=right) {
			int mid = (right+left)/2;	//현재 짜른 나무 길이
			long cur=0;
			for (int i = arr.length-1; i >=0 ; i--) {
				if(arr[i]>mid) 
					cur+=arr[i]-mid;
				else
					break;
			}
			
			if(cur>=M) {
				max = Math.max(max, mid);
				left = mid+1;
			}
			else {
				right = mid-1;
			}
		}//end of while()
		/*
		 * 지금 문제가 
		 * cur이랑 M이랑 정확히 맞지 않아도되
		 * cur이 쪼끔 더 커도 되는거
		 * 그러면 
		 */
		System.out.println(max);
		/*
		 * 높이를 기준으로 짜르자
		 * 그 높이로 짤랐을 때 나무 길이의합 > M : 높이 증가 : left=mid+1; 
		 * 그 높이로 짤랐을 때 나무 길이의합 < M : 높이 감소 : right=mid-1; 
		 * 
		 */
		
		//적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값
		
	}//end of main
}//end of class

/*
 * #맞는거 같은데 틀릴때
 * 1.Logic 제대로 짯는지
 * 2.자료형범위 초과안하는지 (int->long)
 */
