import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4408_자기방으로돌아가기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int z = 1; z <= testCase; z++) {
			int N = Integer.parseInt(br.readLine().trim());// N :돌아가야할 학생들수
			int[] arr = new int[401]; // 1~400

			// #다 간다음에 겹치는 경우 카운트
			// 지나가는경우 10 20 -> 9~20칸 +1, 짝수이면 -1~, 홀수이면 걍~
			// 가장큰 숫자 출력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				if (start < end) { //1~4
					if (start % 2 == 0) {// 시작이 짝수일떄 1~4
						start--;
					}
					if (end % 2 == 1) { // 끝이 홀수 일때
						end++;
					}
					for (int j = start; j <= end; j++) {
						arr[j]++;
					}
				}
				else {
					//4 ~ 1
					if(start%2 ==1) {	//시작이 홀수 이면
						start++;
					}
					if(end %2 ==0) {	//끝이 짝수이면
						end--;
					}
					for (int j = start; j >= end; j--) {
						arr[j]++;
					}
				}
			}

			int max = 0;
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] > max)
					max = arr[i];
			}

			sb.append("#").append(z).append(" ").append(max).append("\n");
		} // end of for testCase
		System.out.print(sb);

	}// end of main
}// end of class
