import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1003_피보나치함수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 0~40
		
		int[] zero= new int[41];
		int[] one= new int[41];
		zero[0]=1;
		one[1]=1;
		
		for (int i = 2; i < one.length; i++) {
			zero[i] = zero[i-1]+zero[i-2];
			one[i] = one[i-1]+one[i-2];
		}
		
		StringBuilder sb = new StringBuilder();
		//#출력
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			sb.append(zero[a]).append(" ").append(one[a]).append("\n");
		}
		System.out.println(sb);
		
	}//end of main
}//end of class
