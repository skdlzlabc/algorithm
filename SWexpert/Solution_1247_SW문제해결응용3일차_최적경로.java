import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_SW문제해결응용3일차_최적경로 {

	private static int[] permarr;
	private static int[][] arr;
	private static int min=Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int i = 1; i <= testCase; i++) {
			int N = Integer.parseInt(br.readLine());
			// 회사, 집, 고객
			arr = new int[N + 2][2];
			permarr = new int[N];
			for (int j = 0; j < N; j++) {
				permarr[j] = j+2;
			}
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N + 2; j++) {
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}

			// #구현#
			// 순열이용 모든 경우 파악
			min=Integer.MAX_VALUE;
			perm(N, 0);
			System.out.println("#" + i + " " + min);
		} // end of for testCase
	}// end of main


	public static void perm(int n, int k) {
		if (k == n) {
			// 거리 계산
			int curSum = calDis();
			if (min > curSum)
				min = curSum;
			return;
		} else {
			for (int i = k; i < n; i++) {
				swap(k, i);
				perm(n, k + 1);
				swap(k, i);
			}
		}
	}// end of perm()

	public static int calDis() {
		// 시작
		int disx = Math.abs(arr[0][0] - arr[permarr[0]][0]);
		int disy = Math.abs(arr[0][1] - arr[permarr[0]][1]);
		int sum = disx + disy;

		// 끝
		disx = Math.abs(arr[1][0] - arr[permarr[permarr.length - 1]][0]);
		disy = Math.abs(arr[1][1] - arr[permarr[permarr.length - 1]][1]);
		sum += disx + disy;
		
		// 중간
		for (int i = 0; i < permarr.length-1; i++) {
			disx = Math.abs(arr[permarr[i]][0] - arr[permarr[i+1]][0]);
			disy = Math.abs(arr[permarr[i]][1] - arr[permarr[i+1]][1]);
			sum += disx + disy;
		}
		return sum;
	}// end of calDis()

	public static void swap(int k, int i) {
		int tmp = permarr[k];
		permarr[k] = permarr[i];
		permarr[i] = tmp;
	}// end of swap()

}// end of class
