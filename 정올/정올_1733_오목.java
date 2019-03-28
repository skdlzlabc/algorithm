import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 정올_1733_오목 {
	

	private static int[][] map;
	private static int N = 19;
	private static int startx;
	private static int starty;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[19][19];
		for (int i = 0; i < map.length; i++) {
			String str= br.readLine();
			for (int j = 0; j < map.length; j++) {
				map[i][j]=str.charAt(j*2)-'0';
			}
		}
//		for (int i = 0; i < map.length; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		/*
		 * 바둑알 중에서 가장 왼쪽에 있는 바둑알
(연속된 다섯 개의 바둑알이 세로로 놓인 경우, 그 중 가장 위에 있는 것)의 가로줄 번호와, 세로줄 번호
		 */
		StringBuilder sb = new StringBuilder();
xx:		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j]==1 || map[i][j]==2) {
					startx = i;
					starty = j;
					f(map[i][j],i,j,0,0);
					if(check) {
						if(flag) {
							i=fx;
							j=fy;
						}
						sb.append(map[i][j]).append("\n")
						.append(i+1).append(" ").append(j+1);
						break xx;
					}
				}
			}
		}
		if(sb.length()==0) sb.append(0);
		System.out.println(sb);
		
	}//end of main
	private static int[][] dir = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1},};
	private static boolean check;
	private static boolean flag;
	private static int fx;
	private static int fy;
	public static void f(int cur,int i, int j, int cdir, int cnt) {
		/*
		 * 6목이 되면 안돼..
		 * 5개 까지 간다음에 따로 검사
		 */
		if(cnt==4) {
			/*
			 * 6목검사
			 * 해당 방향으로 한번만 더 검사.
			 */
			int nx = i+dir[cdir][0]; 
			int ny = j+dir[cdir][1]; 
			if(nx>=0 && nx<N && ny>=0 && ny<N) {
				if(map[nx][ny]==cur) return;	//6목 검사
			}
			int initx= startx+dir[(cdir+4)%8][0];
			int inity= starty+dir[(cdir+4)%8][1];
			if(initx>=0 && initx<N && inity>=0 && inity<N) {
				if(map[initx][inity]==cur) return;
			}
			check = true;
			if(cdir==3) {
				fx=i;
				fy=j;
				flag=true;
			}
			return;
		}
		
		if(cnt==0) {
			for (int k = 0; k < 8; k++) {	//8방향 돌면서 갈수 있는 방향 먼저 가기 
				int nx = i+dir[k][0]; 
				int ny = j+dir[k][1]; 
				if(nx<0 || nx >=N || ny<0 || ny>=N) continue;
				if(map[nx][ny]==cur) {	//갈수 있으면 
					int gx = i + dir[k][0]*4;
					int gy = j + dir[k][1]*4;
					if(gx>=0 && gx<N && gy>=0 &&gy<N) {	//5개 만들었을 때 밖으로 안나가는 지
						f(cur, nx, ny, k, cnt+1);	//안나가면 나머지 검사.
					}
				}
			}
		}
		else {
			int nx = i+dir[cdir][0]; 
			int ny = j+dir[cdir][1];
			if(nx<0 || nx >=N || ny<0 || ny>=N || map[nx][ny]!=cur) return;
			f(cur, nx, ny, cdir, cnt+1);	//안나가면 나머지 검사.
		}
	}//end of f()
}//end of class


