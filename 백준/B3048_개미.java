import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B3048_개미 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a=  Integer.parseInt(st.nextToken());
		int b=  Integer.parseInt(st.nextToken());
		
		char[] arr = new char[a];
		String str = br.readLine();
		HashSet<Character> setA = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			arr[i]=str.charAt(i);
			setA.add(str.charAt(i));
		}
		
		char[] brr = new char[b];
		str = br.readLine();
		HashSet<Character> setB = new HashSet<>();
		for (int i = 0; i < brr.length; i++) {
			brr[i]=str.charAt(i);
			setB.add(str.charAt(i));
		}
		
		int cnt = Integer.parseInt(br.readLine());
		
		//합하기
		char[] ans = new char[arr.length+brr.length];
		for (int i = arr.length-1,j=0; i >=0; i--,j++) {
			ans[i]=arr[j];
		}
		for (int i = arr.length,j=0; i < ans.length; i++,j++) {
			ans[i]=brr[j];
		}

		//#구현
		//a기준으로 다른거 있으면 자리 바꾸기
		while(cnt-->0) {
			for (int i = 0; i < ans.length; i++) {
				//끝지점이면 가만히 있어
				//다음께 brr꺼면 바꾸기
				if(setA.contains(ans[i]) && i!=ans.length-1 && setB.contains(ans[i+1])) {
					char tmp = ans[i+1];
					ans[i+1]= ans[i];
					ans[i]=tmp;
					i++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ans.length; i++) {
			sb.append(ans[i]);
		}
		System.out.println(sb);
	}//end of main
}//end of class
