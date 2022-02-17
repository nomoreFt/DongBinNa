package 위상정렬TopologySort;

import java.util.*;

public class test{
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
         int max = -1000001;
         int idx = 0;
        for(int i = 0; i <= 8; i++){
            int x = sc.nextInt();
            int temp = max;
            max = Math.max(max,x);
            if(temp != max) idx = i;
        }
        System.out.println(max);
        System.out.println(idx+1);
		
	}
}