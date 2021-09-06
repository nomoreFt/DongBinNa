package chapter04;

import java.util.Scanner;
//
public class »óÇÏÁÂ¿ì {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		String[] plans = sc.nextLine().split(" ");
		int x = 1, y = 1;
		//L R U D
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		String[] moveTypes = {"L","R","U","D"};
		
		for(String str : plans) {
			int nextX = 0;
			int nextY = 0;
			for(int i = 0 ; i < 4; i++) {
				if(moveTypes[i].equals(str)) {
					nextX = x + dx[i];
					nextY = y + dy[i];
					break;
				}
			}
			if(nextX < 1 || nextY < 1 || nextX > n || nextY > n ) {
				continue;
			}
			x = nextX;
			y = nextY;
		}
		System.out.println(y + " , " + x);
	}
}
