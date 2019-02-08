package algorithm;

import java.util.Arrays;

public class Solution_마이쮸 {
	public static void main(String[] args) {
		int[] q =new int[100];
		int[] myZZu = new int[15];
		int front = -1;
		int rear = -1;
		int myZZuIndex = -1;	//계속해서 새로운 마이쮸 넣기 위해
		int totalMyZZu = 20 ; //전체 마이쮸

		while(totalMyZZu>0) {
			//1. 큐 제일 앞에 있는애 빼서 뒤로
			if(front!=rear) {
				int tmp = q[++front];	//제일 앞에있는거 뺴서 저장
				myZZu[q[front]]++;		//마이쮸 주고
				q[++rear] =tmp;			//제일 뒤에 넣기
			}
			
			//2. 새로운 애 큐 제일 뒤로 넣기
			q[++rear] = ++myZZuIndex;	
			myZZu[myZZuIndex]++;		//마이쮸 쥬고
			
			totalMyZZu -= myZZu[q[front+1]];	//제일 앞에있는거 마이쮸 주기
			
			if(totalMyZZu<=0)	//마지막
				System.out.println("마지막에 받는 사람: "+(q[front+1]+1)+"번째 사람");
			
		}
		System.out.println("사람 별 받을 마이쮸개수\n"+Arrays.toString(myZZu));
	}//end of main
}//end of class

