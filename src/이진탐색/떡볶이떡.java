package 이진탐색;

import java.util.*;
import java.io.*;
class 떡볶이떡{
    public static int N,M;
    public static int[] arr;
    public static int binarySearch(int[] arr, int target, int start, int end){
        if(start > end) return -1;
        int mid = (start + end) /2;
        int cuttedD = getCuttedD(arr,mid);
        if(cuttedD == target) return mid;
        else if(cuttedD > target) return binarySearch(arr, target, mid+1, end);
        else return binarySearch(arr, target, start, mid-1);
        
    }
    public static int getCuttedD(int[] arr, int mid){
        int result = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > mid){
                result += arr[i] - mid;
            }
        }
        return result;
    }
public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] strs = br.readLine().split(" ");
    N = Integer.parseInt(strs[0]);
    M = Integer.parseInt(strs[1]);
    arr = new int[N];
    strs = br.readLine().split(" ");
    for(int i = 0; i < N; i++){
        arr[i] = Integer.parseInt(strs[i]);
    }
    
    int start = 0;
    int end = (int) 1e9;
    int result = 0;
    while(start < end){
        int mid = (start + end) / 2;
        int cuttedD = getCuttedD(arr, mid);
        if(cuttedD < M){
            end = mid-1;
        }else{
            result = mid;
            start = mid + 1;
        }
    }
    System.out.println(result);
    
}
}