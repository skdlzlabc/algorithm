import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2579_계단오르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		//1 1
		//2 11 2
		//3 111 12 21
		//4 1111 112 121 211 22
		
		int[] stair = new int[N+1];
		stair[1]=arr[1];
		if(N==1) {
			System.out.println(stair[1]);
			return;
		}
		stair[2]=Math.max(arr[1]+arr[2],arr[2]);
		for (int i = 3; i < stair.length; i++) {
			//111연속으로 오르는 경우!!
			//=> 111을 따로 고려 해서 그 값이 Max가 안되게 하자
			//전전전 2 +1
			//전전 2
			stair[i]=Math.max(stair[i-2],stair[i-3]+arr[i-1])+arr[i];
		}
		
		System.out.println(stair[N]);
	}// end of main
}// end of class
