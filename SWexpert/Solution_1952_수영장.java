import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {
	private static int[] price;
	private static int[] month;
	private static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int z = 1; z <= testCase; z++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			price = new int[4];
			for (int i = 0; i < price.length; i++) {
				price[i]= Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			month = new int[14];
			for (int i = 0; i < month.length-2; i++) {
				month[i]= Integer.parseInt(st.nextToken());
			}
			min = price[3];	//1년 요금
			f(0,0);
			
			sb.append("#").append(z).append(" ").append(min).append("\n");
		}//end of for testCase
		System.out.println(sb);
	}//end of main
	
	public static void f(int curMonth,int curPrice) {
		if(curMonth>=12) {
			min = min > curPrice ? curPrice: min;
			return;
		}
		//1일
		//1달
		//3달
		f(curMonth+1,curPrice+(price[0]*month[curMonth]));
		f(curMonth+1,curPrice+price[1]);
		f(curMonth+3,curPrice+price[2]);
			
		
	}//end of f()
	
}//end of class






