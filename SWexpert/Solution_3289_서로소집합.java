import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_���μ����� {
	private static int[] p;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int z = 1; z <= tc; z++) {
			StringBuilder sb= new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			p = new int[N+1]; //1~1,000,000
			//#1. �ϴ� �θ� ���� �����
			for (int i = 1; i < p.length; i++) {
				p[i]=i;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int flag =Integer.parseInt(st.nextToken());
				int a =Integer.parseInt(st.nextToken());
				int b =Integer.parseInt(st.nextToken());
			
				//#2. ������ �θ� �ٸ��� �����ֱ�
				int pa =findParent(a);
				int pb =findParent(b);
				if(flag==0) {
					if(pa!=pb) {
						p[pb]=pa;
					}
				}
				else {
					//#3. �� ���� ���� ���տ� �ִ��� , �θ� ������ Ÿ�� �ö󰡼� �˻�
					if(pa==pb)sb.append(1);
					else sb.append(0);
				}
			}
			
			sb.append("\n");
			System.out.print("#"+z+" "+sb);
		}//end of for()
	}//end of main

	public static int findParent(int cur) {
		if(p[cur]==cur) {
			return cur;
		}
		p[cur] = findParent(p[cur]);
		return p[cur];
	}

}//end of class
