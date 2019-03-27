import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정올_2283_RGB마을 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int[][] d = new int[N][3];
		
		d[0][0]=map[0][0];	//처음에 0부터시작
		d[0][1]=map[0][1];	//처음에 1부터시작
		d[0][2]=map[0][2];	//처음에 2부터시작

		for (int i = 1; i < d.length; i++) {
			d[i][0]= Math.min(d[i-1][1],d[i-1][2]) + map[i][0];
			d[i][1]= Math.min(d[i-1][0],d[i-1][2]) + map[i][1];
			d[i][2]= Math.min(d[i-1][0],d[i-1][1]) + map[i][2];
		}
		
		System.out.println(Math.min(Math.min(d[N-1][0],d[N-1][1]),d[N-1][2]));
	}//end of main
}//end of class
