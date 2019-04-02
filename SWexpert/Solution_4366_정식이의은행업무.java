import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4366_정식이의은행업무 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int z = 1; z <= tc; z++) {
			//3^40.... 자리수를 다 바꺼 볼 순 없어 => 잘못 생각!!
			long[] 이진수 = new long[40];
			long[] 삼진수 = new long[40];
			for (int i = 0; i < 이진수.length; i++) {
				이진수[i]= (long) Math.pow(2, i);
			}
			for (int i = 0; i < 삼진수.length; i++) {
				삼진수[i]= (long) Math.pow(3, i);
			}
			
			String a = br.readLine();
			String b = br.readLine();
			int lenA = a.length();
			int lenB = b.length();
			
			int[] arr =new int[lenA];
			long sumA =0;
			for (int i = 0; i < lenA ; i++) {
				arr[i]=a.charAt(i)-'0';
//				sumA+=이진수[lenA-i-1]*arr[i];
			}
			int[] brr =new int[lenB];
			long sumB =0;
			for (int i = 0; i < lenB ; i++) {
				brr[i]=b.charAt(i)-'0';
//				sumB+=삼진수[lenB-i-1]*brr[i];
			}
//			System.out.println(sumA);
//			System.out.println(sumB);
			
			//완탐
			//앞에서  한자리 씩 바꿔가면서
xx:			for (int i = 0; i <lenA ; i++) {
				//앞에서 부터 한자리씩 바꿔가면서
				arr[i]++;
				arr[i]%=2;
				for (int kk = 0; kk < lenA ; kk++) {
//					if(kk==i) continue;
					sumA+=이진수[lenA-kk-1]*arr[kk];
				}
				for (int j = 0; j <lenB ; j++) {
					int tmp = brr[j];
					for (int kk = 0; kk < lenB ; kk++) {
						if(kk==j) continue;
						sumB+=삼진수[lenB-kk-1]*brr[kk];
					}
					for (int k = 0; k < 2; k++) {
						if(brr[j]==2) {
							brr[j]=1;
						}else if (brr[j]==1) {
							brr[j]=0;
						}else if (brr[j]==0) {
							brr[j]=2;
						}
						//비교
						//매번 만들어 줄까
						if(sumA==sumB+삼진수[lenB-j-1]*brr[j]) {
							break xx;
						}
					}
					brr[j] = tmp;
					sumB=0;
				}
				sumA=0;
				arr[i]++;
				arr[i]%=2;
			}
			
			System.out.println("#"+z+" "+sumA);
		}
	}//end of main
}//end of class
