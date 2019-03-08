import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7569_토마토2 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		// 왼쪽, 오른쪽, 앞, 뒤,위, 아래, 여섯 방향

		// 밑의 상자부터 가장 위의 상자까지에 저장
		Queue<Node> q = new LinkedList<Node>();
		int cntZero = 0;
		int[][][] map = new int[N + 2][M + 2][H + 2];
		for (int k = H; k >= 1; k--) { // 젤 아래 줄 부터 채움
			for (int i = 1; i <= N ; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 1; j <= M ; j++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if (map[i][j][k] == 1) {
						q.add(new Node(i, j, k, 0));
					} else if (map[i][j][k] == 0) {
						cntZero++;
					}
				}
			}
		}

		// 토마토가 하나도 없다!
		if (q.isEmpty()) {
			System.out.println(-1);
			return;
		}
		// 전부 익어있다!!!
		else if (q.size() == N * M * H) {
			System.out.println(0);
			return;
		}
		// 맵 테두리 -1 넣기 ==> 정사각형이 아닌경우 조심!!!!!*******
		for (int h = 0; h < H+2; h++) {
			if(h==0 || h == H+1) {
				for (int i = 0; i < N+2; i++) {
					for (int j = 0; j < M+2; j++) {
						map[i][j][h]=-1;
					}
				}
			}
			else {
				for (int i = 0; i < N + 2; i++) {
					if (i == 0 || i == N + 1) { // 젤위랑 젤 아래만 체크
						for (int j = 0; j < M + 2; j++) {
							map[i][j][h] = -1;
						}
					} else {// 중간부분은 끝점만!!!
						map[i][0][h] = -1;
						map[i][M + 1][h] = -1;
					}
				}
			}
		}

		// 큐 돌리기~
		int minDay = 0;
		int[][] dir = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, 0 }, { 0, 0 } }; // ,,,,상,하
		int[] dirh = { 0, 0, 0, 0, -1, 1 }; // ,,,,상,하
		while (!q.isEmpty()) {
			int cx = q.peek().x;
			int cy = q.peek().y;
			int cz = q.peek().z;
			int cday = q.peek().day;
			q.poll();
			for (int j = 0; j < 6; j++) {
				int nx = cx + dir[j][0];
				int ny = cy + dir[j][1];
				int nz = cz + dirh[j];

				if (map[nx][ny][nz] == 0) { // 토마토 안익었으면
					cntZero--; // 0인 부분개수 빼주자. 나중에 불능경우 체크위해
					map[nx][ny][nz] = 1;
					if (cday + 1 > minDay)
						minDay = cday + 1; // 최소 일수 알기 위해
					q.add(new Node(nx, ny, nz, cday + 1));
				}
			}

		} // end of cQueSize

		if (cntZero != 0) { // 토마토가 익지 못하는 상황!!
			System.out.println(-1);
		} else { // 전부 익은경우!
			System.out.println(minDay);
		}

	}// end of main

	static class Node {
		int x;
		int y;
		int z;
		int day;

		Node(int x, int y, int z, int day) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}
	}// end of Node{}
}// end of class
