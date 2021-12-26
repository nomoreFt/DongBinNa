package greedy;

import java.util.*;

public class Q5볼링공고르기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] strs = sc.nextLine().split(" ");
		
		int N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		strs = sc.nextLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(strs[i]));
		}
		int cnt = 0;
		
		for(int i = 0; i < N; i++ ) {
			for(int j = i+1; j < N; j++) {
				if(arr.get(i) != arr.get(j)) cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
	}
	
	
}
