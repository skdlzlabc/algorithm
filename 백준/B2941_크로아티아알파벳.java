import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2941_ũ�ξ�Ƽ�ƾ��ĺ� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
			
		/*
		 * lj e s= nj a k
		 * 6���� ã�Ƽ� $���� �ٲ۵� ���� ���
		 */
		String[] priList = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		for (int i = 0; i < priList.length; i++) {
			str = str.replace(priList[i], "$");
		}
		System.out.println(str);
		System.out.println(str.length());
	}//end of main
}//end of class
