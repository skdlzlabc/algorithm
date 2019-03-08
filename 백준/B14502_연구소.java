import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502_연구소 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 맵을 2 크게 만들어
		initVirus = new ArrayList<Node>();
		initZeroMap = new ArrayList<Node>();
		map = new int[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {// 바이러스 미리 넣어두기
					initVirus.add(new Node(i, j));
				} else if (map[i][j] == 0) {
					initZeroMap.add(new Node(i, j));
					initZeroCnt++; // 0 : 안전영역
				}
			}
		}

		// 외각을 1처리 하자
		for (int i = 0; i < N + 2; i++) {
			if (i == 0 || i == N + 1) {
				for (int j = 0; j < M + 2; j++)
					map[i][j] = 1;
			} else {
				map[i][0] = 1;
				map[i][M + 1] = 1;
			}
		}

		// #구현
		// 안전 영역의 최대 크기
		// 0의 개수!!d
		tmpMap = new int[N + 2][M + 2];

		// #1. 벽 세우기!
		int initZeroMapSize = initZeroMap.size();
		for (int i = 0; i < initZeroMapSize - 2; i++) {
			for (int j = i + 1; j < initZeroMapSize - 1; j++) {
				for (int k = j + 1; k < initZeroMapSize; k++) {
					map[initZeroMap.get(i).x][initZeroMap.get(i).y] = 1;
					map[initZeroMap.get(j).x][initZeroMap.get(j).y] = 1;
					map[initZeroMap.get(k).x][initZeroMap.get(k).y] = 1;
					// #2. 바이러스 퍼뜨리기
					process();
					map[initZeroMap.get(i).x][initZeroMap.get(i).y] = 0;
					map[initZeroMap.get(j).x][initZeroMap.get(j).y] = 0;
					map[initZeroMap.get(k).x][initZeroMap.get(k).y] = 0;
				}
			}
		}
		System.out.println(maxSize);

	}// end of main

	private static int M;
	private static int N;
	private static int[][] map;
	private static ArrayList<Node> initVirus;
	private static int initZeroCnt;
	private static Queue<Node> q;
	private static int maxSize;
	private static int[][] tmpMap;
	private static ArrayList<Node> initZeroMap;

	public static void process() {
		q = new LinkedList<Node>();
		int initVirusSize = initVirus.size();
		// 초기 바이러스 넣어주고
		for (int i = 0; i < initVirusSize; i++) {
			q.add(new Node(initVirus.get(i).x, initVirus.get(i).y));
		}

		// 맵 복사
		for (int i = 0; i < map.length; i++) {
			tmpMap[i] = map[i].clone();
		}

		// 퍼뜨리자!
		int tmpZeroCnt = bfs(initZeroCnt);
		if (maxSize < tmpZeroCnt)
			maxSize = tmpZeroCnt;
		return;

	}// end of process()

	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static int bfs(int ZeroCnt) { // 바이러스 퍼뜨리기
		while (!q.isEmpty()) {
			Node tmpNode = q.poll();
			int cx = tmpNode.x;
			int cy = tmpNode.y;

			for (int i = 0; i < dir.length; i++) {
				int nx = cx + dir[i][0];
				int ny = cy + dir[i][1];

				if (tmpMap[nx][ny] == 0) {
					tmpMap[nx][ny] = 2;
					q.add(new Node(nx, ny));
					ZeroCnt--;
				}
			}
		}
		return ZeroCnt - 3; // '-3' : 칸막이 개수
	}// end of bfs()

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}// end of Node{}
}// end of class
