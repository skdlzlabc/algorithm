import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B15729_방탈출 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		boolean[] check = new boolean [N+2];
		for (int i = 0, j=0; i < 2*N ; i+=2 ,j++) {
			if(str.charAt(i)=='1') { 
				check[j]=true;
			}
		}
		//#구현
		//오른쪽 두개도 같이 열림
		/*
		 * 왼쪽부터 눌러서 
		 */
		//00001
		//00011
		//00111
		int cnt=0;
		for (int i = 0; i < N; i++) {
			if(check[i]) {
				cnt++;
				check[i]= !check[i];
				check[i+1]= !check[i+1];
				check[i+2]= !check[i+2];
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(cnt);
		System.out.println(sb);
	}//end of main
}//end of class
