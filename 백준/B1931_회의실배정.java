import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1931_회의실배정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N+1][2];
		for (int z =1; z <= N; z++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[z][0]=Integer.parseInt(st.nextToken());
			arr[z][1]=Integer.parseInt(st.nextToken());
		}
		
		//#구현
		//뒷번호로 오름차순정렬, 이후 겹치는거 제하고 카운팅
		//이차원 배열 이런식으로 정렬 *******************
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {	
					return o1[0] > o2[0] ? 1: -1;
				}
				
				return o1[1] > o2[1] ? 1 : -1;// <= 이렇게 쓸경우 같은 거 계속나면 에러 ***** 25 줄처럼 같을땐 따로 분리 
			}
		});
		
		
		//정렬된거 앞에서 부터 보면서 
		int result=1;
		int curEnd=arr[1][1];
		for (int i = 2; i <= N; i++) {
			if(arr[i][0]>=curEnd) { 	//내 시작점 >= 이전의 끝점
				result++;
				curEnd=arr[i][1];
			}
		}

		System.out.println(result);
	}//end of main
}//end of class

