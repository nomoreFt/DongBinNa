package greedy;

import java.util.Scanner;

public class _1이될때까지 {
    static int[] alpha = new int[200];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int k = sc.nextInt();
        int cnt = 0;
        while(n != 1){
            if(n % k == 0){
                n = n / k;
                cnt += 1;
            }else{
                n -= 1;
                cnt += 1;
            }
        }
        System.out.println(cnt);
}
}
