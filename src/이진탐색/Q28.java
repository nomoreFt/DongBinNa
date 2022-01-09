package 이진탐색;

import java.util.*;

public class Q28 {
    public static int binarySearch(int[] arr, int start, int end){
        while(start < end){
            int mid = (start + end) /2;
            if(arr[mid] == mid) return mid;
            else if (arr[mid] < mid) start = mid +1;
            else end = mid;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int N = Integer.parseInt(strs[0]);
        strs = sc.nextLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0; i< N; i++){
            arr[i] = Integer.parseInt(strs[i]);
        }
        int answer = binarySearch(arr, 0, N);
        System.out.println(answer);
    }
}
