package chapter04;

import java.util.*;

public class Q7��Ű��Ʈ����Ʈ {
	public static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int left = 0;
		int right = 0;
		String[] strs = String.valueOf(N).split("");
		
		for(int i = 0; i < strs.length; i++) {
			if(i < strs.length/2) {
				left += Integer.parseInt(strs[i]);
			}else {
				right += Integer.parseInt(strs[i]);
			}
		}
		
		if(left == right) System.out.println("LUCKY");
		else System.out.println("READY");
	}

}
