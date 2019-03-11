import java.util.Scanner;

public class B9095_123더하기 {

	public static void main(String[] args) {
		//1
		//2
		//3
		//을 나타내는 방법
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int[] arr = new int[12];
		arr[1]=1;	//1
		arr[2]=2;	//11, 2
		arr[3]=4;	//111, 21, 12, 3
		for (int i = 4; i < 12; i++) {
			arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
		}
		for (int i = 0; i < T; i++) {
			System.out.println(arr[sc.nextInt()]);
		}
		
	}//end of main
}//end of class
