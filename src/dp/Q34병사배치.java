package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q34병사배치 {
    static int N;
    static ArrayList<Integer> v = new ArrayList<Integer>();
    static int[] dp;
    static BufferedReader br;
    public static void main(String[] args) throws Exception{
        try {
            br = new BufferedReader(new InputStreamReader(System.in));    
            N = Integer.parseInt(br.readLine());
            String[] strs = br.readLine().split(" ");
            for(int i = 0; i < N; i++){
                v.add(Integer.parseInt(strs[i]));  
            }
            
            Collections.reverse(v);
            dp = new int[N];

            Arrays.fill(dp, 1);
            //dp[x] : x번째 수를 마지막 원소로 가지는 lis의 길이 
            for(int i = 1; i < N; i++){
                for(int j = 0; j < i; j++){
                    if(v.get(j) < v.get(i)){
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
            }

int maxValue = 0;
        for (int i = 0; i < N; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        System.out.println(N - maxValue);
            
        } catch (Exception e) {
        }finally{
            br.close();
        }   
        
        

    }
}
