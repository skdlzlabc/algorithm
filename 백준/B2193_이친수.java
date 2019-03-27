import java.util.Scanner;

public class B2193_이친수 {
	public static void main(String[] args) {
		
		//피보나치네
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		long[] d = new long[N];
		
		d[0]=1;
		if(N==1) {
			System.out.println(1);
			return;
		}
		
		d[1]=1;
		for (int i = 2; i < d.length; i++) {
			d[i]=d[i-1]+d[i-2];
		}
		
		System.out.println(d[N-1]);
		
	}//end of main
}//end of class
