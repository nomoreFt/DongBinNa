package greedy;

import java.util.*;

public class Q2곱하기혹은더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] strs = sc.next().split("");
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(String str : strs) {
			arr.add(Integer.parseInt(str));
		}
		Collections.sort(arr,Collections.reverseOrder());
		
		int result = arr.get(0);
		for(int i = 1; i < arr.size(); i++) {
			int x= arr.get(i);
			if(x == 1 || x == 0) result += x;
			else {
				result *= x;
			}
		}
		System.out.println(result);
	}
}
