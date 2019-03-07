import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
  
public class 정올_1863_종교 {
  
    private static int[] p;
  
    public static void main(String[] args) throws Exception {
  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());   //학생수
        int m = Integer.parseInt(st.nextToken());   //쌍의수
        
        //#구현
        //서로소 집합
        p = new int[n+1];   //50000명 까지 써야돼
        for (int i = 0; i < p.length; i++) {
            p[i]=i;
        }
        
        int result = n;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int pa = findSetParent(a);
            int pb = findSetParent(b);
            if(pa != pb) {  //부모가 다르다. == 다른 집합에 속해있다. 즉, 사이클이 생기지 않는다.
                //둘이 합치기    
                if(pa<=pb)   //큰놈기준으로 하자
                    p[pb] = pa;
                else
                    p[pa]=pb;
                result--;
            }
        }
        System.out.println(result); 
    }//end of main
    
    
    public static int findSetParent(int index) {
        if(p[index]==index) {
            return index;
        }
        p[index] = findSetParent(p[index]); 
        return p[index];
    }//end of findSetParent()
      
}//end of class