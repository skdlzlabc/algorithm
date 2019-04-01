import java.util.Scanner;

public class Solution_4796_의석이의우뚝선산 {

	public static void main(String[] args)  {
		//채점시 BufferedReader 컴파일 에러 나서 Scanner씀
		Scanner sc = new Scanner(System.in);
		int tc =sc.nextInt(); 
		for (int z = 1; z <= tc; z++) {
			int N =sc.nextInt();
			int[] arr= new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i]= sc.nextInt();
			}
			/*
			 * 높이를 기준으로 짜르기 
			 */
			int result=0;
			for (int i = 1; i < arr.length-1; i++) {
				//좌
				int left=0;
				for (int j = i; j >0; j--) {
					if(arr[j-1]>arr[j]) break;
					left++;
				}
				//우
				if(left==0) continue;
				int right=0;
				for (int j = i; j < arr.length-1; j++) {
					if(arr[j+1]>arr[j]) break;
					right++;
				}
				int sum = left*right;
				result+=sum;
				if(sum!=0) i+=right;
				
			}
			System.out.println("#"+z+" "+result);
		}//end of for tc
		sc.close();
	}//end of main
}//end of class
