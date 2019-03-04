import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3307_최장증가부분수열 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());

		for (int z = 1; z <= testCase; z++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			//#구현 
			//n을 마지막으로 쓴 수열의 최장 증가 수열을 구하는 배열LIS을 만들자
			int[] LIS = new int[N]; //********* LIS : 갯수
			for (int i = 1; i < N; i++) {
				LIS[i]=1; //숫자 n으로 만들수 있는 수열, 기본적으로 자기 자신으로 수열을 만들 수 있음!
				for (int j = 1; j < i; j++) {
					//내 앞에 있는 애들 중에 숫자가 나보다 작은 녀석이 있고
					//또 걔의 LIS + 1 이 나보다 크면 업데이트해라
					if(arr[j]<arr[i] && LIS[j]+1 > LIS[i]) {
						LIS[i] = 1 + LIS[j];
					}
				}
			}
			
			int max =0;
			for (int i = 0; i < LIS.length; i++) {
				if(max < LIS[i]) max= LIS[i];
			}
			
			sb.append("#").append(z).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
		
	}//end of main
}//end of class
