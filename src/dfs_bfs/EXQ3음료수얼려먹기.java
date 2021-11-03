package dfs_bfs;

import java.util.*;

public class EXQ3음료수얼려먹기 {
	public static int N,M;
	public static int[][] graph = new int[1001][1001];
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,-1,0,1};
	
	public static int cnt = 0;
	
	public static boolean dfs(int x, int y) {
		if(graph[x][y] == 1) return false;
		
		if(graph[x][y] == 0) {
			graph[x][y] = 1;
			for(int i = 0 ; i < 4; i++) {
				int nX = x + dx[i];
				int nY = y + dy[i];
				if((nX < 0||nX >= N|| nY < 0 || nY >= M)) continue;
				dfs(nX,nY);
			}
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine(); 
		for(int i = 0 ; i < N; i++) {
			String[] str = sc.nextLine().split("");
			for(int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for(int i = 0 ; i< N; i++) {
			for(int j = 0; j < M; j++) {
				if(dfs(i,j)) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}


//4 5
//00110
//00011
//11111
//00000


/*
15 14
00000111100000
11111101111110
11011101101110
11011101100000
11011111111111
11011111111100
11000000011111
01111111111111
00000000011111
01111111111000
00011111111000
00000001111000
11111111110011
11100011111111
11100011111111
*/