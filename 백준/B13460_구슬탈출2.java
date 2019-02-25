import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B13460_구슬탈출2 {

	private static int N;
	private static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 행
		M = sc.nextInt(); // 열
		sc.nextLine();
		int[][] target = new int[3][2];
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String tmp = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j);
				if (tmp.charAt(j) == 'R') {
					target[0][0] = i;
					target[0][1] = j;
				} else if (tmp.charAt(j) == 'B') {
					target[1][0] = i;
					target[1][1] = j;
				} else if (tmp.charAt(j) == 'O') {
					target[2][0] = i;
					target[2][1] = j;
				}
			}
		}

		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		// 빨간거 나오면 성공
		// 파란거 나오면 실패
		// 동시에 빠져도 실패
		// 더이상 구슬이 움직이지 않으면 그만 , 최대 10번

		// #구현
		// bfs로 빨간거 나오면 답, 동시에 나오거나 파란거 나오면 더이상 해당 가지 ㄴㄴ
		// 근데 그럼 map을 계속 clone()해야하나?
		// Q.메모리가 뻑나지 않을까?

		Queue<int[][]> list = new LinkedList<int[][]>();
		Queue<node> q = new LinkedList<node>();
		Queue<Integer> qcnt = new LinkedList<Integer>();
		q.add(new node(target[0][0], target[0][1], target[1][0], target[1][1]));
		qcnt.add(0);
		list.add(map);

		while (!q.isEmpty()) {

			node tmp = q.poll();
			int[][] curInitmap = list.poll();// 여러 맵 만들기 위해
			int cCnt = qcnt.poll();
			if(cCnt==11) break;	//10번이하로 못하면 실패
			int rcx = tmp.redx;
			int rcy = tmp.redy;
			int bcx = tmp.bluex;
			int bcy = tmp.bluey;

			for (int i = 0; i < dir.length; i++) {
				//배열 복사
				int[][] curmap = new int[N][M];
				for (int j = 0; j < curInitmap.length; j++) {
					curmap[j]= curInitmap[j].clone();
				}
//######
//System.out.println();
//System.out.println("==="+i+"===");
//for (int j = 0; j < N; j++) {
//	for (int j2 = 0; j2 < M; j2++) {
//		System.out.print((char)curmap[j][j2]);
//	}
//	System.out.println();
//}
//######
				
				// 이동시 끝까지 이동, 겹치기 ㄴㄴ
				// #만나기 전까지 그전에 O만나면 종료
				int rnx=rcx,bnx=bcx;
				int rny=rcy,bny=bcy;
				switch (i) {
				case 0:// 오른쪽
					if (rcy > bcy) { // 빨간게 더 오른쪽에 있으면 먼저 움직이기
						for (int k = rcy; k < M - 1; k++) {// 빨간거
							rny = k + dir[i][1];//이동
							if (curmap[rnx][rny] == '#') {
								rny -= dir[i][1];	//한칸 뒤로
								break;
							}
							curmap[rnx][rny-dir[i][1]] = '.';
							if (map[rnx][rny] == 'O') {
								break;
							}
						}
						
						for (int k = bcy; k < M - 1; k++) {// 파란거
							bny = k + dir[i][1];
							if (curmap[bnx][bny] == '#' || (bnx==rnx)&& (bny==rny)) {	//이미빨간게있으면
								//빨간자리가 통로 라면!!!
								if(curmap[bnx][bny]=='O') {
									curmap[bnx][bcy-dir[i][1]] = '.';
									break;
								}
								bny -= dir[i][1];
								break;
							}
							curmap[bnx][bny-dir[i][1]] = '.';
							if (map[bnx][bny] == 'O') {
								break;
							}
						}
					} else {
						for (int k = bcy; k < M - 1; k++) {// 파란거
							bny = k + dir[i][1];
							if (curmap[bnx][bny] == '#' ) {	
								bny -= dir[i][1];
								break;
							}
							curmap[bnx][bny-dir[i][1]] = '.';
							if (map[bnx][bny] == 'O') {
								break;
							}
						}
						for (int k = rcy; k < M - 1; k++) {// 빨간거
							rny = k + dir[i][1];
							if (curmap[rnx][rny] == '#' || (bnx==rnx)&& (bny==rny)) {//파란게있으면
								//파란자리가 통로 라면!!!
								if(curmap[rnx][rny]=='O') {
									curmap[rnx][rny-dir[i][1]] = '.';
									break;
								}
								rny -= dir[i][1];
								break;
							}
							curmap[rnx][rny-dir[i][1]] = '.';
							if (map[rnx][rny] == 'O') {
								break;
							}
						}
					}
					// 행은 그대로
					break;
				case 1:// 아래
					if (rcx > bcx) { // 빨간게 더 아래에 있으면 먼저 움직이기
						for (int k = rcx; k < N - 1; k++) {// 빨간거
							rnx = k + dir[i][0];
							if (curmap[rnx][rny] == '#') {
								rnx -= dir[i][0];	//한칸 뒤로
								break;
							}
							
							curmap[rnx-dir[i][0]][rcy] = '.';
							if (curmap[rnx][rny] == 'O') {
								break;
							}
						}
						
						for (int k = bcx; k < N - 1; k++) {// 파란거
							bnx = k + dir[i][0];
							if (curmap[bnx][bny] == '#' || (bnx==rnx) && (bny==rny)) {	//이미빨간게있으면
								if(curmap[bnx][bny]=='O') {
									curmap[bnx-dir[i][0]][bny] = '.';
									break;
								}
								bnx -= dir[i][0];
								
								break;
							}
							curmap[bnx-dir[i][0]][bcy] = '.';
							if (curmap[bnx][bny] == 'O') {
								break;
							}
						}
					} else {
						for (int k = bcx; k < N - 1; k++) {// 파란거
							bnx = k + dir[i][0];
							if (curmap[bnx][bny] == '#' ) {	
								bnx -= dir[i][0];
								break;
							}
							curmap[bnx-dir[i][0]][bcy] = '.';
							if (curmap[bnx][bny] == 'O') {
								break;
							}
						}
						for (int k = rcx; k < N - 1; k++) {// 빨간거
							rnx = k + dir[i][0];
							if (curmap[rnx][rny] == '#' || (bnx==rnx)&& (bny==rny)) {//파란게있으면
								if(curmap[rnx][rny]=='O') {
									curmap[rnx-dir[i][0]][rny] = '.';
									break;
								}
								rnx -= dir[i][0];
								break;
							}
							curmap[rnx-dir[i][0]][rcy] = '.';
							if (curmap[rnx][rny] == 'O') {
								break;
							}
						}
					}
					break;
				case 2:// 왼쪽
					if (rcy < bcy) { // 빨간게 더 왼쪽에 있으면 먼저 움직이기
						for (int k = rcy; k > 1; k--) {// 빨간거
							rny = k + dir[i][1];
							if (curmap[rnx][rny] == '#') {
								rny -= dir[i][1];
								break;
							}
							curmap[rnx][rny-dir[i][1]] = '.';
							if (curmap[rnx][rny] == 'O') {
								break;
							}
						}
						
						for (int k = bcy; k > 1; k--) {// 파란거
							bny = k + dir[i][1];
							if (curmap[bnx][bny] == '#' || (bnx==rnx)&& (bny==rny)) {	//이미빨간게있으면
								if(curmap[bnx][bny]=='O') {
									curmap[bnx][bny-dir[i][1]] = '.';
									break;
								}
								bny -= dir[i][1];
								break;
							}
							curmap[bnx][bny-dir[i][1]] = '.';
							if (curmap[bnx][bny] == 'O') {
								break;
							}
						}
					} else {
						for (int k = bcy; k > 1; k--) {// 파란거
							bny = k + dir[i][1];
							if (curmap[bnx][bny] == '#') {
								bny -= dir[i][1];
								break;
							}
							curmap[bnx][bny-dir[i][1]] = '.';
							if (curmap[bnx][bny] == 'O') {
								break;
							}
						}
						
						for (int k = rcy; k > 1; k--) {// 빨간거
							rny = k + dir[i][1];
							if (curmap[rnx][rny] == '#' || (bnx==rnx)&& (bny==rny)) {	//파란게있으면
								if(curmap[rnx][rny]=='O') {
									curmap[rnx][rny-dir[i][1]] = '.';
									break;
								}
								rny -= dir[i][1];
								break;
							}
							curmap[rnx][rny-dir[i][1]] = '.';
							if (curmap[rnx][rny] == 'O') {
								break;
							}
						}
					}
					break;
				case 3:// 위
					if (rcx < bcx) { // 빨간게 더 위쪽에 있으면 먼저 움직이기
						for (int k = rcx; k > 1; k--) {// 빨간거
							rnx = k + dir[i][0];
							if (curmap[rnx][rny] == '#') {
								rnx -= dir[i][0];
								break;
							}
							curmap[rnx-dir[i][0]][rcy] = '.';
							if (curmap[rnx][rny] == 'O') {
								break;
							}
						}
						
						for (int k = bcx; k > 1; k--) {// 파란거
							bnx = k + dir[i][0];
							if (curmap[bnx][bny] == '#' || (bnx==rnx)&& (bny==rny)) {	//이미빨간게있으면
								if(curmap[bnx][bny]=='O') {
									curmap[bnx-dir[i][0]][bny] = '.';
									break;
								}
								bnx -= dir[i][0];
								break;
							}
							curmap[bnx-dir[i][0]][bcy] = '.';
							if (curmap[bnx][bny] == 'O') {
								break;
							}
						}
					} else {
						for (int k = bcx; k > 1; k--) {// 파란거
							bnx = k + dir[i][0];
							if (curmap[bnx][bny] == '#') {
								bnx -= dir[i][0];
								break;
							}
							curmap[bnx-dir[i][0]][bcy] = '.';
							if (curmap[bnx][bny] == 'O') {
								break;
							}
						}
						
						for (int k = rcx; k > 1; k--) {// 빨간거
							rnx = k + dir[i][0];
							if (curmap[rnx][rny] == '#' || (bnx==rnx)&& (bny==rny)) {	//파란게있으면
								if(curmap[rnx][rny]=='O') {
									curmap[rnx-dir[i][0]][rny] = '.';
									break;
								}
								rnx -= dir[i][0];
								break;
							}
							curmap[rnx-dir[i][0]][rny] = '.';
							if (curmap[rnx][rny] == 'O') {
								break;
							}
						}
					}
					break;
				}
//				System.out.println("rnx:"+rnx+" "+"rny:"+rny);
//				System.out.println("bnx:"+bnx+" "+"bny:"+bny);
				//@메모리 초과  => 움직임이 있는거만 넣자.
				if(rnx==rcx && rny==rcy && bnx==bcx &&bny==bcy) {//움직임이 없을 경우
					continue;
				}
				
				
				// 깊이 카운트
				int nCnt = cCnt + 1;

				if (curmap[rnx][rny] == 'O' && curmap[bnx][bny] == 'O') {// 틀린 탐색 조건1 : 둘다 빠짐
					curmap[rnx][rny] = 'O';
					curmap[bnx][bny] = 'O';
					continue;
				}
				
				// 말 이동
				if (curmap[rnx][rny] != 'O' && curmap[bnx][bny] == 'O') {// 틀린 탐색 조건2 : 파란거만 빠짐
					curmap[rnx][rny] = 'R';
					curmap[bnx][bny] = 'O';
					continue;
				}

				if (curmap[rnx][rny] == 'O' && curmap[bnx][bny] != 'O') { // 답 만족 조건
					if(nCnt==11)break; //넣자마자 바로검사야돼, 큐 머리에서 하면 하나 더들어가****************************
					System.out.println(nCnt);
					System.exit(0);
				}

				qcnt.add(nCnt);
				
				curmap[rnx][rny] = 'R';
				curmap[bnx][bny] = 'B';
				
//######
//for (int j = 0; j < N; j++) {
//	for (int j2 = 0; j2 < M; j2++) {
//		System.out.print((char)curmap[j][j2]);
//	}
//	System.out.println();
//}
//######
				list.add(curmap);
				q.add(new node(rnx,rny,bnx,bny));
			}

		}

		System.out.println(-1);

	}// end of main

}// end of class

class node {
	int redx;
	int redy;
	int bluex;
	int bluey;

	node(int redx, int redy, int bluex, int bluey) {
		this.redx = redx;
		this.redy = redy;
		this.bluex = bluex;
		this.bluey = bluey;
	}

}
