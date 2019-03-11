import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149_RGB거리 {

	public static void main(String[] args) throws Exception {
		
		// i-1 i i+1 : 이웃
		//비용의 최솟값
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	//1~1000
			
		int[][] price = new int[N+1][3];
		for (int i = 1; i < price.length; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			price[i][0]=Integer.parseInt(st.nextToken());	//r
			price[i][1]=Integer.parseInt(st.nextToken());	//g
			price[i][2]=Integer.parseInt(st.nextToken());	//b
		}
		//#구현
		int[][] d = new int[N+1][3];
		
		d[1][0] = price[1][0];
		d[1][1] = price[1][1];
		d[1][2] = price[1][2];
		
		for (int i = 2; i < price.length;i++) {
			d[i][0] = Math.min(d[i-1][1] , d[i-1][2])+ price[i][0];
			d[i][1] = Math.min(d[i-1][0] , d[i-1][2])+ price[i][1];
			d[i][2] = Math.min(d[i-1][0] , d[i-1][1])+ price[i][2];
		}
		
		System.out.println(Math.min(Math.min(d[N][0], d[N][1]),d[N][2]));
		
	}//end of main
}//end of class
