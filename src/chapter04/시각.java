package chapter04;

import java.util.Scanner;

public class 시각 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		for(int i = 0 ; i <= N; i++) {
			for(int j = 0; j <= 59; j++ ) {
				for(int k = 0; k <= 59; k++) {
					String str = Integer.toString(i)+Integer.toString(j)+Integer.toString(k);
					if(str.contains("3")) {
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}
