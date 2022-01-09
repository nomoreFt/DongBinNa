package 이진탐색;

import java.util.*;

public class Q27 {
    public static int leftIdx(int[] arr, int target, int start, int end){
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] >= target){// target이 mid 왼쪽이거나 같을 경우
                end = mid;
            }else{//target이 중간값보다 오른쪽일경우
                start = mid+1;
            }
        }
        return end;
    }
    public static int rightIdx(int[] arr, int target, int start, int end){
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] > target){// target이 mid 왼쪽일경우
                end = mid;
            }else{//target이 중간값보다 오른쪽이거나 같을 경우
                start = mid+1;
            }
        }
        return end;
    }
    public static int getCnt(int[] arr, int target, int start, int end){
        int leftIdx = leftIdx(arr, target, start, end);
        int rightIdx = rightIdx(arr,target,start,end);
        return rightIdx - leftIdx;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int N = Integer.parseInt(strs[0]);
        int target = Integer.parseInt(strs[1]);

        strs = sc.nextLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0; i< N; i++){
            arr[i] = Integer.parseInt(strs[i]);
        }
        
        int cnt = getCnt(arr,target,0,arr.length);
        if(cnt == 0) System.out.println("-1");
        else{
            System.out.println(cnt);
        }
        
    }    
}
