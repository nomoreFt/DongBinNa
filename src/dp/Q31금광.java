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
                     dp[i][j] = graph[i][j];
                    }
                }
                
                for(int j = 1; j < M; j++){
                    for(int i = 0; i < N; i++){
                        int leftUp,left,leftDown;
                        if(i == 0) leftUp = 0;
                        else leftUp = dp[i-1][j-1];
                        
                        if(i == N-1) leftDown = 0;
                        else leftDown = dp[i+1][j-1];
                        
                        left = dp[i][j-1];
                        
                        dp[i][j] = dp[i][j] + Math.max(leftUp,Math.max(left,leftDown));
                    }
                }
                int result = 0;
                for(int i = 0; i < N; i++){
                    result = Math.max(result,dp[i][M-1]);
                }
                System.out.println(result);


            }
            
            
            



        } catch (Exception e) {
            //TODO: handle exception
        }finally{
            sc.close();
        }
        
        
    }
}
