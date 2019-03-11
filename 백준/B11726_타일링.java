import java.util.Scanner;

public class B11726_타일링 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();	//1~1000
		
		long[] d = new long[N+1];
		
		d[1] = 1;
		if(N==1) {
			System.out.println(1);
			return;
		}
		d[2] = 2;
		
		for (int i = 3; i < d.length; i++) {
			d[i]=d[i-1]+d[i-2];
			d[i]%=10007;
		}
		System.out.println(d[N]);
		
		sc.close();
			
	}//end of main
}//end of class
