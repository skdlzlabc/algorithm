import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2563_색종이 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[101][101];	//map : 0~100
		
		StringTokenizer st = null;
		for (int z = 0; z < N; z++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			//#구현
			//일단 다 더한 뒤, 겹친 부분(사각형의 중심으로 )만큼 빼자
			//사각형의 중심수: 한 행의 점 -1
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					map[x+i][y+j]++;
				}
			}
		}

		int duple = 0;
		//겹친거 빼자
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j]>1) {
					duple+=map[i][j]-1;//최소 1개는 있어야
				}
			}
		}
		
		int size = 100*N -duple;
		System.out.print(size);
	}//end of main
}//end of class
