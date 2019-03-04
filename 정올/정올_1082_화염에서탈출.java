import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정올_1082_화염에서탈출 {

	private static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	private static int N;
	private static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		node5[] qFire = new node5[2500];
		node5[] qPerson = new node5[2500];

		int qFireFront = 0;
		int qFireRear = 0;
		int qPersonFront = 0;
		int qPersonRear = 0;

		// #입력
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == '*') {
					qFire[++qFireRear] = new node5(i, j, 0);
				} else if (map[i][j] == 'S') {
					qPerson[++qPersonRear] = new node5(i, j, 0);
				}
			}
		}

		// #구현
		// 불을 먼저 다 뿌려(D가 아니면 체크)
		// 사람이동! (. D 이면 체크)
		while (qPersonRear!=qFireFront) {	//사람이 탈출 못하면! 종료!
			int tmpFireSize = qFireRear - qFireFront;

			// #1 불 번지기!
			// 깊이 같은 애들 전부 확장
			for (int j = 0; j < tmpFireSize; j++) {
				qFireFront++;
				int cFirex = qFire[qFireFront].x;
				int cFirey = qFire[qFireFront].y;
				int cFireDepth = qFire[qFireFront].depth;

				for (int i = 0; i < 4; i++) {
					int nFirex = cFirex + dir[i][0];
					int nFirey = cFirey + dir[i][1];
					int nFireDepth = cFireDepth + 1;

					if (nFirex < 0 || nFirex >= N || nFirey < 0 || nFirey >= M)
						continue;// 맵 벗어남!

					if (map[nFirex][nFirey] == 'S' || map[nFirex][nFirey] == '.') { // 사람이나 점이면 번져
						map[nFirex][nFirey] = '*';
						qFire[++qFireRear] = new node5(nFirex, nFirey, nFireDepth);
					}
				}
				
//				System.out.println("##########"); // 디버깅용 맵 출력
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < M; j++) {
//						System.out.print((char) map[i][j]);
//					}
//					System.out.println();
//				}
			}//end of for tmpFireSize

			// #2 사람아 도망가!!!
			int tmpPersonSize = qPersonRear - qPersonFront; // 깊이 같은 애들 전부 확장
			for (int j = 0; j < tmpPersonSize; j++) {

				qPersonFront++;
				int cPersonx = qPerson[qPersonFront].x;
				int cPersony = qPerson[qPersonFront].y;
				int cPersonDepth = qPerson[qPersonFront].depth;

				for (int i = 0; i < 4; i++) {
					int nPersonx = cPersonx + dir[i][0];
					int nPersony = cPersony + dir[i][1];
					int nPersonDepth = cPersonDepth + 1;

					if (nPersonx < 0 || nPersonx >= N || nPersony < 0 || nPersony >= M)
						continue;// 맵 벗어남!

					if (map[nPersonx][nPersony] == '.') {
						map[nPersonx][nPersony] = 'S';
						qPerson[++qPersonRear] = new node5(nPersonx, nPersony, nPersonDepth);
					}
					if (map[nPersonx][nPersony] == 'D') { // .이나 D이면 체크
						System.out.println(nPersonDepth);
						System.exit(0); // 탈출하면 종료!
					}
				}

//				System.out.println("@@@@@@@@@@@"); // 디버깅용 맵 출력
//				for (int i = 0; i < N; i++) {
//					for (int jj = 0; jj < M; jj++) {
//						System.out.print((char) map[i][jj]);
//					}
//					System.out.println();
//				}

			}//end of for tmpPersonSize

//			if (qFireFront == qFireRear && qPersonFront == qPersonRear)		//종료조건!!!!!
//				break;
		}
		System.out.println("impossible");
	}// end of main
}// end of class

class node5 {
	int x;
	int y;
	int depth;

	node5(int x, int y, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
}// end of class node5{}

/*
 * # 큐에 잘 들어 가고 있는지 체크!!!!! -if문 잘못해서 계속들어가는 경우 있음
 * # while하나로 큐 두개 관리하기 힘들어!!!
 * 	=> 각각 while문 만들자
 * # 근데 while문 하고 continue xx; 쓰는 것보다 깊이 같은 애들 사이즈 알아서 for문으로 반복하면됨 *********
 */
