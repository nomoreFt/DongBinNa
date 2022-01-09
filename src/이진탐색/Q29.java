package 이진탐색;

import java.util.*;

public class Q29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < N; i++){
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);
        
        int start = arr.get(0);
        int end = arr.get(arr.size()-1) - arr.get(0);
        int result = 0;
        
        while(start <= end){
            int mid = (start + end) / 2;
            int cnt = 1;
            int value = arr.get(0);
            for(int i = 1; i < N; i++){
                if(arr.get(i) >= mid + value){
                    value = arr.get(i);
                    cnt += 1;
                }
            }
            
            if(cnt >= C){
                start = mid +1;
                result = mid;
            }else{
                end = mid - 1;
            }

        }
        System.out.println(result);
        
    }
    
}
