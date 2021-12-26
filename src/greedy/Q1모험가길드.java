package greedy;

import java.util.*;

public class Q1모험가길드 {
	public static int N;
	public static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		String[] strs = sc.nextLine().split(" ");
		for(int i = 0 ; i < N; i++) {
			arr.add(Integer.parseInt(strs[i]));
		}
		Collections.sort(arr);
		
		int cnt = 0;
		int result = 0;
		for(int i = 0; i < N; i++) {
			int x = arr.get(i);
			cnt += 1;
			if( cnt >= arr.get(i)) {
				result++;
				cnt = 0;
			}
		}
		System.out.println(result);
		
	}
}
