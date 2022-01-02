package 이진탐색;

import java.util.*;
import java.io.*;
class 부품찾기{
    public static boolean binaraySearch(int[] arr, int target, int start, int end){
        if(start > end) return false;
        int mid = (start + end) /2;
        if(arr[mid] == target) return true;
        else if(arr[mid] > target) return binaraySearch(arr, target, start, mid-1);
        else return binaraySearch(arr, target, mid+1, end);
    }
    public static int N,M;
    public static int[] arr1,arr2;
    
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        strs = br.readLine().split(" ");
        arr1 = new int[N];
        for(int i = 0; i < N; i++){
            arr1[i] = Integer.parseInt(strs[i]);
        }
        strs = br.readLine().split(" ");
        M = Integer.parseInt(strs[0]);
        strs = br.readLine().split(" ");
        arr2 = new int[M];
        for(int i = 0; i < M; i++){
            arr2[i] = Integer.parseInt(strs[i]);
        }

        ////기본조건 끝 ^^
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; ++i){
            boolean result = binaraySearch(arr1, arr2[i], 0, N-1);
            if(result) sb.append("yes ");
            else sb.append("no ");
        }
        
        System.out.println(sb.toString());
       
    }
}