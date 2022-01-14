package dp;

import java.util.*;

class Q33퇴사복습{
    public static void main(String[] args) {
        int n; // 전체 상담 개수
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] t = new int[n]; // 각 상담을 완료하는데 걸리는 기간
        int[] p = new int[n]; // 각 상담을 완료했을 때 받을 수 있는 금액
        int[] dp = new int[n+1]; // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화

        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        
        for(int i = 0; i < n; i++){
            int time = i + t[i];
            if(time <= n){
                //시간 안에 상담이 가능하면, 해당 날짜에 받을 수 있는 기존 최대 금액 vs 오늘까지 받을 수 있는 최대 금액 + 오늘부터 상담한 금액
                dp[time] = Math.max(dp[time] , dp[i] + p[i]);
            }

            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[n]);

    }
}
