package 최단거리;

import java.util.*;

public class 정확한순위 {
    static int[][] graph = new int[501][501];
    static final int INF = (int) 1e9;
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < 501; i++){
            Arrays.fill(graph[i],INF);
        }
        for(int i = 1; i <= n; i++ ){
            for(int j = 1; j <= n; j++){
                if(i==j) graph[i][j] = 0;
            }
        }
        
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }

        for(int k = 1; k <= n; k++){
            for(int a = 1; a <= n; a++ ){
                for(int b=1; b<=n; b++){
                    graph[a][b] = Math.min(graph[a][b],graph[a][k] + graph[k][b]);
                }
            }
        }
        
        int result = 0;
        int count = 0;
        for(int i = 1; i <= n; i++){
            count = 0;
            for(int j = 1; j <= n; j++){
                if(graph[i][j] != INF || graph[j][i] != INF) count++;
            }
            if(count == n) result++;
        }
        System.out.println(result);
        
        sc.close();
    }
    
}
