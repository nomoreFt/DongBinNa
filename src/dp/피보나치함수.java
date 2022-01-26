package dp;

import java.util.*;
/*
* 피보나치의 0의 개수, 1의 개수도 또한 -1, -2 번째의 0의 개수의 합, -1.-2번째의 1의 개수의 합에 따른다.
*/
public class 피보나치함수 {
    static int[][] dp = new int[42][2];
    static final int INF = (int) 1e9;
    static int testCase;
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       testCase = sc.nextInt();
       for(int i = 0; i < 42; i++){
        Arrays.fill(dp[i],INF);
       }
       dp[0][0] = 1;
       dp[0][1] = 0;
       dp[1][0] = 0;
       dp[1][1] = 1;
       
       while(testCase-- > 0){
           int n = sc.nextInt();
           fibo(n);
           System.out.println(dp[n][0] + " " + dp[n][1]);
       }
   }
   static int[] fibo(int n){
       if(dp[n][0] == INF || dp[n][1] == INF){
           dp[n][0] = fibo(n-1)[0] + fibo(n-2)[0];
           dp[n][1] = fibo(n-1)[1] + fibo(n-2)[1];
       }
       return dp[n];
   }
}
