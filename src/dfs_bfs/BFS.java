package dfs_bfs;

import java.util.*;
//////
public class BFS {
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static boolean[] visited = new boolean[9];
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			System.out.print(now + " ");
			
			for(int i = 0; i < graph.get(now).size(); i++ ) {
				int y = graph.get(now).get(i);
				
				if(!visited[y]) {
					visited[y] = true;
					q.offer(y);
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 9; i++) {
			graph.add(new ArrayList<Integer>());
		}
	    // ��� 1�� ����� ��� ���� ���� 
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);
        
        // ��� 2�� ����� ��� ���� ���� 
        graph.get(2).add(1);
        graph.get(2).add(7);
        
        // ��� 3�� ����� ��� ���� ���� 
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        
        // ��� 4�� ����� ��� ���� ���� 
        graph.get(4).add(3);
        graph.get(4).add(5);
        
        // ��� 5�� ����� ��� ���� ���� 
        graph.get(5).add(3);
        graph.get(5).add(4);
        
        // ��� 6�� ����� ��� ���� ���� 
        graph.get(6).add(7);
        
        // ��� 7�� ����� ��� ���� ���� 
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        
        // ��� 8�� ����� ��� ���� ���� 
        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1);
	}

}
