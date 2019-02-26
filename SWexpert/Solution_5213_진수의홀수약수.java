import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5213_진수의홀수약수{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		//홀수의 배수들을 홀수를 약수를 가진다!!!!!
		int MAX = 1000000;
		long[] oddSum = new long[MAX+1];
		for (int i = 1; i <= MAX ; i+=2) {	//1 3 5 7 홀수만!
			for (int j = 1; i*j <= MAX; j++) {//i을 j번곱합
				oddSum[i*j]+=i;
			}
		}

		//oddSum[0]~oddSum[1000]+oddSum[1001] = oddSum[1001] 매번 계산하기 넘 오래 걸림!!
		//=> 미리 구해 놓자.
		long[] preOddSum = new long[MAX+1];
		preOddSum[1]=1;
		for (int i = 2; i <= MAX; i++) {
			preOddSum[i]=preOddSum[i-1]+oddSum[i];
		}
		
		for (int z = 1; z <= testCase; z++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			//#구현
			//미리 각 숫자별 홀수 약수들의 합계를 만들자.
			long result = preOddSum[end]-preOddSum[start-1];
			sb.append("#").append(z).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
			
			
		
	}//end of main
}//end of class