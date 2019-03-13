import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B17070_파이프옮기기 {
	private static int[][] map;
	private static int cnt;
	private static int N;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+2][N+2];
			
		for (int i = 1; i <= N; i++) {
			String tmp = br.readLine();
			for (int j = 1,cnt=0; j <= N; j++, cnt+=2) {
				map[i][j]=tmp.charAt(cnt)-'0';
			}
		}
		for (int i = 0; i < N+2; i++) {
			map[i][N+1]=1;
			map[0][i]=1;
			map[i][0]=1;
			map[N+1][i]=1;
		}
		//#구현
		//가장 처음에 파이프는 (1, 1)와 (1, 2)를 차지하고 있고, 방향은 가로
		//0:가로
		//1:세로
		//2:대각
		f(1,2,0);
		//이차원 배열 안에 노드를 저장
		//도착지점까지 갈수 있는 개수
		//결과 값으로 경로의 개수를 리턴하면 됨
		System.out.println(cnt);
	}//end of  main
	
	public static void f(int cx, int cy, int dir) {
		if(dir==0) {//현재 오른쪽이면, 오른쪽 대각 가능
			if(map[cx][cy+1]==0) {
				if(cx==N && cy+1==N) {
					cnt++;
				}
				else
					f(cx,cy+1,0);
			}
			if(map[cx+1][cy+1]==0 && map[cx][cy+1]==0 && map[cx+1][cy]==0) {
				
				if(cx+1==N && cy+1==N) {
					cnt++;
				}
				else
					f(cx+1,cy+1,2);
			}
		}
		
		else if(dir==1) {//현재 아래면, 아래 대각 가능
			if(map[cx+1][cy]==0) {
				if(cx+1==N && cy==N) {
					cnt++;
				}
				else
					f(cx+1,cy,1);
			}
			if(map[cx+1][cy+1]==0 && map[cx][cy+1]==0 && map[cx+1][cy]==0) {
				if(cx+1==N && cy+1==N) {
					cnt++;
				}
				else
					f(cx+1,cy+1,2);
			}
		}
		
		else if(dir==2) {//현재 대각이면, 아래 가로 대각 가능
			if(map[cx][cy+1]==0) {
				if(cx==N && cy+1==N) {
					cnt++;
				}
				else
					f(cx,cy+1,0);
			}
			if(map[cx+1][cy]==0) {
				if(cx+1==N && cy==N) {
					cnt++;
				}
				else
					f(cx+1,cy,1);
			}
			if(map[cx+1][cy+1]==0 && map[cx][cy+1]==0 && map[cx+1][cy]==0) {
				if(cx+1==N && cy+1==N) {
					cnt++;
				}
				else
					f(cx+1,cy+1,2);
			}
		}
	}//end of f()
	
	
}//end of class
