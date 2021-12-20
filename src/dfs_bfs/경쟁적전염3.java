package dfs_bfs;

import java.util.*;
import java.io.*;

class Virusv implements Comparable<Virusv>{
	int x;
	int y;
	int value;
	int time;
	public Virusv(int x, int y, int value, int time) {
		this.x = x;
		this.y = y;
		this.value = value;
		this.time = time;
	}
	@Override
	public int compareTo(Virusv other) {
		return this.value - other.value;
	}
}

public class ∞Ê¿Ô¿˚¿¸ø∞3 {
	public static int N,K,S,X,Y;
	public static ArrayList<Virusv> Virusves = new ArrayList<Virusv>();
	public static int[][] graph;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
	
		graph = new int[N][N];
		
		for(int i = 0; i <N; i++ ) {
			strs = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(strs[j]);
				if(graph[i][j] != 0) Virusves.add(new Virusv(i,j,graph[i][j],0));
			}
		}
		Collections.sort(Virusves);
		strs = br.readLine().split(" ");
		S = Integer.parseInt(strs[0]);
		X = Integer.parseInt(strs[1]);
		Y = Integer.parseInt(strs[2]);
		
		Queue<Virusv> q = new LinkedList<Virusv>();
		for(int i = 0; i < Virusves.size(); i++) {
			q.offer(Virusves.get(i));
		}
		while(!q.isEmpty()){
			Virusv v = q.poll();
			if(v.time == S) break;
				for(int i = 0; i < 4; i++) {
					int nX = v.x + dx[i];
					int nY = v.y + dy[i];
					if(nX<0||nX>=N||nY<0||nY>=N) continue;
					if(graph[nX][nY] == 0) {
						graph[nX][nY] = v.value;
						q.offer(new Virusv(nX,nY,v.value,v.time+1));	
					}
					
				}
		}
		if(graph[X-1][Y-1] !=0) System.out.println(graph[X-1][Y-1]);
		else System.out.println(0);
	}

}
