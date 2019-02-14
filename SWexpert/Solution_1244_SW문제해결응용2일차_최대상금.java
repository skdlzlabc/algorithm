//2.14
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 
 * 최대상금 greedy
 *
 */

public class Solution_1244_SW문제해결응용2일차_최대상금 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken(); //숫자판의 값
			Integer[] num = new Integer[s.length()]; //숫자판의 각 숫자를 저장할 배열
			for (int i = 0; i < num.length; i++) {
				num[i] = s.charAt(i)-'0';		//char --> int 숫자값으로 변경
			}
			int N = Integer.parseInt(st.nextToken());	//교환횟수
			
			//동일한 숫자를 교환했는지 체크하기 위한 ArrayList를 담은 배열을 준비
			ArrayList<Integer> [] check = new ArrayList[10];		//ArrayList를 배열에도 담을 수 있음 ******
			for (int i = 0; i < check.length; i++) {
				check[i]=new ArrayList<Integer>();	//각각의 배열방에 ArrayList 객체 생성해서 저장해놓음
			}
			
//구현부
			//선택정렬
			//132 1 =>312
			for (int i = 0; i < num.length && N>0; i++) {	// %% N>0 ***************
				int maxIndex = i;		//가장 큰 숫자의 index
				for (int j = i; j < num.length; j++) {
					if(num[maxIndex] <= num[j]) {	// = 을 넣어줘야 같은거라도 옮김 2737 1 => 7732
						maxIndex=j;
					}
				}
				if(num[maxIndex] == num[i]) continue;	//최대숫자의 위치가 MSB 위치가 아닐때만 교환	312 1 => 321
				int tmp = num[maxIndex];
				num[maxIndex] = num[i];
				num[i]=tmp;
				N--;	//교환 회수 감소
				
				//교환시 동일한 숫자가 교횐되면, 떠난자리를 기억했다가 (떠난 자리의 숫자들만) 교환회수의 감소없이 재정렬
				//교환후 시점, 최대숫자의 값: tmp, 최대숫자가 떠난 자리 maxIndex
				ArrayList<Integer> alNum = check[tmp];	//tmp 최대숫자의 떠난 자리를 기억하고 있는 ArrayList
				alNum.add(maxIndex);	//떠난자리 추가
				
				if(alNum.size()>=2) {	//떠난 자리가 2개 이상되면, 재정렬 작업 진행
					Collections.sort(alNum);	//떠난 자리 index를 오름차순으로 정렬
					for (int j = 0; j < alNum.size(); j++) {	//선택정렬
						int maxI = alNum.get(i);
						for (int k = j; k < alNum.size(); k++) {
							if(num[maxI] < num[alNum.get(k)]) {
								maxI=alNum.get(k);
							}
						}
						int tmp1 = num[maxI];
						num[maxI] = num[alNum.get(j)];
						num[alNum.get(j)] = tmp1;
					}
				}
			}
			
			//똑같은 숫자가 한쌍이라도 있으면, 값의 변화 없이 교환회수를 줄일 수 있다.
			HashSet<Integer> hs = new HashSet<Integer>(Arrays.asList(num));	//배열 -> List ->HashSet
			
			
			// 내림차순 정렬이 끝났는데도, 교환횟수가 남은경우 321 1
			// 숫자의 영향력이 적은 뒤쪽의 숫자를 바꿔 주겠다. 즉, 자리수의 가치가 적은 LSB를 교환한다.
			if(N%2==1 && hs.size() == num.length) {	//홀수 일 경우 + 같은 숫자가 없을때
				//4321일때-> 4312 -> 4321 -> 4312 -> 4321 -> 4312. 걍 한번만 바꾼거랑 같음
				int tmp = num[num.length-1];
				num[num.length-1]=num[num.length-2];
				num[num.length-2]=tmp;
			}
			
//			else {	//짝수 일 경우
//				//4321일때-> 4312 -> 4321 그대로임 . 무시하셈
//			}
			
			System.out.print("#"+testCase+" ");
			for (int i = 0; i < num.length; i++) {
				System.out.print(num[i]);
			}
			System.out.println();
		}
		
	}//end of main
}//end of class
