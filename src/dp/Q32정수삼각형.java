package dp;

import java.util.*;

public class Q32정수삼각형 {
    public static int[][] graph;
    public static int[][] dp;
    public static int n;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String[] strs;
        try {
            strs = sc.nextLine().split(" ");
            n = Integer.parseInt(strs[0]);
            graph = new int[n][n];
            dp = new int[n][n];

            for(int i = 0; i < n; i++){
                strs = sc.nextLine().split(" ");
                for(int j = 0; j < i+1; j++){
                    graph[i][j] = Integer.parseInt(strs[j]);
                    dp[i][j] = graph[i][j];
                }
            }
            //
            //열만큼 행 반복
            for(int i = 0; i < n-1; i++){
                for(int j = 0; j < i+1; j++){
                    int left,right;
                    left = graph[i+1][j];
                    right = graph[i+1][j+1];
                    
                    dp[i+1][j] = Math.max(dp[i+1][j], (left + dp[i][j]));//left
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1], (right + dp[i][j]));//right
                }
            }
            int result = 0;
            for(int i =0; i < n; i++){
                result = Math.max(result, dp[n-1][i]);
            }
            System.out.println(result);
        } catch (Exception e) {
            //TODO: handle exception
        }finally{
            sc.close();
        }
    }
}
