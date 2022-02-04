package greedy;

import java.io.IOException;
import java.util.*;

public class 큰수의법칙 {
    static int[] alpha = new int[200];
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            
            ArrayList<Integer> arr = new ArrayList<>();
            while(sc.hasNextInt()){
                arr.add(sc.nextInt());
            }
            Collections.sort(arr);
            
            int result = 0;
            for(int i = 1; i <= m; i++){
                if(i % k == 0){
                    result += arr.get(arr.size()-2);
                }else{
                    result += arr.get(arr.size()-1);
                }
            }
            System.out.println(result);
    }
}
