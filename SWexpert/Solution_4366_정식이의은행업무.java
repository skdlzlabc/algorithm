import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4366_��������������� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int z = 1; z <= tc; z++) {
			//3^40.... �ڸ����� �� �ٲ� �� �� ���� => �߸� ����!!
			long[] ������ = new long[40];
			long[] ������ = new long[40];
			for (int i = 0; i < ������.length; i++) {
				������[i]= (long) Math.pow(2, i);
			}
			for (int i = 0; i < ������.length; i++) {
				������[i]= (long) Math.pow(3, i);
			}
			
			String a = br.readLine();
			String b = br.readLine();
			int lenA = a.length();
			int lenB = b.length();
			
			int[] arr =new int[lenA];
			long sumA =0;
			for (int i = 0; i < lenA ; i++) {
				arr[i]=a.charAt(i)-'0';
//				sumA+=������[lenA-i-1]*arr[i];
			}
			int[] brr =new int[lenB];
			long sumB =0;
			for (int i = 0; i < lenB ; i++) {
				brr[i]=b.charAt(i)-'0';
//				sumB+=������[lenB-i-1]*brr[i];
			}
//			System.out.println(sumA);
//			System.out.println(sumB);
			
			//��Ž
			//�տ���  ���ڸ� �� �ٲ㰡�鼭
xx:			for (int i = 0; i <lenA ; i++) {
				//�տ��� ���� ���ڸ��� �ٲ㰡�鼭
				arr[i]++;
				arr[i]%=2;
				for (int kk = 0; kk < lenA ; kk++) {
//					if(kk==i) continue;
					sumA+=������[lenA-kk-1]*arr[kk];
				}
				for (int j = 0; j <lenB ; j++) {
					int tmp = brr[j];
					for (int kk = 0; kk < lenB ; kk++) {
						if(kk==j) continue;
						sumB+=������[lenB-kk-1]*brr[kk];
					}
					for (int k = 0; k < 2; k++) {
						if(brr[j]==2) {
							brr[j]=1;
						}else if (brr[j]==1) {
							brr[j]=0;
						}else if (brr[j]==0) {
							brr[j]=2;
						}
						//��
						//�Ź� ����� �ٱ�
						if(sumA==sumB+������[lenB-j-1]*brr[j]) {
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
