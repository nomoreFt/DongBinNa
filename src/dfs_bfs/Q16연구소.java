package dfs_bfs;

import java.util.*;

public class Q16연구소 {
	public static int n,m;
	public static int[][] graph = new int[9][9];
	public static int[][] temp = new int[9][9];
	public static int result = 0;
	
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	
	public static void virus(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];
			if(nX < 0 || nX >= n || nY < 0 || nY >= m) continue;
			if(temp[nX][nY] == 0) {
				temp[nX][nY] = 2;
				virus(nX,nY);
			}
			
		}
	}
	
	public static int getScore() {
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(temp[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void dfs(int count) {
		if(count == 3) {
			//3개면 2 채워넣기
			for(int i = 0 ; i < n; i++) {
				for(int j = 0 ; j < m; j++) {
					temp[i][j] = graph[i][j];
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m ; j++) {
					if(temp[i][j] == 2) {
						virus(i, j);
					}
				}
			}
			result = Math.max(result, getScore());
			return;
		}
		//울타리 ++ 넘기기
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(graph[i][j] == 0) {
					graph[i][j] = 1;
					count++;
					dfs(count);
					graph[i][j] = 0;
					count--;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j < m; j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		dfs(0);
		System.out.println(result);
	}

}
