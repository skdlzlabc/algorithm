import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1266_SW문제해결응용9일차_소수완제품확률 {
	
	static int[] arr;
	static int[] tmp;
	private static int combCnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		//#미리 구현#
		arr = new int[18];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=i;
		}
		int[] kList = {2,3,5,7,11,13,17};	//소수 경우
		int[] combList = new int[7];
		//18 C k 값들 미리 저장
		for (int j = 0; j < kList.length; j++) {
			tmp = new int[kList[j]];
			comb(18,tmp.length);
			combList[j]=combCnt;
			combCnt=0;
		}
		//########
		
		for (int i = 1; i <= testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			double pA = A/100.0;
			double pB = B/100.0;
			
			//#구현#
			//아래 식을 이용해서 a, b 각각 총합이 소수일 확률을 구함
			//18 C k * P^k *(1-P)^(18-k)	, 	P: pA or pB, 완성품 나올 확률
			//									k :2 3 5 7 11 13 17, 소수 갯수
			
			//a + b -(a*b)	:	적어도 1개 = 각각 - 전체
			double pAFinalSum=0;
			double pBFinalSum=0;
			double pABFinalSum=0;
			for (int k = 0; k < kList.length; k++) {
				pAFinalSum+=combList[k] * Math.pow(pA,kList[k]) * Math.pow(1-pA, 18-kList[k]);
				pBFinalSum+=combList[k] * Math.pow(pB,kList[k]) * Math.pow(1-pB, 18-kList[k]);
			}
			pABFinalSum=pAFinalSum*pBFinalSum;
		
			double ans = pAFinalSum + pBFinalSum - pABFinalSum;
			
			System.out.println("#"+i+" "+String.format("%.6f", ans));
		}//end of for testCase
		
	}//end of main
	
	private static void comb(int n, int r) {
		
		if(r==0) {
			combCnt++;
			return ;
		}
		else if (n<r){
			return ;
		}
		
		else {
			tmp[r-1] = arr[n-1];
			comb(n-1,r-1);
			comb(n-1,r);
		}
		
	}//end of comb()
}//end of class
