
public class B6376_e계산 {

	public static void main(String[] args) {

		double[] res = new double[10];
		
		for (int n = 0; n < 10; n++) {
			double e=0;
			for (int i = 0; i <= n; i++) {
				double tmp =1;
				for (int k = 0; k <= i; k++) {
					if(k==0) continue;
					tmp*=(double)1/k;
				}
				e+=tmp;
			}
			res[n]=e;
		}
		
		System.out.println("n e\n" + 
				"- -----------");
		for (int i = 0; i < 2; i++) {
			System.out.println(i+" "+(int)res[i]);
		}
		for (int i = 2; i < 3; i++) {
			System.out.println(i+" "+res[i]);
		}
		for (int i = 3; i < 10; i++) {
			System.out.println(i+" "+String.format("%.9f", res[i]));
		}
	}//end of main
}//end of class

