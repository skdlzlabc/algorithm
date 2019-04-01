import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class 정올_1350_최대신장트리 {
    private static int[] p;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //1~1000   정점
        int M = Integer.parseInt(st.nextToken()); //1~20000 간선
         
        Node[] G = new Node[M];
        for (int i = 0; i < G.length; i++) {
            st = new StringTokenizer(br.readLine());
            G[i]=new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
//      G[0]=new Node(0,0,Integer.MIN_VALUE);
         
        Arrays.sort(G);
         
        p = new int[N+1];
        for (int i = 1; i < p.length; i++) {
            p[i]=i;
        }
         
        int sum=0;
        for (int i = 0; i < G.length; i++) {
            int pa = findParent(G[i].x);
            int pb = findParent(G[i].y);
         
            if(pa!=pb) {
                p[pb]=pa;
                sum+=G[i].w;
            }
        }
        System.out.println(sum);
    }//end of main
     
    public static int findParent(int x) {
        if(p[x]==x) return x;
        p[x] = findParent(p[x]);
        return p[x];
    }//end of findParent()
     
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int w;
        Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
        @Override
        public int compareTo(Node o) {
            return o.w-this.w;  //내림차순
        }
    }//end of Node{}
}//end of class