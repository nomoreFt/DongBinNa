package dp;

import java.util.*;


//기간 파라메트릭 서치
public class Q33퇴사 {
   
    public static void main(String[] args) {
        int n; // 전체 상담 개수
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] t = new int[n+1]; // 각 상담을 완료하는데 걸리는 기간
        int[] p = new int[n+1]; // 각 상담을 완료했을 때 받을 수 있는 금액
        int[] dp = new int[n+1]; // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
        int maxValue = 0;

        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        // 배열을 뒤에서부터 거꾸로 확인
        for (int i = n - 1; i >= 0; i--) {
            int time = t[i] + i;
            // 상담이 기간 안에 끝나는 경우
            if (time <= n) {
                // 점화식에 맞게, 현재까지의 최고 이익 계산
                //i가 현재 (현 상황 1일차, 2일차 ..)
                //dp[4] 4일차에서 얻을 수 있는 최대 값은
                //p[i] (현재 날의 값) + dp[time] (상담 끝나는 날 얻을 수 있는 최대 금액), maxValue
                dp[i] = Math.max(p[i] + dp[time], maxValue);
                maxValue = dp[i];
            }
            // 상담이 기간을 벗어나는 경우
            else dp[i] = maxValue;
        }

        System.out.println(maxValue);
    }
    }
    
