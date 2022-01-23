package 이진탐색;

import java.util.*;

public class 랜선자르기 {
    static int K, N;
    static long right;
    static int[] arr;
    static long upperBound(int[] arr, int target){
        //target = 토막 개수
        //토막 낼 수 있는 개수중에 최대값 구하기
        long left = 0;
        //right 는 랜선 최대길이
        while(left < right){
            long mid = (left + right) / 2;
            long count = getCount(arr,mid);
            if(count < target){//토막 11개목표보다 적게 나왔다 = 너무 길게 자름. 길이 줄일 필요
                right = mid;
            }else{//토막과 같거나 토막이 더 많이 나왔다 = 길이가 작다. 더 늘려주자
                left = mid + 1;
            }
        }
        return left;
        }
        static long getCount(int[] arr,long mid){
            long result = 0;
            for(int i = 0; i < arr.length; i++){
                result += (long)arr[i]/mid;
            }
            return result;
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();//총 랜선 개수
        N = sc.nextInt();//필요한 토막개수
        arr = new int[K];
        right = 0;
        for(int i = 0; i < K; i++){
            arr[i] = sc.nextInt();
            right = Math.max(right, arr[i]);
        }
        right++;
        System.out.println(upperBound(arr, N)-1);
        
    }
}