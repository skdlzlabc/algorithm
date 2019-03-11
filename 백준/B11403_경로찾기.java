import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11403_경로찾기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];	//1~100
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//#구현
		//0: 연결 안되있다.
		//인접행렬을 출력하자
		for (int i = 0; i < map.length; i++) {	//경유점
			for (int j = 0; j < map.length; j++) {	//시작
				for (int k = 0; k < map.length; k++) {	//끝
					//경유해서 갈수 있으면 1
					if(map[j][i]==1 && map[i][k]==1) {
						map[j][k]=1;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		
	}//end of main
}//end of class
