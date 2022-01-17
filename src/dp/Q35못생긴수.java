package dp;

import java.util.Scanner;

public class Q35못생긴수 {
    static int n;
    static int[] ugly = new int[1000]; // 못생긴 수를 담기 위한 테이블 (1차원 DP 테이블)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 2배, 3배, 5배를 위한 인덱스
        int i2 = 0, i3 = 0, i5 = 0;
        // 처음에 곱셈 값을 초기화
        int next2 = 2, next3 = 3, next5 = 5;

        ugly[0] = 1;
        for(int i = 1; i < n; i++){
            ugly[i] = Math.min(next2,Math.min(next3,next5));
            
            if(next2 == ugly[i]){
                i2+=1;
                next2 = ugly[i2] * 2;
            }
            if(next3 == ugly[i]){
                i3 += 1;
                next3 = ugly[i3] * 3;
            }
            if(next5 == ugly[i]){
                i5 += 1;
                next5 = ugly[i5] * 3;
            }
        }

        System.out.println(ugly[n-1]);
        
        


    }    
}
