import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_4050_재관이의대량할인 {
	private static int N;
	private static Integer[] arr;
	private static boolean[] visited;
	private static int maxFree;
	private static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/*
		 * 세 벌의 옷을 사면 그 중 가장 저렴한 한 벌에 해당하는 값은 내지 않아도 된다는 조건
		 * 세 벌 묶음당 한개만 할인
		 */
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int z = 1; z <= tc; z++) {
			N = Integer.parseInt(br.readLine());	//1 ≤ N ≤ 100,000
			StringTokenizer st = new StringTokenizer(br.readLine());	//1 ≤ Ci ≤ 100,000
			sum =0;
			arr = new Integer[N];
			for (int i = 0; i < N; i++) {
				sum+=arr[i]=Integer.parseInt(st.nextToken());
			}
			
//			//6 4 5 5 5 5
//			//3개 고른다음에 가장 작은값 뺴야돼
//			//가장 작은값들의 합이 가장 클경우가 답!!!
//			visited = new boolean[N];
			maxFree=0;
//			f(arr.length,0);

			//2#################
			//정렬 해놓고
			Arrays.sort(arr,Collections.reverseOrder());
			//3개마다 짤라서 제일 앞에 값
			for(int i=2;;i+=3) {
				if(i >=N) break;
				maxFree+=arr[i];
			}
			
			System.out.println("#"+z+" "+(sum-maxFree));
		}//end of for()
	}//end of main

	
	//완탐=>시간초과
	//3개 고르고 남은 애들에서 3개 고르고... 반복
	public static void f(int 나머지,int sum) {
		//3개를 고르고 재호출
		//남은개 1개 or 2개면 끝~
		if(나머지<3) {
			if(sum> maxFree) maxFree=sum;
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			for (int j = 0; j < arr.length; j++) {
				if(visited[j]) continue;
				visited[j]=true;
				for (int k = 0; k < arr.length; k++) {
					if(visited[k]) continue;
					visited[k]=true;
					//가장 작은수 찾기 
					int l = arr[i] > arr[j] ? arr[j] : arr[i];
						l = l > arr[k] ? arr[k] : l;
					f(나머지-3,sum+l);
					
					visited[k]=false;
				}
				visited[j]=false;
			}
			visited[i]=false;
		}
	}//end of f()
}//end of class














