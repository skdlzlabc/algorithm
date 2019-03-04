import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16917_양념반후라이드반 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());// 양념
		int B = Integer.parseInt(st.nextToken());// 후라이드
		int C = Integer.parseInt(st.nextToken());// 반반

		int cntA = Integer.parseInt(st.nextToken());// 양념 최소수
		int cntB = Integer.parseInt(st.nextToken());// 후라이드 최소수

		// #구현
		// 반반 두마리 : 양념 한마리 + 후라이드 한마리
		// A+B > C 일때 반반 두마리 사자, A,B더 작은수 기준으로 다 이렇게 사자
		int pay1 = Integer.MAX_VALUE;	//반반+한마리
		int pay2 = Integer.MAX_VALUE;	//전부 한마리씩
		int pay3 = Integer.MAX_VALUE;	//전부 반반(환경문제야기)
		int oricntA = cntA;
		int oricntB = cntB;
		// #1 #2 #3 경우 고려

		// #1 반반 + 한마리씩
		if (A + B >= 2 * C) { // 반반사는게 이득!
			// 호식이 두마리일때
			if (cntA >= cntB) { // 후라이드가 더 작아
				pay1 = C * (cntB * 2); // 4마리 사야 각각 2마리
				cntA -= cntB;
				cntB = 0;
			} else if (cntB > cntA) {// 양념이 더 작아
				pay1 = C * (cntA * 2);
				cntB -= cntA;
				cntA = 0;
			}
			// 나머지 처리~
			if (cntA == 0) {// 남은 후라이드 처리
				pay1 += B * cntB;
			} else {
				pay1 += A * cntA;
			}
		}
		
		// #2 전부 각각
		// 아니다 각각 사는게 이득이다!
		pay2 = A * oricntA + B * oricntB;
	
		// #3 전부 반반
		if(oricntA>=oricntB) {
			pay3 = C * (oricntA *2);
		}
		else {
			pay3 = C * (oricntB *2);
		}
		
		//비교
		pay1 = pay1 > pay2 ? pay2 : pay1;// 둘중 작은거
		pay3 = pay2 > pay3 ? pay3 : pay2;
		int result = pay1 > pay3 ? pay3 : pay1;// 둘중 작은거

		System.out.println(result);

	}// end of main
}// end of class

/*
 * 최소 갯수임!!!!!!!!! 더 많이 사도 돼
 */
