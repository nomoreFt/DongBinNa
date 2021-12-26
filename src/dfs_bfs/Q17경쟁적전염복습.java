package dfs_bfs;

import java.util.*;

class Position{
	int x;
	int y;
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Q17경쟁적전염복습 {
	public static int[][] graph = new int[201][201];
	public static int N,K,S,X,Y;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] strs = sc.nextLine().split(" ");
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		
		int index = 1;
		for(int i = 1 ; i <= N; i++) {
			strs = sc.nextLine().split(" ");
			for(int j = 1 ; j <= N; j++) {
				graph[i][j] = Integer.parseInt(strs[j-1]);
			}
		}
		strs = sc.nextLine().split(" ");
		S = Integer.parseInt(strs[0]);
		X = Integer.parseInt(strs[1]);
		Y = Integer.parseInt(strs[2]);
		
		for(int i = 1 ; i <= S; i++) {
			process();
		}
		System.out.println(graph[X][Y]);
	}
	public static void process() {
		for(int i = 1; i <= K; i++ ) {
			Queue<Position> q = new LinkedList<>();
			for(int j = 1; j <= N; j++) {
				for(int k = 1; k <= N; k++) {
					if(graph[j][k] == i) {
						q.add(new Position(j,k));
					}
				}
			}
			while(!q.isEmpty()) {
				Position ps = q.poll();
				int x = ps.x;
				int y = ps.y;
				for(int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if(nx < 1 || nx >N || ny < 1 || ny > N) continue;
					if(graph[nx][ny] == 0) {
						graph[nx][ny] = i;
					}
				}
			}
		}
	}

}
