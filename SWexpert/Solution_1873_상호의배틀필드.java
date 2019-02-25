import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int z = 1; z <= testCase; z++) {
			// #입력
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];

			char tankdir = ' ';// 초기 탱크 방향
			int cx = 0, cy = 0; // 초기 탱크 위치
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					char tmp = str.charAt(j);
					map[i][j] = tmp;
					if (tmp != '.' && tmp != '*' && tmp != '#' && tmp != '-') {
						tankdir = tmp;
						cx = i;
						cy = j;
					}
				}
			}
			
			int len = Integer.parseInt(br.readLine());

			char[] userMove = new char[len];
			String str = br.readLine();
			for (int i = 0; i < userMove.length; i++) {
				userMove[i] = str.charAt(i);
			}

//			int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}}; //오른 아래 왼 위

			// #구현
			// 방향 바꾸고 **** + 한칸 이동
			// 벽돌 포탄으로 부셔짐
			// userMove에서 하나씩 읽어가면서 명령어 수행, 맵 수정
			for (int i = 0; i < len; i++) {
				int nx = 0;
				int ny = 0;
				switch (userMove[i]) {
				case 'U':
					// 방향 바꾸고, 평지면 이동
					tankdir = '^';
					nx = cx - 1;
					ny = cy;
					if (nx >= 0 && map[nx][ny] == '.') { // 평지면 이동
						map[cx][cy]='.';
						cx = nx;
						cy = ny;
					}
					map[cx][cy]=tankdir;
					break;
				case 'D':
					// 방향 바꾸고, 평지면 이동
					tankdir = 'v';
					nx = cx + 1;
					ny = cy;
					if (nx < H && map[nx][ny] == '.') { // 평지면 이동
						map[cx][cy]='.';
						cx = nx;
						cy = ny;
					}
					map[cx][cy]=tankdir;
					break;
				case 'L':
					// 방향 바꾸고, 평지면 이동
					tankdir = '<';
					nx = cx;
					ny = cy - 1;
					if (ny >= 0 && map[nx][ny] == '.') { // 평지면 이동
						map[cx][cy]='.';
						cx = nx;
						cy = ny;
					}
					map[cx][cy]=tankdir;
					break;
				case 'R':
					// 방향 바꾸고, 평지면 이동
					tankdir = '>';
					nx = cx;
					ny = cy + 1;
					if (ny < W && map[nx][ny] == '.') { // 평지면 이동
						map[cx][cy]='.';
						cx = nx;
						cy = ny;
					}
					map[cx][cy]=tankdir;
					break;
				case 'S': // 포탄
					// 벽돌이면 뿌셔
					int tmpx = cx;
					int tmpy = cy;
					switch (tankdir) {
					case '>':
						while (tmpy < W-1) { // 해당 방향으로 계속 증가 하면서
							++tmpy;
							int tmpwall = map[tmpx][tmpy];
							if (tmpwall == '*') {// 벽돌 찾으면 평지로
								map[tmpx][tmpy] = '.';
								break;
							}
							else if (tmpwall =='#') {
								break;
							}
						}
						break;
					case '<':
						while (tmpy >= 1) { // 해당 방향으로 계속 증가 하면서
							--tmpy;
							int tmpwall = map[tmpx][tmpy];
							if (tmpwall == '*') {// 벽돌 찾으면 평지로
								map[tmpx][tmpy] = '.';
								break;
							}
							else if (tmpwall =='#') {
								break;
							}
						}
						break;
					case '^':
						while (tmpx >= 1) { // 해당 방향으로 계속 증가 하면서
							--tmpx;
							int tmpwall = map[tmpx][tmpy];
							if (tmpwall == '*') {// 벽돌 찾으면 평지로
								map[tmpx][tmpy] = '.';
								break;
							}
							else if (tmpwall =='#') {
								break;
							}
						}
						break;
					case 'v':
						while (tmpx < H-1) { // 해당 방향으로 계속 증가 하면서
							++tmpx;
							int tmpwall = map[tmpx][tmpy];
							if (tmpwall == '*') {// 벽돌 찾으면 평지로
								map[tmpx][tmpy] = '.';
								break;
							}
							else if (tmpwall =='#') {
								break;
							}
						}
						break;

					default:
						break;
					}
					break;

				default:
					break;
				}
			}

			// #출력
			sb.append("#").append(z).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append((char)map[i][j]);
				}
				sb.append("\n");
			}
		} // end of for testCase
		System.out.println(sb);
	}// end of main
}// end of class
