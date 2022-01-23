package 이진탐색;

import java.util.*;

public class 수찾기 {
    static int n,m;
    static int[] arr;
    static int binarySearch(int[] arr, int start, int end, int target){
        while(start <= end){
            int mid = (start + end) / 2;
            
            if(arr[mid] == target) return 1;
            else if (target < arr[mid] ) end = mid -1;
            else start = mid +1;
        }
        return 0;
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
        for(int i = 0; i < m; i++){
            int target = sc.nextInt();
            System.out.println(binarySearch(arr, 0, n-1, target));
        }
    }
}
