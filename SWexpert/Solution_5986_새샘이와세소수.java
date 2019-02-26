import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_5986_새샘이와세소수 {

	private static int N;
	private static int[] prime;
	private static int[] tmp;
	private static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());

		// 1.소수 배열 만들기, 소수: false
		int MAX = 1000;
		boolean[] compo = new boolean[MAX];
		compo[0] = compo[1] = true;
		for (int i = 2; i < MAX; i++) {
			for (int j = i * 2; j < MAX; j += i) {
				compo[j] = true;//합성수 이면 트루
			}
		}
		prime = new int[168]; //소수를 저장

		int primeIndex=0;
		for (int i = 0; i < 1000; i++) {
			if(!compo[i]) prime[primeIndex++]=i;
		}
		
		
		for (int z = 1; z <= testCase; z++) {
			N = Integer.parseInt(br.readLine());
			//2. 같은 것이 있는 순열, 3개 고르기
			tmp = new int[3];
			result=0;
			perm(0,0);
			
			sb.append("#").append(z).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}// end of main

	
	public static void perm(int depth,int sum) {
		if(depth==tmp.length) {
			if(sum==N && (tmp[0]<=tmp[1] && tmp[1]<=tmp[2])) {
				result++;
			}
			return;
		}
		for (int i = 0; i < prime.length; i++) {
			if(sum+prime[i]<=N) {
				if(depth==0 && prime[i]*3>N) break; 	//depth:0일때 N/3을 넘으면 안됨 **************
				tmp[depth]=prime[i];
				perm(depth+1,sum+tmp[depth]);
			}
		}
	}

}// end of class






