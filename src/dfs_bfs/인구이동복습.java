package dfs_bfs;

import java.util.*;
import java.io.*;

class Union{
	int x;
	int y;
	int members;

	public Union(int x, int y, int members) {
		this.x = x;
		this.y = y;
		this.members = members;
	}
	
}

public class 인구이동복습 {
	public static int answer = 0;
	public static int N,L,R;
	public static int[][] graph;
	public static int[][] union;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	
	
	public static void bfs(int x, int y, int unionCnt) {
		Queue<Union> q = new LinkedList<>();
		ArrayList<Union> unions = new ArrayList<>();
		q.offer(new Union(x,y,graph[x][y]));
		unions.add(new Union(x,y,graph[x][y]));
		graph[x][y] = unionCnt;
		int sum = graph[x][y];
		int count = 1;
		while(!q.isEmpty()) {
			Union p = q.poll();
			for(int i = 0; i < 4; i++) {
				int nX = p.x + dx[i];
				int nY = p.y + dy[i];
				if(nX < 0|| nX >=N || nY < 0 || nY >= N) continue;
				if(union[nX][nY] == -1) {
					int gap = Math.abs(graph[p.x][p.y] - graph[nX][nY]);
					if(gap >= L && gap <= R ) {
						unions.add(new Union(nX,nY,graph[nX][nY]));
						union[nX][nY] = unionCnt;
						q.offer(new Union(nX,nY,graph[nX][nY]));
						sum += graph[nX][nY];
						count += 1;
				}
				}
			}
		}
		for(int i = 0 ; i < unions.size(); i++) {
			Union u = unions.get(i);
			graph[u.x][u.y] = sum/count;
		}
	}
	
	public static int result = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		L = Integer.parseInt(strs[1]);
		R = Integer.parseInt(strs[2]);
		graph = new int[N][N];
		union = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for(int j = 0 ; j < N; j++) {
				graph[i][j] = Integer.parseInt(strs[j]);
			}
		}
		//셋팅
		
		while(true) {
			int unionCnt = 0;
			int idx = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					union[i][j] = 0;
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(union[i][j] == 0) {
						bfs(i,j,unionCnt+1);
							idx += 1;
						
					}
				}
			}
			
			
			if(idx == N*N) {
				System.out.println(result);
				return;
			}
			
			result += 1;
		}
	}

}
