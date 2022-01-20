package 이진탐색;

import java.util.*;

public class 숫자카드2 {
    static int n,m;
    static int[] arr;
    static int lowerBound(int[] arr, int target){
        int start = 0;
        int end = arr.length;
        
        while(start < end){
            int mid = (start + end) / 2;
            
            //찾고자 하는 값이 중간값보다 같거나 왼쪽인 경우
            if( target <= arr[mid]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
    static int upperBound(int[] arr, int target){
        int start = 0;
        int end = arr.length;
        while(start < end){
            int mid = (start + end) / 2;
            //찾고자 하는 값이 중간값보다 왼쪽이면 
            if(target < arr[mid]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        
        m = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < m; i++){
            int target = sc.nextInt();
            sb.append(upperBound(arr , target) - lowerBound(arr, target) + " ");
        }
        sc.close();
        System.out.print(sb.toString());
    }
}
