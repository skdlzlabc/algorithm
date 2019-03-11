import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15683_감시 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 1~8
		M = Integer.parseInt(st.nextToken()); // 1~8
		// cctv 최대 8개 !!

		map = new int[N + 2][M + 2];
		tmpMap = new int[N + 2][M + 2];
		al = new ArrayList<Node>();
		int result = N * M; // 전체맵 크기 - (cctv, 벽, 탐색수) : 답
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 6 && map[i][j] != 0) {
					al.add(new Node(i, j, map[i][j] - 1));
				} else if (map[i][j] == 6) { // 6일경우
					result--;
				}
			}
		}
		alSize = al.size();

		// 테두리
		for (int i = 0; i < N + 2; i++) {
			if (i == 0 || i == N + 1) {
				for (int j = 0; j < M + 2; j++) {
					map[i][j] = 6; // 벽
				}
			} else {
				map[i][0] = 6;
				map[i][M + 1] = 6;
			}
		}
		// 맵 복사
		// 사각 지대의 최소 크기
		// dfs로
		// 한방향 바라볼때 다른거 모든 경우의 수

		f(0, 0, map);
		result -= alSize + maxZero;
		System.out.println(result);
	}// end of main
    
    private static ArrayList<Node> al;
	private static int alSize;
	private static int[][] map;
	private static int N;
	private static int M;
	private static int[][] tmpMap;
	private static int[][][] cdir = { { 
			{ 0 }, { 1 }, { 2 }, { 3 } }, 
			{ { 0, 2 }, { 1, 3 } },
			{ { 0, 1 }, { 1, 2 },{ 2, 3 }, { 3, 0 } }, 
			{ { 0, 1, 2 }, { 1, 2, 3 },	{ 2, 3, 0 }, { 3, 0, 1 } },
			{ { 0, 1, 2, 3 } } };
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	private static int maxZero;

	public static void f(int cnt, int zeroCnt, int[][] premap) {
		if (cnt == alSize) {
			if (maxZero < zeroCnt)
				maxZero = zeroCnt;
			return;
		}
		Node cur = al.get(cnt);
		int cx = cur.x;
		int cy = cur.y;

		for (int j = 0; j < cdir[cur.dir].length; j++) {
			int tmpCnt = zeroCnt;

			int[][] curmap = new int[N + 2][M + 2];
			for (int m = 0; m < N + 2; m++) {
				curmap[m] = premap[m].clone();
			}

			for (int k = 0; k < cdir[cur.dir][j].length; k++) {
				int nx = cx + dir[cdir[cur.dir][j][k]][0];
				int ny = cy + dir[cdir[cur.dir][j][k]][1];
				while (true) {
					// 해당 방향 끝까지 탐색
					if (curmap[nx][ny] ==6){	//벽이면 막아
						break;
					}
					if (curmap[nx][ny] == 0) { // 이미 체크 한거면 카운트 ㄴㄴ해
						tmpCnt++;
					}
					curmap[nx][ny] = 7;
					nx += dir[cdir[cur.dir][j][k]][0];
					ny += dir[cdir[cur.dir][j][k]][1];
				}
			}
			f(cnt + 1, tmpCnt, curmap);
		}
	}// end of f()

	static class Node {
		int x;
		int y;
		int dir;

		Node(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}// end of Node{}
}// end of class

/*
 * 1. if(tmpCnt==0) continue;
 * 	=> 해당 방향의 cctv 없을시 패스 해줬는데  모든방향을 다 탐색해보지않고 pass 시킴 ㅠ
 * 2. for(int i= cnt; ~)
 * 	=> 중복조합!!!!으로 하는 바람에 시간초과 발생!
 * 
 */ 
