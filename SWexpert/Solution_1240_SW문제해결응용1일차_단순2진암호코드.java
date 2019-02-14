import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1240_SW문제해결응용1일차_단순2진암호코드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCast = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= testCast; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int ans=0;
			
			//앞에서 부터 읽다가 1나오면 스탑
			String str ="";
			for (int k = 0,j=0; k < N; k++) {
				String tmpp = br.readLine();
				if(j==1) continue;
				if(tmpp.contains("1")) {
					str=tmpp;
					j=1;
				}
			}
		
			int lastIndex = str.lastIndexOf("1");
			
			String[] set = {"0001101",
							"0011001",
							"0010011",
							"0111101",
							"0100011",
							"0110001",
							"0101111",
							"0111011",
							"0110111",
							"0001011",
					}; 

			int[] lockCode =new int[8];
			
			for (int j = 0; j < 8; j++) {	//숫자 8개 찾기
				String tmp = "";
				for (int j2 = 6; j2 >= 0; j2--) {	//숫자당 0 1 배열 파악
					tmp += str.charAt(lastIndex - j2);
				}
				for (int j3 = 1; j3 < set.length; j3++) {// 파악된 수가 몇인지
					if(tmp.equals(set[j3])) {
						lockCode[8-j-1]=j3;
					}
				}
				lastIndex -= 7;
			}
			int even=0;
			int odd=0;
			int sum=0;
			int code=0;
			
			even = lockCode[0]+lockCode[2]+lockCode[4]+lockCode[6];
			odd = lockCode[1]+lockCode[3]+lockCode[5];
			code = lockCode[7];
			sum = even*3 + odd + code;
			if(sum%10==0) {
				ans = even + odd + code;
			}
			
			System.out.println("#"+i+" "+ans);
		}
		
	}//end of main
}//end of class
