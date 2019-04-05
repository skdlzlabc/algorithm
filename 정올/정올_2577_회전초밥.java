import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 정올_2577_회전초밥 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 벨트 위에는 같은 종류의 초밥이 둘 이상 있을 수 있다
		 * 벨트의 특정한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공한다. 
		 *  1번 행사에 참가할 경우 이 쿠폰에 적혀진 종류의 초밥 하나를 추가로 무료로 제공
		 *  이 번호에 적혀진 초밥이 현재 벨트 위에 없을 경우, 요리사가 새로 만들어 손님에게 제공
		 *  
		 *  초밥 가짓수의 최대값을 구하는 프로그램
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//접시수 2~3,000,000
		int d = Integer.parseInt(st.nextToken());	//초밥가짓수 2~3000
		int k = Integer.parseInt(st.nextToken());	//연속가능접시 2~3000
		int c = Integer.parseInt(st.nextToken());	//쿠폰번호 1~d
		int[] arr = new int [N+k];
		for (int i = 0; i < N; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		for (int i = N,j=0; i < N+k; i++,j++) {
			arr[i]=arr[j];
		}
		//쿠폰번호간의 간격이 k이상이면 됨!
		//만약 접시에 쿠폰번호가 없을 경우는?
		//#1. 앞에서부터 순자적으로 돌면서 검사하는거
		//전부 k개로 자르고 그안에 중복된값없는지
		//hashset에 넣고 중복 검사	=> 시간 초과날듯
			
		//#2. 
		//최고의 경우 : c가 포함되지 않고 k가 가능 
		//k개에서 중복이 있으면 안돼.
		//중복이 나오는 리스트 구간 저장? 30~100
//		for (int i = 0; i < arr.length; i++) { //시작
//			HashSet set = new HashSet();
//			for (int j = 0; j < k; j++) {	
//				if(set.contains(arr[i+j])) { 
//					//i~i+j가 포함되면 안된다!!
//					break;
//				}
//				set.add(arr[i+j]);
//			}
//		}
		
		//#3
		//통채로 들고 다니자
		//카운트 세주면서
		int[] check= new int[d+1];
		int cnt=0;
		for (int i = 0; i < k; 	i++) {
			if(check[arr[i]]==0) cnt++;
			check[arr[i]]++;
		}
		
		int max=cnt;
		for (int i = k; i < arr.length; i++) {
			check[arr[i-k]]--;//제일 뒤에꺼 빼주기
			if(check[arr[i-k]]==0)	cnt--;
			if(check[arr[i]]==0) 	cnt++;
			check[arr[i]]++;
			
			int tmp =cnt;
			if(check[c]==0)tmp++;
			if(max<tmp) {
				max=tmp;
			}
		}
		System.out.println(max);
	}//end of main
}//end of class











