import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3752_가능한시험점수 {

	private static int N;
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine().trim());

		for (int z = 1; z <= testCase; z++) {
			N = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			arr = new int[N+1];
			arr[0]=0;
			for (int i = 1; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			// #구현
			//내껄 기준으로 만들어진거에 다 더해!
			boolean[] check = new boolean[100*100+1];
			check[0]=true;	//0점은 기본!
			
			for (int i = 0; i < arr.length; i++) {	//기준
				int cur =arr[i];
				for (int j = check.length-1; j >= 0; j--) {	//만들어진거(이미 방문 된거)에 내꺼를 더해!
					//뒤에부터해야 중복된값없이 !!!!!!************
					if(check[j]) {
						check[cur+j]=true;
					}
				}
			}
			
			int cnt=0;	//방문한 애들만 세기
			for (int i = 0; i < check.length; i++) {
				if(check[i])	cnt++;
			}
			
			sb.append("#").append(z).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
	}// end of main
}// end of class


/*
 * 방법1. 	중복없는 순열을 이용해서, set을 이용해 합이 같은경우를 제하려고 했음.
 * 			근데 문제에서 N이 100일수도 있음, 그러면 100p1 100p2 다 구해야함. => 못함
 * 방법2.	(동희 한테 아이디어 구해서) 미리 더한 숫자를 만들어 두는거야!!
 * 			근데 중복해서 뽑히는 경우 해결 못함 ㅜ
 * 방법3.	방법2를 차근차근 그려서 푼 결과, 기준으로부터 0방향으로 합해버리면 중복을 피할 수 있었음!! => 해결
 * 
 */
