package dp;

import java.util.Scanner;

public class Q31금광 {
    public static int[][] dp;
    public static int[] dx = {-1,0,1};
    public static int[][] graph;
    public static Scanner sc;
    public static int T,N,M;
    public static void main(String[] args) {
        try {
            sc = new Scanner(System.in);
            String[] strs = sc.nextLine().split(" ");
            T = Integer.parseInt(strs[0]);
            
            while(T-- > 0){
                strs = sc.nextLine().split(" ");
                N = Integer.parseInt(strs[0]);
                M = Integer.parseInt(strs[1]);
                graph = new int[N][M];
                dp = new int[N][M];
                strs = sc.nextLine().split(" ");
                int idx = 0;
                for(int i = 0; i < N; i++){ 
                    for(int j = 0; j < M; j++){
                     graph[i][j] = Integer.parseInt(strs[idx++]);   
                    }
                }
                
                for(int i = 0; i < N; i++){//dp  초기화
                    dp[i][0] = graph[i][0];
                }
                
                for(int i = 1; i < N; i++){
                    for(int j = 0; j < M; i++){
                        
                    }    
                }
                


            }
            
            
            



        } catch (Exception e) {
            //TODO: handle exception
        }finally{
            sc.close();
        }
        
        
    }
}
