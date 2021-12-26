package greedy;

import java.util.*;

public class Q4만들수없는금액 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		ArrayList<Integer> arr = new ArrayList<>();
		String[] strs = sc.nextLine().split(" ");
		for(int i = 0; i < strs.length; i++) {
			arr.add(Integer.parseInt(strs[i]));
		}
		Collections.sort(arr);
		
		int target = 1;
		
		for(int i = 0; i < N; i++) {
			if(target<arr.get(i)) break;
			target += arr.get(i);
		}
		System.out.println(target);
	}
}
