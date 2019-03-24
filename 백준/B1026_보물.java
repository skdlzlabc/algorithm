import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1026_���� {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		Integer[] arr = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int[] brr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < brr.length; i++) {
			brr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(brr);
		Arrays.sort(arr,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		int sum=0;
		for (int i = 0; i < brr.length; i++) {
			sum+= arr[i]*brr[i];
		}
		System.out.println(sum);
		
		/*
		 * 50! ��� �Ұ�	
		 * 6 1 1 1 0
		 * 1 2 3 7 8
		 * �Ʒ��� ��������
		 * ������ ���� ����
		 */
		
	}//end of main
}//end of class
