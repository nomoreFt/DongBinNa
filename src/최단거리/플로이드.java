package 최단거리;

import java.util.*;
import java.io.*;

public class 플로이드 {
    static int[][] graph = new int[101][101];
    static int n,m;
    static final int INF = (int)1e9;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for(int i = 0; i < 101; i++){
            Arrays.fill(graph[i], INF);
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i==j) graph[i][j] = 0;
            }
        }
        String[] strs;
        for(int i = 0; i < m; i++){
            strs = br.readLine().split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            int c = Integer.parseInt(strs[2]);
            
            graph[a][b] = Math.min(graph[a][b],c);
        }

        for(int k = 1; k <= n; k++){
            for(int a = 1; a <= n; a++){
                for(int b = 1; b <= n; b++){
                    graph[a][b] = Math.min(graph[a][b],graph[a][k] + graph[k][b]);
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            String str = "";
            for(int j = 1; j<=n; j++){
                if(graph[i][j] == INF){
                    str += 0 + " ";
                }else{
                    str +=  graph[i][j] + " ";
                }
            }
            System.out.println(str);
        }
        


        br.close();
        
    }
}
